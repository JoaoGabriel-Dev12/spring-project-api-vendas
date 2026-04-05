FROM maven:3.9.9-amazoncorretto-21 AS build 

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim 

EXPOSE 8080

COPY --from=build /app/target/vendas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]