FROM eclipse-temurin:17
LABEL maintainer="xyz@gmail.com"
WORKDIR /app
COPY target/SpringBootCrud.jar /app/SpringBootCrud.jar
ENTRYPOINT ["java","-jar","SpringBootCrud.jar"]