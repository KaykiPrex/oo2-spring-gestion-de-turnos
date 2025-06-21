# README

### PROJECT SETUP

1. Descargar e instalar JDK 17.
    1. verificar la version : `java --version`.
2. Descargar e instalar [Apache Maven 4.0.0](https://maven.apache.org/download.cgi).
    1. verificar la version : `mvn --version`.
3. Descargar e instalar [MySQL 8.0](https://dev.mysql.com/doc/refman/8.0/en/installing.html).
4. En este proyecto se usó Intellij IDEA pero puede usar su preferido
5. Para testear los controller [Postman](https://www.postman.com/downloads/).

### RUN SQL Script
```
CREATE DATABASE IF NOT EXISTS db_appointment_planner;
```

### RUN LOCALLY

Ejecutar el proyecto:

```
mvn spring-boot:run
```
### Variables de entorno

|  |   |
|------------|------------|
| DB_MYSQL_USER | usuario de la base MYSQL  | 
| DB_MYSQL_PASS | contraseña de la base MYSQL  | 
| DB_MYSQL_SCHEMA | db_appointment_planner;  |
| DB_MYSQL_URL | jdbc:mysql://localhost:3306/db_appointment_planner  | 
| SENDER_MAIL_HOST | smtp.gmail.com  | 
| SENDER_MAIL_USER | Ingrese Mail enviado en el documento  |
| SENDER_MAIL_PASS | Ingrese token enviado en el documento  | 
| SENDER_MAIL_PORT | 587  | 
| SENDER_MAIL_TEST | Ingrese un mail de destino para recibir correo  | 

[ IMPORTANT ] Por razones de seguridad el SENDER_MAIL_USER y SENDER_MAIL_PASS se enviara en el documento de la entrega.


### USERS:

| user                       | Password | Role  |
|-----------------------------|----------|-------|
| client             | 1234  | CLIENT |
| professional       | 4567  | PROFESSIONAL |
