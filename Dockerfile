FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} board.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/board.jar"]