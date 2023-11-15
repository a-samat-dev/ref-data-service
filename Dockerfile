FROM eclipse-temurin:17
RUN apt-get install curl
VOLUME /tmp
EXPOSE 8080
ADD target/ref-data-service.jar ref-data-service.jar
ENTRYPOINT ["java","-jar","/ref-data-service.jar"]