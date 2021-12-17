FROM openjdk:8
EXPOSE 8080
ADD target/demoticadashboard-temperatureservice.jar demoticadashboard-temperatureservice.jar
ENTRYPOINT ["java","-jar","/demoticadashboard-temperatureservice.jar"]
