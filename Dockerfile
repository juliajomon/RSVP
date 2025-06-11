# Use Java 21 base image
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy project files
COPY . .

# Make wrapper executable and build
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Expose Spring Boot default port
EXPOSE 8843

CMD ["java", "-jar", "target/RSVP-0.0.1-SNAPSHOT.jar"]
