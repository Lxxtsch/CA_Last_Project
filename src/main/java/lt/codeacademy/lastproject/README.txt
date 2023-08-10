# Fitness Tracking App

This project is a fitness tracking application that allows users to monitor their health data and set fitness goals.

## Features

- User registration and login
- Record and view health data (weight, body fat, blood pressure, water intake)
- Set and track fitness goals
- Different user roles (Manager, Admin) for access control

## Getting Started

### Prerequisites

- Java 8 or higher
- Spring Boot
- MySQL or PostgreSQL

### Installation

1. Clone the repository.
2. Configure your database settings in `application.properties`.
3. Build and run the application.

## Usage

1. Record your health data and set fitness goals.
2. View your progress and track your fitness journey.

## Endpoints

- `GET /api/health-data/user/{userId}`: Get health data for a specific user.
- `GET /api/fitness-goals/user/{userId}`: Get fitness goals for a specific user.
- `POST /api/health-data/user/{userId}`: Add health data for a user.
- `POST /api/fitness-goals/user/{userId}`: Add a fitness goal for a user.

## Authentication and Authorization

- Manager role can access and manage all user data except deletion.
- Admin role has full access to all data.

## Technologies Used

- Java
- Spring Boot
- MySQL or PostgreSQL
- Spring Security

## Contact

For any inquiries or feedback, please contact [your email address].