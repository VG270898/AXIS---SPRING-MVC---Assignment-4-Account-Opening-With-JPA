FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} accountOpening.jar
ENTRYPOINT ["java","-jar","/accountOpening.jar"]
