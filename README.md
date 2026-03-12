# Digital Services Management System

**Names:** Benineza Moise  
**ID:** 26464  
**Group:** E  

---

## Project Overview

The Digital Services Management System is a Spring Boot application designed to manage users, locations, and the services provided. The project demonstrates relational database design, REST API development, and entity relationships.

The system allows:
- Storing the full Rwanda administrative structure (Province → District → Sector → Cell → Village)
- Managing services provided (Mobile App Development, Cloud Storage, Web Development)
- Registering users and linking them to a specific village
- Associating users with multiple services
- Retrieving users by village or other administrative levels

---

## Features

1. **Location Management**
   - Save and update locations from Province down to Village
   - Maintains parent child relationships for administrative divisions

2. **User Management**
   - Register users with a village assignment
   - Retrieve users by village
   - Avoid duplicate users using email validation

3. **Service Management**
   - Save and retrieve available services
   - Associate services with users

4. **User-Service Relationships**
   - Each user can subscribe to one or more services
   - Maintains relational mapping through `user_services` table

---

## Database Structure

The system contains at least **five tables**:

1. `locations` – Stores administrative hierarchy (Province → Village)  
2. `services` – Stores available services  
3. `users` – Stores registered users and links to a village  
4. `user_services` – Many-to-many relationship between users and services  
5. `user_profiles` – (Optional/extendable) to store additional user information  

### Relationships

- A **Village** belongs to a **Cell**, a Cell belongs to a **Sector**, and so on up to Province  
- A **User** is linked to one **Village**  
- A **User** can have multiple **Services**, linked through the `user_services` table  

---

## API Endpoints

### Locations
- `POST /api/locations/save` – Save a new location  
- `GET /api/locations` – Retrieve all locations  

### Users
- `POST /api/users/save` – Register a new user  
- `GET /api/users/village/{villageId}` – Get all users in a specific village  

### Services
- `POST /api/services/save` – Save a new service  
- `GET /api/services` – Retrieve all services  

---

## Technologies Used

- Java 17  
- Spring Boot 3  
- JPA
- PostgreSQL  
- Maven  

---

## Entity Relationship Diagram (ERD)

<img width="1578" height="869" alt="Image" src="https://github.com/user-attachments/assets/0b82dbf1-3bb2-4596-924c-ed81a0ba4893" />
