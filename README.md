## Project Overview

This repository contains a monolithic REST API built with Spring Boot. It was developed as part of a university assignment to demonstrate proficiency in building scalable, RESTful web services. The application aggregates multiple domain-specific modules—Library, Student Management, Restaurant Menu, E-Commerce, Task Management, and User Profiles—into a single unified codebase.

Each module represents a specific problem statement from the assignment, showcasing different aspects of REST API design, including CRUD operations, complex filtering, pagination, and custom response wrapping.

## Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot 
* **Build Tool:** Maven
* **Testing:** Postman

## Setup & Installation

Follow these steps to get the project up and running locally.

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/university-rest-api-assignment.git
cd university-rest-api-assignment

```

### 2. Build the Project

Ensure you have Maven installed, then run:

```bash
mvn clean install

```

### 3. Run the Application

```bash
mvn spring-boot:run

```

The API will be available at `http://localhost:8080`.

---

## API Documentation

### Question 1: Library Book Management API

**Base URL:** `/api/books`

A system to manage library inventory, including adding books and searching by title.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/books` | Retrieve a list of all books. |
| `GET` | `/api/books/{id}` | Retrieve a specific book by ID. |
| `GET` | `/api/books/search?title={title}` | Search for books by title. |
| `POST` | `/api/books` | Add a new book to the library. |
| `DELETE` | `/api/books/{id}` | Remove a book from the library. |

#### **Example: Add a New Book (POST)**

```json
{
  "title": "Clean Code",
  "author": "Robert Martin",
  "isbn": "978-0132350884",
  "publicationYear": 2008
}

```

#### **Example: Success Response (GET)**

```json
[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert Martin",
    "isbn": "978-0132350884",
    "publicationYear": 2008
  }
]

```

---

### Question 2: Student Registration API

**Base URL:** `/api/students`

Manages student records with capabilities to filter by major and GPA.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/students` | Get all registered students. |
| `GET` | `/api/students/{studentId}` | Get student details by ID. |
| `GET` | `/api/students/major/{major}` | Filter students by major. |
| `GET` | `/api/students/filter?gpa={minGpa}` | Filter students with GPA ≥ specific value. |
| `POST` | `/api/students` | Register a new student. |
| `PUT` | `/api/students/{studentId}` | Update an existing student's info. |

#### **Example: Register Student (POST)**

```json
{
  "firstName": "Alice",
  "lastName": "Johnson",
  "email": "alice.j@university.edu",
  "major": "Computer Science",
  "gpa": 3.8
}

```

#### **Example: Success Response (GET)**

```json
{
  "studentId": 101,
  "firstName": "Alice",
  "lastName": "Johnson",
  "email": "alice.j@university.edu",
  "major": "Computer Science",
  "gpa": 3.8
}

```

---

### Question 3: Restaurant Menu API

**Base URL:** `/api/menu`

Handles restaurant menu items, allowing filtering by category and availability status.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/menu` | Get the full menu. |
| `GET` | `/api/menu/{id}` | Get details of a specific item. |
| `GET` | `/api/menu/category/{category}` | Filter items by category (e.g., Main Course). |
| `GET` | `/api/menu/available?available=true` | Get only currently available items. |
| `GET` | `/api/menu/search?name={name}` | Search menu items by name. |
| `POST` | `/api/menu` | Add a new item to the menu. |
| `PUT` | `/api/menu/{id}/availability` | Toggle item availability. |
| `DELETE` | `/api/menu/{id}` | Remove an item from the menu. |

#### **Example: Add Menu Item (POST)**

```json
{
  "name": "Spicy Ramen",
  "description": "Japanese noodle soup with spicy broth",
  "price": 12.99,
  "category": "Main Course",
  "available": true
}

```

#### **Example: Success Response (GET)**

```json
{
  "id": 5,
  "name": "Spicy Ramen",
  "description": "Japanese noodle soup with spicy broth",
  "price": 12.99,
  "category": "Main Course",
  "available": true
}

```

---

### Question 4: E-Commerce Product API

**Base URL:** `/api/products`

A robust product catalog API supporting pagination, price ranges, and stock management.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/products` | Get all products (supports `?page=0&limit=10`). |
| `GET` | `/api/products/{productId}` | Get specific product details. |
| `GET` | `/api/products/category/{category}` | Filter products by category. |
| `GET` | `/api/products/brand/{brand}` | Filter products by brand. |
| `GET` | `/api/products/search?keyword={kw}` | Search by name or description. |
| `GET` | `/api/products/price-range?min={x}&max={y}` | Get products within a price range. |
| `GET` | `/api/products/in-stock` | Get products where stock > 0. |
| `POST` | `/api/products` | Create a new product. |
| `PUT` | `/api/products/{productId}` | Update product details. |
| `PATCH` | `/api/products/{productId}/stock` | Update stock quantity (`?quantity={qty}`). |
| `DELETE` | `/api/products/{productId}` | Delete a product. |

#### **Example: Add Product (POST)**

```json
{
  "name": "Wireless Headphones",
  "description": "Noise cancelling over-ear headphones",
  "price": 299.99,
  "category": "Electronics",
  "stockQuantity": 50,
  "brand": "AudioTech"
}

```

#### **Example: Success Response (GET)**

```json
{
  "productId": 204,
  "name": "Wireless Headphones",
  "description": "Noise cancelling over-ear headphones",
  "price": 299.99,
  "category": "Electronics",
  "stockQuantity": 50,
  "brand": "AudioTech"
}

```

---

### Question 5: Task Management API

**Base URL:** `/api/tasks`

A "To-Do" list application for managing tasks, priorities, and deadlines.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/tasks` | Retrieve all tasks. |
| `GET` | `/api/tasks/{taskId}` | Retrieve a specific task. |
| `GET` | `/api/tasks/status?completed={bool}` | Filter by completion status. |
| `GET` | `/api/tasks/priority/{priority}` | Filter by priority (LOW, MEDIUM, HIGH). |
| `POST` | `/api/tasks` | Create a new task. |
| `PUT` | `/api/tasks/{taskId}` | Update an existing task. |
| `PATCH` | `/api/tasks/{taskId}/complete` | Mark a task as completed. |
| `DELETE` | `/api/tasks/{taskId}` | Delete a task. |

#### **Example: Create Task (POST)**

```json
{
  "title": "Complete Java Assignment",
  "description": "Finish the 6 API questions for the university project",
  "priority": "HIGH",
  "dueDate": "2023-12-15"
}

```

#### **Example: Success Response (GET)**

```json
{
  "taskId": 10,
  "title": "Complete Java Assignment",
  "description": "Finish the 6 API questions for the university project",
  "completed": false,
  "priority": "HIGH",
  "dueDate": "2023-12-15"
}

```

---

### Bonus: User Profile API (Wrapped Response)

**Base URL:** `/api/users`

A user management system that returns data wrapped in a custom `ApiResponse` object for standardized communication.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/users` | Get all user profiles. |
| `GET` | `/api/users/search?username={name}` | Search user by username. |
| `POST` | `/api/users` | Create a new user profile. |
| `PUT` | `/api/users/{userId}/activate` | Activate/Deactivate a user profile. |

#### **Example: Create User Profile (POST)**

```json
{
  "username": "john_doe",
  "email": "john@example.com",
  "fullName": "John Doe",
  "age": 25,
  "country": "USA",
  "bio": "Software Developer Student"
}

```

#### **Example: Standardized Response Wrapper (Output)**

All responses in this module follow this structure:

```json
{
  "success": true,
  "message": "User profile created successfully",
  "data": {
    "userId": 1,
    "username": "john_doe",
    "email": "john@example.com",
    "fullName": "John Doe",
    "age": 25,
    "country": "USA",
    "bio": "Software Developer Student",
    "active": true
  }
}

```
