FROM eclipse-temurin:17
RUN apt-get install curl
VOLUME /tmp
EXPOSE 8080
ADD target/demo-aws.jar demo-aws.jar
ENTRYPOINT ["java","-jar","/demo-aws.jar"]