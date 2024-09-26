FROM ubuntu:latest
LABEL authors="jorge.ralvarez"

ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/customer.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
