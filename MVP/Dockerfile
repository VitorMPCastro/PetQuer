# Use a base image with Java runtime
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Set JAVA_HOME environment variable
ENV JAVA_HOME=/usr/local/openjdk-17

# Copy the jar file to the container
COPY build/libs/petquer-0.0.2-SNAPSHOT-USERDB.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
