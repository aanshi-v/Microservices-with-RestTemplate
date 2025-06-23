# Microservices Project using Spring Boot

This project demonstrates a simple microservices architecture with **two Spring Boot services**: `user-service` and `order-service`. It uses **REST APIs**, **Spring Data JPA**, **MySQL**, and **RestTemplate** for inter-service communication.

---

## 🧩 Project Structure
microservices-project/
├── user-service/ # Handles user registration
└── order-service/ # Manages product orders linked to users



---

## 📦 Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- RestTemplate (for inter-service REST communication)
- Hibernate Validator (for field validations)

---

## 🔗 Service Communication

The `order-service` communicates with the `user-service` using `RestTemplate` to fetch user details while processing orders.

---

## ✅ Features Implemented

- Create and fetch **Users** with:
  - `@Email` validation
  - `@NotNull` validation
  - Unique email constraint
  - Auto-generated ID

- Create and fetch **Orders**:
  - Each order is linked to a `userId`
  - Combines user data via inter-service REST call using `RestTemplate`

---

🔍 Example API Payloads
POST /users
{
  "name": "John Doe",
  "email": "john.doe@example.com"
}

POST /orders
{
  "product": "Mobile Phone",
  "userId": 1
}

GET /orders/{id}
{
  "order": {
    "id": 1,
    "product": "Mobile Phone",
    "userId": 1
  },
  "user": {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
}


---



user-service/
Handles user registration

Validates email format and uniqueness

Stores data in users table

order-service/
Accepts order creation

Fetches user data using RestTemplate

Combines data and returns a composite response












