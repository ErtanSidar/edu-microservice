Microservices Project
=====================

This project is a microservices application developed using Spring Cloud and various microservices architecture components. The project includes Lesson Service, Student Service, Config Server, Service Registry, and API Gateway. Technologies like Http Exchange, Kafka, Distributed Tracing, and API Gateway are also used.

Table of Contents
-----------------

*   [Technologies](#technologies)
    
*   [Services](#services)
    
    *   [Lesson Service](#lesson-service)
        
    *   [Student Service](#student-service)
        
    *   [Config Server](#config-server)
        
    *   [Service Registry](#service-registry)
        
    *   [API Gateway](#api-gateway)
        
*   [Used Technologies](#used-technologies)
    
    *   [Http Exchange](#http-exchange)
        
    *   [Kafka](#kafka)
        
    *   [Distributed Tracing](#distributed-tracing)
        
    *   [API Gateway](#api-gateway)
    

Technologies
------------

The main technologies used in this project are:

*   **Spring Cloud**: Used for managing and integrating microservices.
    
*   **Http Exchange**: Facilitates communication between microservices.
    
*   **Kafka**: Serves as a messaging system for reliable and high-performance data transfer.
    
*   **Distributed Tracing**: Used for tracking and monitoring microservices.
    
*   **API Gateway**: Acts as a central access point to all services.
    

Services
--------

### Lesson Service

Lesson Service manages lesson data. You can list, add, or update lessons for students.

*   **Responsibilities**:
    
    *   Manages lesson data (CRUD operations).
        
    *   Communicates with other microservices.
        

### Student Service

Student Service manages student data. You can query and manage the details of students.

*   **Responsibilities**:
    
    *   Manages student data (CRUD operations).
        
    *   Integrates with Lesson Service to query lessons for each student.
        

### Config Server

Config Server provides centralized configuration management for all microservices. Configuration files are centrally managed from here.

*   **Responsibilities**:
    
    *   Provides dynamic configurations for microservices.
        
    *   Simplifies management in distributed environments.
        

### Service Registry

Service Registry is a registry server that enables microservices to discover and communicate with each other.

*   **Responsibilities**:
    
    *   Facilitates dynamic registration and discovery of services.
        
    *   Tools like Eureka can be used for service discovery.
        

### API Gateway

API Gateway acts as the central point through which all requests to the services are routed. It forwards requests to the appropriate microservice.

*   **Responsibilities**:
    
    *   Handles routing and load balancing.
        
    *   Provides security and authentication.
        
    *   Optimizes inter-service communication.
        

Used Technologies
-----------------

### Http Exchange

Http Exchange is a technology used to facilitate HTTP-based communication between microservices. It is Spring’s newer approach, replacing RestTemplate and WebClient.

*   **Features**:
    
    *   Provides a modern and reactive approach.
        
    *   Optimizes communication between microservices.
        

### Kafka

Apache Kafka is a distributed messaging queue used in this project for asynchronous messaging.

*   **Features**:
    
    *   High throughput and low latency.
        
    *   Provides real-time data streams.
        
    *   Distributed and scalable.
        

### Distributed Tracing

Distributed tracing is used to trace requests across microservices. Tools like Sleuth and Zipkin are integrated for this purpose.

*   **Features**:
    
    *   Tracks delays between services.
        
    *   Helps identify and resolve issues quickly.
        

### API Gateway

API Gateway serves as the entry point for all external requests and forwards them to the appropriate microservices. It also handles critical functions like security, load balancing, and authentication.

*   **Features**:
    
    *   Provides centralized management.
        
    *   Improves performance and security.
