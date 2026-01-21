# Procurement App Backend

## Overview

Procurement App Backend is a **Spring Boot** application for managing suppliers, purchase orders (POs), and related items. It allows staff to create, edit, submit, and track purchase orders.

**Features**:

* CRUD operations for **Purchase Orders**
* CRUD operations for **Suppliers**
* PO status workflow: **DRAFT → SUBMITTED**
* Nested items within purchase orders
* Total amount and quantity calculations

---

## Tech Stack

* **Backend**: Java 17, Spring Boot 3
* **Database**: PostgreSQL
* **ORM**: Hibernate / JPA
* **DTO Mapping**: MapStruct
* **Lombok**: Boilerplate reduction
* **Validation**: Jakarta Validation (`@NotNull`, `@Size`)
* **Security**: Spring Security (JWT)

---

## ERD / Domain Models

**Entities**:

1. **User**

    * id, name, email
2. **Supplier**

    * id, name, contact_email, phone, address
3. **PurchaseOrder**

    * id, poNumber, status, totalAmount, createdBy (User), supplier, purchaseOrderItemList, createdAt, updatedAt
4. **PurchaseOrderItem**

    * id, productName, quantity, unitPrice, lineTotal, purchaseOrder

**Relationships**:

* `PurchaseOrder` → `Supplier` (Many-to-One)
* `PurchaseOrder` → `User` (Many-to-One)
* `PurchaseOrder` → `PurchaseOrderItem` (One-to-Many, cascade all)

---

## Getting Started

### Prerequisites

* Java 17+
* Maven 3.8+
* PostgreSQL 14+
* Docker (for Postgres container)
* IntelliJ IDEA

---

### Setup

1. Clone the repository:

```bash
git clone https://github.com/hanifomarr/procurement-app-be.git
cd procurement-app-be
```

2. Configure **PostgreSQL** database:

Using Docker Compose:
```bash
docker-compose up -d
```

3. Build and run the project:

```bash
mvn clean install
mvn spring-boot:run
```
The application will be available at `http://localhost:8080`.

---

## API Endpoints

### Purchase Orders

| Method   | Endpoint                           | Description                          |
| -------- | ---------------------------------- | ------------------------------------ |
| `POST`   | `/api/purchase-orders`             | Create a new PO with items           |
| `GET`    | `/api/purchase-orders`             | Get all POs                          |
| `GET`    | `/api/purchase-orders/{id}`        | Get PO by ID (with items)            |
| `PUT`    | `/api/purchase-orders/{id}`        | Update supplier/items of a DRAFT PO  |
| `PATCH`  | `/api/purchase-orders/{id}/status` | Change PO status (DRAFT → SUBMITTED) |
| `DELETE` | `/api/purchase-orders/{id}`        | Delete DRAFT PO                      |

### Suppliers

| Method   | Endpoint              | Description     |
| -------- | --------------------- | --------------- |
| `POST`   | `/api/suppliers`      | Create supplier |
| `GET`    | `/api/suppliers`      | List suppliers  |
| `GET`    | `/api/suppliers/{id}` | Get supplier    |
| `PUT`    | `/api/suppliers/{id}` | Update supplier |
| `DELETE` | `/api/suppliers/{id}` | Delete supplier |

### Users

| Method   | Endpoint          | Description |
| -------- | ----------------- | ----------- |
| `POST`   | `/api/users`      | Create user |
| `GET`    | `/api/users`      | List users  |
| `GET`    | `/api/users/{id}` | Get user    |
| `PUT`    | `/api/users/{id}` | Update user |
| `DELETE` | `/api/users/{id}` | Delete user |

---

## Project Structure

```
src/main/java/com/hanifomar/procurement_app
 ├─ common/security        # JWT / Auth filter
 ├─ purchaseorder
 │   ├─ controller
 │   ├─ dto
 │   ├─ mapper
 │   ├─ model
 │   ├─ repository
 │   └─ service
 ├─ supplier
 │   ├─ controller
 │   ├─ dto
 │   ├─ model
 │   └─ repository
 ├─ user
 │   ├─ controller
 │   ├─ dto
 │   ├─ model
 │   └─ repository
 └─ Application.java
```
