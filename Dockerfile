FROM maven:3.9-eclipse-temurin-20 as build
COPY . /app
WORKDIR /app
RUN mvn clean package


FROM eclipse-temurin:20.0.1_9-jre-jammy
COPY --from=build /app/target/*.jar /app/postservice.jar
ENV PORT 8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/postservice.jar"]
