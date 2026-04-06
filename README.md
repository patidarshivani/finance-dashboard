# 💰 Finance Dashboard Backend

## 📌 Overview

The Finance Dashboard Backend is a RESTful API built using Java and Spring Boot that enables users to manage financial records and access summarized insights through a secure, role-based system.

The system supports multiple user roles with controlled access to financial data and provides analytical endpoints for dashboard-level reporting such as income, expenses, and trends.

---

## 🚀 Features

### 👤 User & Role Management

* Create and manage users
* Assign roles: **Viewer, Analyst, Admin**
* Manage user status (Active/Inactive)
* Role-based access control

---

### 💰 Financial Records Management

* Create, update, delete financial records
* Fields include:

  * Amount
  * Type (Income / Expense)
  * Category
  * Date
  * Description
* Each record is linked to a user

---

### 📊 Dashboard Analytics

* Total Income
* Total Expenses
* Net Balance
* Category-wise spending
* Monthly trends
* Recent transactions

---

### 🔐 Access Control

* Implemented using Spring Security
* Role-based authorization:

  * **Viewer** → Read-only access
  * **Analyst** → Read + analytics
  * **Admin** → Full access (CRUD + user management)

---

### 🔍 Filtering Support

* Filter financial records dynamically:

  * By type
  * By category
  * By date range
* Supports combined filters

---

### ⚠️ Validation & Error Handling

* Input validation using annotations
* Global exception handling
* Meaningful error responses with proper HTTP status codes

---

## 🛠️ Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **Security:** Spring Security
* **Database:** MySQL (or any SQL database)
* **ORM:** Spring Data JPA / Hibernate
* **Build Tool:** Maven

---

## 🧱 Project Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database

### Structure:

```
com.finance.dashboard
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── security
 ├── exception
 ├── config
 └── util
```

---

## 🔑 API Endpoints

### 👤 User APIs (Admin only)

* `POST /users` → Create user
* `GET /users` → Get all users
* `PUT /users/{id}` → Update user
* `PATCH /users/{id}/status` → Update status

---

### 💰 Financial Record APIs

* `POST /records` → Create record (Admin)
* `GET /records` → Get all records
* `PUT /records/{id}` → Update record (Admin)
* `DELETE /records/{id}` → Delete record (Admin)

---

### 🔍 Filtering

* `GET /records/filter?type=INCOME&category=Food&startDate=YYYY-MM-DD&endDate=YYYY-MM-DD`

---

### 📊 Dashboard APIs

* `GET /dashboard/summary`
* `GET /dashboard/category-wise`
* `GET /dashboard/monthly`
* `GET /dashboard/recent`

---

## 🔐 Role-Based Access Matrix

| Feature             | Viewer | Analyst | Admin |
| ------------------- | ------ | ------- | ----- |
| View Records        | ✅      | ✅       | ✅     |
| Dashboard Analytics | ❌      | ✅       | ✅     |
| Create Records      | ❌      | ❌       | ✅     |
| Update/Delete       | ❌      | ❌       | ✅     |
| Manage Users        | ❌      | ❌       | ✅     |

---

## ⚙️ Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/patidarshivani/finance-dashboard.git
cd finance-dashboard
```

---

### 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

---

### 3. Run Application

```bash
mvn spring-boot:run
```

---

### 4. Test APIs

Use tools like Postman for API testing.

---

## 📌 Assumptions

* Single-user ownership of records
* Single currency system
* No timezone handling (default system time)
* Basic authentication used for simplicity

---

## 🌟 Optional Enhancements (Future Scope)

* JWT-based authentication
* Pagination & sorting
* Search functionality
* Swagger API documentation
* Soft delete support

---

## 🎯 Key Highlights

* Clean layered architecture
* Role-based access control
* Dynamic filtering using Specifications
* Aggregation queries for analytics
* Proper validation and exception handling

---

## 📬 Conclusion

This project demonstrates a well-structured backend system with secure access control, scalable design, and analytical capabilities suitable for real-world financial dashboards.

---
