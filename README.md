# School Management API

This API is based on a technical challenge from YouTube, which I decided to implement with various additional features and improvements.

## Project Overview

This project is a School Management API that provides endpoints for managing students, registrations, and courses. It's built using Spring Boot and includes several enhancements beyond the original challenge requirements.

## Key Features

- CRUD operations for Students
- CRUD operations for Registrations
- Advanced search functionality
- Swagger UI for API documentation and testing
- Docker support for easy deployment

## Project Structure

The main components of the project are:

- `src/`
  - `SearchController.java`: Handles search operations across different entities
  - `StudentController.java`: Manages student-related operations
  - `RegistrationController.java`: Handles registration-related operations
- `docker-compose.yml`: Defines the Docker services for the application

## Getting Started

1. Clone the repository
2. Navigate to the project directory
3. Run `docker-compose up` to start the database
4. Run the Spring Boot application

## API Documentation

The API is documented using Swagger UI. Once the application is running, you can access the Swagger UI at:

http://localhost:8080/swagger-ui.html

plainText

This provides an interactive interface to explore and test all available endpoints.

## Technologies Used

- Spring Boot
- PostgreSQL
- Docker
- Swagger

## Improvements and Additional Features

- Implemented Swagger for better API documentation and testing
- Added Docker support for easier deployment and database setup
- Enhanced search functionality across multiple entities
- Improved error handling and response structures
