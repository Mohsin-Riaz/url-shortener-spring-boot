# Use a Maven image with Java 21
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the src directory
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use Eclipse Temurin JRE 21 for the final image
FROM eclipse-temurin:21-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar


# Expose the port the app runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]