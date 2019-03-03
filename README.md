# Getting Started

## How to Run
### Prequisites
1. sudo apt-get install mysql-server
2. Install JDK 1.8. 
3. sudo apt-get install maven
3. git clone https://github.com/detik19/sayur-test
4. create database sayur
5. Change config src/main/resources/application.properties
* spring.datasource.url= dbc:mysql://{your database url}:3306/sayur?useSSL=false
* spring.datasource.username= {your mysql username}
* spring.datasource.password= {your mysql password}
7. mvn install 
8. mvn:run
## Preload database
1. executed preload.sql in src/main/resources
* mysql -u {usersql} -p {passwordsql} sayur  < preload.sql
2. preload sql contain : 
* 2 customer : susan and manda
* 3 items and inventories : Apel, Pepaya, Mangga
## API documentantion
6. Documentation for API: http://localhost:8080/swagger-ui.html
*POST http://localhost:8080/v1/cart/ to select goods in the cart
 
