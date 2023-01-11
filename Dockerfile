FROM maven:3.8.5-openjdk-17-slim AS build
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17
COPY --from=build /home/app/target/ref-data-service-0.0.1-SNAPSHOT.jar /usr/local/lib/service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/service.jar"]