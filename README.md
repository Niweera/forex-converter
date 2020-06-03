# Forex-Converter

Forex-Converter is a microservices based application build using Java Spring Boot.

## How to run?

1. git clone the repository.
2. Each directory is a seperate (micro) service.
3. Build each project using Maven (Use JDK14 or change the pom.xml according to the available JDK version).
4. Start Eureka server.
5. Start other services.
6. Go to http://localhost:8761 to see the Eureka server dashboard.

### Endpoints

```json
{
  "id": 10001,
  "from": "USD",
  "to": "LKR",
  "conversionMultiple": 186.18,
  "quantity": 1000.0,
  "totalAmount": 186180.0,
  "port": 8100
}
```

### Paths

| Location  | Endpoint                 |
| :-------- | :----------------------- |
| Root path | `http://localhost:8080/` |

### HTTP request and query methods

| Method | Endpoint                                                     | Query | Description                                     | Examples                                                                                                                                           |
| :----- | :----------------------------------------------------------- | :---- | :---------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------- |
| `GET`  | `currency-converter/from/{FROM}/to/{TO}/quantity/{QUANTITY}` |       | Convert a quantity from one currency to another | [`http://localhost:8080/currency-converter/from/USD/to/LKR/quantity/3000`](http://localhost:8080/currency-converter/from/USD/to/LKR/quantity/3000) |

## References

1. [Microservices with Spring Boot and Java by In28Minutes](https://www.springboottutorial.com/creating-microservices-with-spring-boot-part-1-getting-started)
2. https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#server-properties
3. https://blog.marcnuri.com/field-injection-is-not-recommended/
4. https://www.w3schools.com/java/java_hashmap.asp
5. [Spring Boot Quick Start by Java Brains](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x)
6. https://start.spring.io/
7. https://medium.com/better-programming/building-a-spring-boot-rest-api-a-php-developers-view-part-i-6add2e794646
8. https://www.tutorialspoint.com/maven/index.htm
9. http://tutorials.jenkov.com/maven/maven-tutorial.html
