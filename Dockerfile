FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ashan.jar
ENTRYPOINT ["sh", "-c", "java -jar /ashan.jar"]
