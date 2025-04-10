# Use OpenJDK base image
FROM openjdk:21-jdk-slim

# Set environment variable
ENV APP_HOME=/app
WORKDIR $APP_HOME

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]