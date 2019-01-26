## Ejecutar el servidor 
El servidor Hercules-rest utiliza un sistema de compilación basado en Maven y liquibase para la evolución de la base de datos. También utiliza Spring Boot para ejecutar el JAR compilado con un servidor Tomcat integrado.

## Pre-requisitos

* Maven 3.3.9 or above
* Java 8
* PostgreSQL 9.5 or above

## Configuración básica

Estos son pasos que solo necesitará realizar la primera vez que lo haga
configurando el servidor.

### Paso 0, clonar el repositorio

```shell

```
### Paso 1, crear la base de datos

Run with psql the script:

```shell
psql -U YOUR_USER_HERE -f src/main/resources/db/create_database.sql
```

Yo can also copy and paste the following snippet to your favorite PSQL client:

```
CREATE USER "hercules" WITH ENCRYPTED PASSWORD 'hercules';
ALTER ROLE "hercules" WITH createdb;

CREATE DATABASE hercules_rest
  WITH OWNER = hercules
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'es_PY.UTF-8'
       LC_CTYPE = 'es_PY.UTF-8'
       CONNECTION LIMIT = -1;
       
```

Esto generará la base de datos inicial, y a partir de este punto cualquier cambio relacionado con la base de datos será a través de [Liquibase] (LIQUIBASE.md).

Liquibase se ejecuta automáticamente durante el inicio del servidor y actualiza la base de datos (si
necesario).

### Paso 2, compilar la aplicación

Desde el directorio de hercules-rest, ejecutar:

```shell
mvn clean package
```

### Paso 3, ejecutas la aplicación

Iniciar el servidor:

```shell
java -jar target/hercules-rest-0.0.1-SNAPSHOT.war
```

Y eso es todo, su servidor se iniciará de forma predeterminada en http://localhost:8080

## ¿Qué sigue?

En desarrollo

