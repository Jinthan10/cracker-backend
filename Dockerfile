# Use Ubuntu as the base image
#FROM ubuntu:20.04

# Install Java and Maven
#RUN apt-get update && apt-get install -y \
#    openjdk-17-jdk \
#    maven \
#    && rm -rf /var/lib/apt/lists/*

# Set environment variables for Java
#ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
#ENV PATH="$JAVA_HOME/bin:$PATH"

# Set the working directory
#WORKDIR /app

# Copy the Maven project files into the image
#COPY pom.xml .
#COPY src ./src

# Build the project using Maven
#RUN mvn clean install

# Copy the JAR file (optional if already built)
# COPY app/target/crackerapp-0.0.1-SNAPSHOT.jar crackerapp-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
# Run the application
#ENTRYPOINT ["java", "-jar", "crackerapp-0.0.1-SNAPSHOT.jar"]
# Use Ubuntu 20.04 as the base image
FROM ubuntu:20.04

# Install Java 17 and Maven
RUN apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get install -y \
    openjdk-17-jdk \
    maven \
    && rm -rf /var/lib/apt/lists/*

# Set environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

# Set the working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the JAR file
RUN mvn clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Use ENTRYPOINT with the actual JAR file name
# You can use a wildcard if needed
ENTRYPOINT ["java", "-jar", "target/crackerapp-0.0.1-SNAPSHOT.jar"]

