This project is a simple one to many Spring/Thymeleaf Web project. That uses 
MVC architecture.

Originally written to use h2 database.  Converted it to MySql.

MySQL Workbench:

create database moviedb;
use moviedb;

Added the following to Application.Properties file

spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/moviedb
spring.datasource.username=root
spring.datasource.password=password
useSSL=false

Pom.xml commented out the h2 dependencieies and
added MySQL dependency.

<!--
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

