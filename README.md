# VoucherApp Microservice

This project is a Spring Boot microservice for managing vouchers. It provides a RESTful API for creating, reading, updating, and deleting vouchers. This service is part of a larger microservices-based application.

## Features

*   **CRUD Operations:** Full support for creating, reading, updating, and deleting vouchers.
*   **RESTful API:** A comprehensive set of API endpoints for interacting with the voucher data.
*   **Database Integration:** Uses Spring Data JPA to connect to a MySQL database.
*   **Security:** Secured endpoints using Spring Security with role-based access control (USER and ADMIN roles).

## Microservices Architecture

This `voucher_app` is designed to work as a component in a microservices ecosystem. It is intended to be used alongside other services, such as the `product_app_microservice`.

The `product_app_microservice` can be found at the following repository:
[https://github.com/MohamedEzzatMohamed/product_app_microservie](https://github.com/MohamedEzzatMohamed/product_app_microservie)

Together, these services form a basic e-commerce backend system where one service manages products and this service manages discount vouchers.

## Getting Started

### Prerequisites

*   Java 17 or later
*   Maven
*   MySQL Server

### Configuration

1.  Clone the repository:
    ```bash
    git clone <repository-url>
    ```
2.  Open `src/main/resources/application.properties` and configure your MySQL database connection:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/voucher_app
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    ```
3.  Ensure you have a database named `voucher_app` in your MySQL server.

### Running the Application

You can run the application using the following Maven command:
```bash
mvn spring-boot:run
```
The application will start on `http://localhost:8080`.

## API Endpoints

The following are the primary endpoints provided by this service:

*   `GET /voucherapi/vouchers`: Get all vouchers (Requires ADMIN role).
*   `GET /voucherapi/vouchers/{code}`: Get a specific voucher by its code (Requires USER or ADMIN role).
*   `POST /voucherapi/vouchers`: Create a new voucher.
*   `PUT /voucherapi/vouchers/{id}`: Update an existing voucher.
*   `DELETE /voucherapi/vouchers/{id}`: Delete a voucher.
