# Use an official Maven image as the base image
FROM maven:3.8.3-openjdk-11-slim

 

# Set the working directory inside the container
WORKDIR /app

 

# Copy the pom.xml file to the container's working directory
COPY pom.xml .

 

# Copy the rest of the project files to the container's working directory
COPY src/ /usr/share/maven
 

# Build the Maven project
RUN mvn clean install

 

# Specify the command to run when the container starts
CMD ["java", "-jar", "target/your-app.jar"]
