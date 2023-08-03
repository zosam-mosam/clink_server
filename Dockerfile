# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk/openjdk11

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY clink-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will listen on
EXPOSE 8080

# Define environment variables (if needed)
# ENV ENV_VARIABLE_NAME value

# Run the JAR file
CMD ["java", "-jar", "app.jar", "--spring.config.location=file:/home/ubuntu/property/application.properties"]