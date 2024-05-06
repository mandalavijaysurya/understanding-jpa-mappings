
FROM amazoncorretto:17
ENV DB_USERNAME chintu
ENV DB_PASSWORD root
ENV DB_HOST localhost
ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
CMD apt-get update -y
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]