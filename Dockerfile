#FROM ubuntu:latest
#LABEL authors="jorge.ralvarez"
#
#ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} customer.jar
ENTRYPOINT ["java","-jar","/customer.jar"]