FROM maven:3.9.16-eclipse-temurin-17 as build

WORKDIR app

COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

COPY src ./src

RUN ./mvnw dependency:go-offline
RUN ./mvnw clean package -DskipTests -B

FROM eclipse-temurin:17-jre

WORKDIR app

COPY --from=build ./app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
