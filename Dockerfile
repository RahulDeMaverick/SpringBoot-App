# Use the official OpenJDK 17 as the base image
FROM openjdk:17-oracle
# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/Demo-0.0.1-SNAPSHOT.jar /app/Demo-0.0.1-SNAPSHOT.jar

# Expose the port your application is running on
EXPOSE 8080

# Set the entrypoint command to run your application
ENTRYPOINT ["java", "-jar", "/app/Demo-0.0.1-SNAPSHOT.jar"]