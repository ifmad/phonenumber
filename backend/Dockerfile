FROM maven:3.6.0-jdk-8-alpine

WORKDIR /code

COPY pom.xml .
COPY src/ ./src/

ENTRYPOINT mvn test
