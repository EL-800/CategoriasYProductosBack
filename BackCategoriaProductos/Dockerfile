FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/practicaCRUD-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} back_catproductos.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "back_catproductos.jar"]