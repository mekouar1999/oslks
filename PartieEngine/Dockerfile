FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/Moteur-1.jar
COPY ${JAR_FILE} Moteur.jar
ENTRYPOINT java -jar /Moteur.jar $SERVER_IP