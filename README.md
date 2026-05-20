# Learning Spring boot with Java

## Overview

This is a demo application built using Spring Boot. It is designed for managing and interacting with data via a web
service, leveraging Spring Data JPA for data persistence and working with a MySQL database.

## Features

- RESTful API services for interacting with the application.
- Integration with MySQL database.
- Development with Spring DevTools for enhanced developer experience.

## Prerequisites

Ensure the following prerequisites are installed on your system:

- Java 17 or later.
- Maven.
- MySQL database setup.

## Getting Started

### Steps to Run the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd demo-app
   ```
3. Configure the `application.properties` file to match your database setup (located in `src/main/resources`):
   ```properties
   spring.datasource.url=jdbc:mysql://<db-host>:<db-port>/<db-name>
   spring.datasource.username=<db-username>
   spring.datasource.password=<db-password>
   ```
4. Build the project:
   ```bash
   mvn clean package
   ```
5. Run the application:
   ```bash
   java -jar target/demo-app-0.0.1-SNAPSHOT.jar
   ```

## Additional Resources

- [Spring Boot Maven Plugin Documentation](https://docs.spring.io/spring-boot/4.0.5/maven-plugin)
- [Spring Data JPA Guide](https://spring.io/guides/gs/accessing-data-jpa/)
- [Building RESTful Web Services](https://spring.io/guides/gs/rest-service/)

Enjoy building and extending the demo app!
