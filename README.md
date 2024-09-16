The Elevator Safety and Management System provides real-time monitoring and safety features for elevator operations. It sends frequent status updates and alerts to ensure prompt response to emergencies, such as individuals being trapped inside the elevator.

Features
1. Real-Time Monitoring: Updates on current floor, destination, weight inside, and door status.
2. Safety Alerts: Triggers alerts when the door is closed while weight is detected.
3. Five-Layer Architecture:
    a. Client : makes request.
    b. Controller: Manages client requests.
    c. Manager: Maps DTOs to DAOs.
    d. Service: Handles business logic and database interactions using Hibernate ORM.
    e. Database: Stores data with MySQL.

Technologies Used:
1. Spring Boot: Framework for building and managing the application.
2. Java: Programming language used for development.
3. MySQL: Database for storing elevator and user data.
4. Hibernate ORM: For efficient data handling.
5. Postman: Tool for testing API endpoints.
6. DBeaver: Tool for database management.
