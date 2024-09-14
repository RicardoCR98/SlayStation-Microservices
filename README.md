# SlayStation-Microservices

Este proyecto implementa una arquitectura de microservicios utilizando **Spring Boot** y **Spring Cloud**. Cada microservicio maneja una funcionalidad independiente y se comunica con los demás a través de **Eureka Discovery** y **OpenFeign**.

## Arquitectura de la aplicación web

![Untitled-2024-09-12-1551](https://github.com/user-attachments/assets/c7b25a08-09f0-47d0-bd4d-30d988128d2d)


## Requisitos previos
- Java 21+
- Maven 3.8+
- Docker
- Docker Compose

## Instrucciones de inicio

### Paso 1: Iniciar las bases de datos

1. **MySQL**: Se utiliza para `microservice-user` y `microservice-userpurchase`. Puedes configurar las bases de datos en:
    - `microservice-user`: configuración en `microservice-config/src/main/resources/configurations/msvc-user.yml` (por defecto, la BD se llama `userDB`).
    - `microservice-userpurchase`: configuración en `microservice-config/src/main/resources/configurations/msvc-userpurchase.yml` (por defecto, la BD se llama `userpurchaseDB`).

2. **PostgreSQL**: Se utiliza para `microservice-product`. Puedes configurarla en:
    - `microservice-product`: configuración en `microservice-config/src/main/resources/configurations/msvc-product.yml` (por defecto, la BD se llama `productDB`).

### Paso 2: Iniciar los microservicios en orden

1. **microservice-eureka** (Puerto: **8761**): Este servicio actúa como el registro central para todos los microservicios.
2. **microservice-config** (Puerto: **8888**): Proporciona configuraciones centralizadas para los microservicios.
3. **microservice-gateway** (Puerto: **8080**): Actúa como el punto de entrada para todas las solicitudes.
4. **microservice-user** (Puerto: **8090**) -> Base de datos: MySQL.
5. **microservice-product** (Puerto: **9090**) -> Base de datos: PostgreSQL.
6. **microservice-userpurchase** (Puerto: **8092**) -> Base de datos: MySQL.

---

## Detalles de los Microservicios

### Microservice-user

Este servicio maneja toda la información relacionada con los usuarios y sus preguntas de seguridad.

#### Endpoints:

**Usuarios:**
- `GET` `http://localhost:8080/api/users/all`
- `GET` `http://localhost:8080/api/users/search/{id}`
- `POST` `http://localhost:8080/api/users/create`
- `PUT` `http://localhost:8080/api/users/{id}`
- `DELETE` `http://localhost:8080/api/users/{id}`

**Preguntas de seguridad:**
- `GET` `http://localhost:8080/api/security-questions/{id}`
- `GET` `http://localhost:8080/api/security-questions/user/{userId}`
- `POST` `http://localhost:8080/api/security-questions/create`
- `DELETE` `http://localhost:8080/api/security-questions/{id}`

#### Ejemplos JSON:

**Crear usuario:**
```json
{
    "userName": "Polina",
    "userLastName": "Sanchez",
    "userEmail": "polina.sanchez@example.com",
    "userNickname": "polinas",
    "userPhone": "555-2222",
    "password": "securePassword123",
    "userType": 1,
    "securityQuestions": [
        {
            "question": "¿Cómo se llama tu mamá?",
            "answer": "Sara"
        }
    ]
}
```

### Microservice-product

Este servicio gestiona la información de productos y sus categorías.

#### Endpoints:

**Productos:**
- `GET` `http://localhost:8080/api/products/all`
- `GET` `http://localhost:8080/api/products/search/{id}`
- `POST` `http://localhost:8080/api/products/create`
- `PUT` `http://localhost:8080/api/products/{id}`
- `DELETE` `http://localhost:8080/api/products/{id}`

**Categorías:**
- `GET` `http://localhost:8080/api/categories/all`
- `GET` `http://localhost:8080/api/categories/search/{id}`
- `POST` `http://localhost:8080/api/categories/create`
- `PUT` `http://localhost:8080/api/categories/{id}`
- `DELETE` `http://localhost:8080/api/categories/{id}`

### Microservice-userpurchase

Este servicio gestiona las compras realizadas por los usuarios.

#### Endpoints:

**Compras:**
- `GET` `http://localhost:8080/api/userpurchases/all`
- `GET` `http://localhost:8080/api/userpurchases/search/{id}`
- `POST` `http://localhost:8080/api/userpurchases/create`
- `PUT` `http://localhost:8080/api/userpurchases/{id}`
- `DELETE` `http://localhost:8080/api/userpurchases/{id}`

#### Ejemplo JSON:

**Crear una compra:**
```json
{
    "quantity": 6,
    "userId": 1,
    "productId": 1
}
```

---

## Comunicación entre Microservicios

Se utiliza **OpenFeign** para permitir la comunicación entre los microservicios. Por ejemplo, el microservicio `microservice-userpurchase` realiza llamadas a `microservice-product` para obtener información sobre los productos.

---

### Descripción del `pom.xml` padre (Configuración para Microservicios)

El archivo `pom.xml` del proyecto padre está configurado de la siguiente manera:

- **Spring Boot Starter Parent**: El proyecto utiliza **Spring Boot** con la versión **3.3.2**, lo que proporciona una gestión simplificada de dependencias y versiones.
- **Módulos**: Incluye los microservicios:
   - `microservice-gateway`
   - `microservice-eureka`
   - `microservice-config`
   - `microservice-user`
   - `microservice-product`
   - `microservice-userpurchase`
- **Lombok**: Se utiliza la dependencia de **Lombok** para reducir la escritura de código repetitivo (como getters y setters).
- **Java 21**: El proyecto está configurado para compilar y ejecutarse con **Java 21**.
- **Spring Boot Maven Plugin**: Este plugin permite empaquetar los microservicios como aplicaciones ejecutables para su despliegue.

---
## Dependencias clave de cada Microservicio

### Gateway:
- Spring Cloud Gateway
- Eureka Discovery Client
- Config Client
- Spring Boot Actuator

### Eureka:
- Eureka Server
- Config Client
- Spring Boot Actuator

### Config Server:
- Spring Cloud Config Server

### Microservice-user:
- Spring Web (para REST)
- Discovery Client
- Config Client
- Spring Data JPA
- MySQL Driver
- Spring Boot Actuator

### Microservice-userpurchase:
- Spring Web (para REST)
- Discovery Client
- Config Client
- Spring Data JPA
- MySQL Driver
- OpenFeign
- Spring Boot Actuator

---

## Despliegue sin API Gateway

Si prefieres usar los microservicios sin el API Gateway, puedes acceder directamente a ellos mediante los siguientes puertos:

- `microservice-user`: **8090** (MySQL)
- `microservice-product`: **9090** (PostgreSQL)
- `microservice-userpurchase`: **8092** (MySQL)

