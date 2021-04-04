
FROM gradle:6.8.3-jdk11-hotspot AS development
LABEL maintainer=https://github.com/jinkyuhan
EXPOSE 8080 5080
WORKDIR /email-app
COPY ./email .
CMD ["gradle", "bootRun", "-PjvmArgs=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5080"]

FROM openjdk:11.0.10-slim-buster AS production

WORKDIR /email-app
COPY ./email .
# RUN ./gradlew build --no-daemon
CMD ["java", "-jar", "-Djava.security.egd", "-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "/email-service.jar"]
