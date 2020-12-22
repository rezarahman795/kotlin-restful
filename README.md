# API spec

##Authentication
All API must use this authentication

- header:
  - X-Api-Key:"your secret key"


# Create Product

Request:

- method : POST
- endpoint : '/api/products'
- header:
    - content-type : application/json
    - accept : application/ json
- body:

```json
{
  "id": "String ,unique",
  "name": "String ",
  "price": "long",
  "quantity": "integer"
}
```

Respone:

```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "String ,unique",
    "name": "String ",
    "price": "long",
    "quantity": "integer",
    "createdAt ": "date",
    "updateAt": "date"
  }
}
```

## Get Product

Request:

- method : GET
- endpoint : '/api/products/{id_products}'
- header:

    - accept : application/ json

Respone:

```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "String ,unique",
    "name": "String ",
    "price": "long",
    "quantity": "integer",
    "createdAt ": "date",
    "updateAt": "date"
  }
}
```

## Update product

Request:

- method : PUT / PATCH
- endpoint : '/api/products/{id_product}'
- header:
    - content-type : application/json
    - accept : application/ json
- body:

```json
{
  "name": "String ",
  "price": "long",
  "quantity": "integer"
}
```

Respone:

```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id": "String ,unique",
    "name": "String ",
    "price": "long",
    "quantity": "integer",
    "createdAt ": "date",
    "updateAt": "date"
  }
}
```

## List Product

Request:

- method : GET
- endpoint : '/api/products/'
- header:
    - accept : application/ json
- query param:
    - Size:number,
    - page : number, Respone:

```json
{
  "code": "number",
  "status": "string",
  "data": [
    {
      "id": "String ,unique",
      "name": "String ",
      "price": "long",
      "quantity": "integer",
      "createdAt ": "date",
      "updateAt": "date"
    },
    {
      "id": "String ,unique",
      "name": "String ",
      "price": "long",
      "quantity": "integer",
      "createdAt ": "date",
      "updateAt": "date"
    },
    {
      "id": "String ,unique",
      "name": "String ",
      "price": "long",
      "quantity": "integer",
      "createdAt ": "date",
      "updateAt": "date"
    }
  ]
}
```

## Delete Product

Request:

- method : DELETE
- endpoint : '/api/products/{id_product}'
- header:
    - accept : application/ json

Respone:

```json
{
  "code": "number",
  "status": "string"
}
```