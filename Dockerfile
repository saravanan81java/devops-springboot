FROM openjdk:latest
EXPOSE 8081
ADD target/devops-springboot-integration.jar devops-springboot-integration.jar
ENTRYPOINT ["java", "-jar", "/devops-springboot-integration.jar"]
