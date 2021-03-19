FROM openjdk:11.0.10-slim-buster

WORKDIR /email-app
COPY . .
RUN ./gradlew build --no-daemon
CMD ["java", "-jar", "build/libs/email-0.0.1-SNAPSHOT.jar']
