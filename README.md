# Getting Started

## How to Run
### Prequisites
1. Install MySQL 5.6.x
2. Install JDK 1.8. git clone https://github.com/detik19/sayur-test
3. create database sayur
4. Change config src/main/resources/application.properties
spring.datasource.url= dbc:mysql://{your database url}:3306/sayur?useSSL=false
spring.datasource.username= {your mysql username}
spring.datasource.password= {your mysql password}


### Guides
The following guides illustrates how to use certain features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

