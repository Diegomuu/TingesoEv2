FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} gateway.jar
ENTRYPOINT ["java", "-jar","/gateway.jar"]