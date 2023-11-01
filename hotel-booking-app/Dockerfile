#FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#
#COPY ./ ./
#
#RUN mvn install package
#
FROM openjdk:17-alpine

#COPY --from=MAVEN_BUILD /hotel-booking-app/target/demo-0.0.1-SNAPSHOT.jar /demo.jar
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
#FROM maven:3.8.5-openjdk-17
#
#WORKDIR /hotel-booking-app
#COPY . .
#RUN mvn clean install
#
#CMD mvn spring-boot:run