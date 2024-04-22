FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY ./target/app-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that the Spring Boot app will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
