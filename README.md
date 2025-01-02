# Software Architecture

This project combines a wide range of software engineering concepts to create an efficient and maintainable solution:

- Sorting and Searching Algorithms such as Bubble Sort, Selection Sort, Linear Search, and Binary Search, optimize data management and retrieval.
- DTO (Data Transfer Object) ensures clean separation of data across layers, improving scalability.
- Builder Design Pattern simplifies the creation of complex objects.
- Domain-Driven Design (DDD) focuses on aligning the software model with business requirements, enhancing collaboration and clarity.
- Clean Architecture promotes modularity, separation of concerns, and long-term maintainability.
- Integration with PostgreSQL ensures reliable, scalable data storage, while REST APIs provide a seamless interface for communication.
- Following SOLID principles helps in creating flexible and extensible systems, making the codebase easy to maintain and extend over time.

These technologies work together to build a robust and scalable application, following industry best practices for software development.

# Technical Instructions

## Department
Request:
curl --location 'http://localhost:9090/departments' \
--header 'Content-Type: application/json' \
--data '{
    "code": "FIN-01",
    "name": "Financial 01"
}'

Response:
{
    "code": "FIN-01"
}

## Employee

Request:
curl --location 'http://localhost:9090/employees' \
--header 'Content-Type: application/json' \
--data '{
	"name": "Rafael de Azevedo",
    "role": "TEAM_LEADER",
    "salary": 20000.00,
    "departmentCode": "FIN-01"
}'

Reponse: 
{
    "name": "Rafael de Azevedo",
    "role": "TEAM_LEADER",
    "departmentCode": "FIN-01"
}

## Custom Constraints

![image](https://github.com/user-attachments/assets/d596e4c9-0596-4958-9239-6f7c05cd34a1)

