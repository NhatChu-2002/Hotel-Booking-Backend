#
#FROM openjdk:17-alpine
#
#ADD target/*.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]



FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

RUN mv target/*.jar app.jar

FROM openjdk:17-alpine

COPY --from=MAVEN_BUILD /app/app.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]