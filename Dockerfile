FROM openjdk:18.0.2.1-jdk-bullseye
COPY "./target/demo-0.0.1-SNAPSHOT.jar" "app.jar"

EXPOSE 8081
WORKDIR "/app"

ENTRYPOINT ["java","-jar","app.jar"]