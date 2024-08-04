# SlayStation-Microservices

## Microservice-user
### Users
```
GET
http://localhost:8080/api/users/all
http://localhost:8080/api/users/search/2
POST
http://localhost:8080/api/users/create
PUT
http://localhost:8080/api/users/1
DELETE
http://localhost:8080/api/users/6
```

### Security-Questions

```
GET
http://localhost:8080/api/security-questions/1
http://localhost:8080/api/security-questions/user/2
POST
http://localhost:8080/api/security-questions/create
DELETE
http://localhost:8080/api/security-questions/1
```

### Ejemplos JSON

#### Users
```
POST 
{
    "userName": "Polina",
    "userLastName": "Sanchez",
    "userEmail": "polina.sanchez@example.com",
    "userNickname": "polinas",
    "userPhone": "555-2222",
    "password": "anotherSecurePassword22456",
    "userImage": null,
    "userType": 1,
    "securityQuestions": [
        {
            "question": "¿Cómo se llama tu mamá?",
            "answer": "Sara"
        }
    ]
}

PUT (Ej: id 1)
{
    "userName": "Carlos",
    "userLastName": "Garcia",
    "userEmail": "carlos.garcia@example.com",
    "userNickname": "carlitos",
    "userPhone": "555-9876",
    "password": "newSecurePassword789",
    "userImage": "base64EncodedImageString",
    "userType": 0,
    "securityQuestions": [
        {
            "securityQuestionId": 1,
            "question": "¿Cuál es tu color favorito?",
            "answer": "Verde"
        },
        {
            "securityQuestionId": 3,
            "question": "¿Cuál es el nombre de tu escuela primaria?",
            "answer": "Escuela Primaria ABC"
        }
    ]
}

```

#### Security-Questions
```
POST 
{
    "question": "¿Cuál es el nombre de tu escuela primaria?",
    "answer": "Escuela Primaria ABC"
}


PUT (Ej: id 6)
{
    "question": "¿Cuál es el nombre de tu Papá?",
    "answer": "Raúl"
}


```


## Microservice-product

### Product
```
GET
http://localhost:8080/api/products/all
http://localhost:8080/api/products/search/2

POST
http://localhost:8080/api/products/create

PUT
http://localhost:8080/api/products/2

DELETE
http://localhost:8080/api/products/4
```

### Category

```
GET
http://localhost:8080/api/categories/all
http://localhost:8080/api/categories/search/1

POST
http://localhost:8080/api/categories/create

PUT
http://localhost:8080/api/categories/2

DELETE
http://localhost:8080/api/categories/5
```

### State

```
GET
http://localhost:8080/api/states/all
http://localhost:8080/api/states/search/1

POST
http://localhost:8080/api/states/create

PUT
http://localhost:8080/api/states/2

DELETE
http://localhost:8080/api/states/1
```
### Ejemplos JSON
#### Product
```JSON
POST 
{
    "productName": "Pokemon",
    "productDescription": "Videojuego de acción y aventura exclusivo de Nintendo DS",
    "productPrice": 40,
    "productStock": 25,
    "productImage": "https://static.fnac-static.com/multimedia/Images/ES/NR/2c/62/06/418348/1540-6/tsp20160818202352/Pokemon-Edicion-Negra-Nintendo-DS.jpg",
    "categoryId": 1,
    "stateId": 2
}


PUT (Ej: id 6)
{
    "productName": "Pokemon edición Diamante",
    "productDescription": "Videojuego de acción y aventura exclusivo de Nintendo DS",
    "productPrice": 40,
    "productStock": 35,
    "productImage": "https://static.fnac-static.com/multimedia/Images/ES/NR/2c/62/06/418348/1540-6/tsp20160818202352/Pokemon-Edicion-Negra-Nintendo-DS.jpg",
    "categoryId": 1,
    "stateId": 2
}

```
#### Category
Si a futuro se desea agregar categorías, se puede hacerlo

#### State
Si a futuro se desea agregar estados, se puede hacerlo

## Microservice-userpurchase

### UserPurchase

```
GET
http://localhost:8080/api/userpurchases/all
http://localhost:8080/api/userpurchases/search/1

POST
http://localhost:8080/api/userpurchases/create

PUT
http://localhost:8080/api/userpurchases/1

DELETE
http://localhost:8080/api/userpurchases/5
```
### Ejemplos JSON
#### UserPurchase

```JSON
POST (no se toca el precio total, se calcula automáticamente)
{
    "quantity": 6,
    "userId": 1,
    "productId": 1
}


PUT (Ej: id 11) (no se toca el precio total, se calcula automáticamente)
{
    "quantity": 2,
    "userId": 1,
    "productId": 5
}

```


# Sin API GATEWAY
Microservice-user -> 8090 (MYSQL)
microservice-product -> 9090 (POSTGRESQL)
microservice-userpurchase -> 8092 (MYSQL)
