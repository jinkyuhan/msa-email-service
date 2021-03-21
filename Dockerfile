
FROM openjdk:11.0.10-slim-buster AS development
WORKDIR /email-app
COPY ./email .
CMD ["./gradlew", "bootRun"]


FROM openjdk:11.0.10-slim-buster AS production

WORKDIR /email-app
COPY ./email .
RUN ./gradlew build --no-daemon
CMD ["java", "-jar", "build/libs/email-0.0.1-SNAPSHOT.jar']
