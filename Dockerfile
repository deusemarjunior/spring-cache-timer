FROM openjdk:8u191-jdk-alpine3.9
LABEL maintainer="chavess.djr@gmail.com"

ENV LANG C.UTF-8

RUN apk add --update bash

ADD target/spring-cache-timer*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
