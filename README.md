## Setup & Installation

Follow these steps to get the project up and running locally.

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/Spring-Boot_Assignment2.git
cd Spring-Boot_Assignment2

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

### Testing Evidence
Per the assignment requirements, testing has been performed using Postman for all endpoints.

**- Screenshots:** Evidence of successful API calls and their outputs can be found in the screenshots/ directory at the root of this project.

**- Coverage:** The screenshots cover success scenarios (200 OK, 201 Created) as well as error handling (404 Not Found, 400 Bad Request) for all 6 questions.
