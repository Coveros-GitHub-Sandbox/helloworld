#
# Build stage
#
FROM maven:3.8.5-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/helloworld-1.1.jar /usr/local/lib/demo.jar
ENTRYPOINT [ "java", "-cp", "/usr/local/lib/demo.jar", "com.coveros.demo.helloworld.HelloWorld" ]