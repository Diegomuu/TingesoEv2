FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} eureka.jar
ENTRYPOINT ["java", "-jar","/eureka.jar"]