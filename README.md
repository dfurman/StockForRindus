# StockForRindus
HOW TO:
----------------------
I Project Structure and Architecture

Project Structure DIR:
.
├── pom.xml // MAIN Apache Maven POM
├── RREADME.txt // THIS INSTRUCTION
├── src
│   ├── main
│   │   ├── java // CODE SOURCE
│   │   ├── resources // ALL OTHER RESOURCE
│   │   └──
│   └── test
│       └── java // FOR TEST
├── target // DIR FOR BUILD

I used Spring-boot - provided embedded Apache Tomcat container.
The major LIB:

 JPA - Hibernate
 Dependency Injection / IoC - Spring DI
 JAX RS - REST API - jersey implementation for JAX RS
 Database - H2 - storage in memory
 Swagger-UI - for REST API DOCUMENTATION

II Build
Build with maven command:
mvn clean install

III Run
Run with spring boot CLI:
spring-boot:run

Application works on HTTP protocol on 8090 TCP port

IV REST API with Swagger
localhost:8090/swagger-ui.html#!/stock-implement-rest/