# Veterinary Management System

## Overview

### The Veterinary Management System is a Spring Boot application designed to manage the operations of a veterinary clinic. 


The system allows veterinary staff to handle various tasks such as managing veterinarians, scheduling appointments, and recording animal vaccinations.

Features

Veterinarian Management

Add, update, view, and delete veterinarian details.

Manage the available days of veterinarians.

Customer and Animal Management

Add, update, view, and delete customer and animal details.

Filter animals by name.

Filter customers by name.

View all animals belonging to a specific customer.

Vaccine Management

Add, update, view, and delete vaccination records.

Prevent duplicate vaccinations if the protection period of an existing vaccination has not expired.

List all vaccinations for a specific animal.

List animals with vaccinations expiring within a given date range.


Appointment Management

Schedule, update, view, and delete appointments.

Ensure no appointment conflicts with a veterinarian's available days and times.

Filter appointments by date range and veterinarian.

Filter appointments by date range and animal.


API Endpoints

Animal and Customer Management

![image](https://github.com/utkusrgt/vet-app/assets/93541863/143b34dc-f592-4245-a9ac-8e7541c3f109)

Vaccine Management

![image](https://github.com/utkusrgt/vet-app/assets/93541863/0f203129-d8f2-40c4-941c-0d24d6069bc9)

Appointment Management

![image](https://github.com/utkusrgt/vet-app/assets/93541863/5b9c1bea-7f39-4323-b3f3-7ad46e5abbfc)

Veterinarian Management

![image](https://github.com/utkusrgt/vet-app/assets/93541863/ea008640-467d-494b-9ff4-85a508d6dd11)

# Important Notes For The Endpoints

This project was nearly completed before the DTO, I could only implement the DTO structure to Animal, and Customer.

It would be better to write from scratch to implement DTO.

Other operations will request all of the information to operate. For detailed information, please see

│   │   │   │   │   │   ├── controller/

│   │   │   │   │   │   ├── **dto**/

│   │   │   │   │   │   │   ├── request/

│   │   │   │   │   │   ├── entity/

For Example

![image](https://github.com/utkusrgt/vet-app/assets/93541863/7b564b82-67ba-4a5c-b610-f5954bd1738b)


Appointment update will need both doctor ID and animal ID to work. Other information isn't needed.

Appointments will need Both Date and Time in ISO Date and Time format. In the first initialization, the program asks for serialized date and time, ignoring and using ISO types for simplicity.
@JsonFormat did not work for this.


Project Structure

Layered Architecture

Controller Layer: Handles HTTP requests and responses.

Service Layer: Contains business logic.

Repository Layer: Manages database interactions.

![image](https://github.com/utkusrgt/vet-app/assets/93541863/c5729e03-ad66-4192-9079-b840f7b02bce)


UML Diagram

![vet-app](https://github.com/utkusrgt/vet-app/assets/93541863/d766d4d2-afb1-4afc-bf9f-2fa4b7e856a6)




This project aims to provide a comprehensive management system for a veterinary clinic, covering all essential operations and ensuring data integrity and consistency.


# How To Use

Modify the pom.xml with your Database credentials.

Add the dependency according to your needs.

This project was created with Postgresql.

You will need the dependency for the SQL of your choice.

This application works on the LocalHost:8080.

[Swagger UI]([url](http://localhost:8080/swagger-ui/index.html#/)) would be the best option to test.







