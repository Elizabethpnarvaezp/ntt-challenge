# User Management API – Prueba Técnica Java Spring Boot

Este proyecto es una API REST desarrollada con Java 21 y Spring Boot 3.2+ que permite autenticar usuarios usando la API externa [DummyJSON](https://dummyjson.com) y registrar logins exitosos en una base de datos PostgreSQL.

Se utiliza `Feign Client` para las integraciones, principios SOLID en la arquitectura y se incluye al menos una prueba unitaria del flujo de autenticación.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.2+
- Spring Data JPA
- PostgreSQL
- Feign Client
- Lombok
- JUnit 5

---

## Cómo ejecutar el proyecto

1. Asegúrate de tener **PostgreSQL** instalado y en ejecución.
2. Crea la base de datos:

   ```sql
   CREATE DATABASE usermanagementdb;
   ```

3. Clona el repositorio:

   ```bash
   git clone https://github.com/Elizabethpnarvaezp/ntt-challenge.git
   cd ntt-challenge
   ```

4. Ejecuta el proyecto:

   ```bash
   ./mvnw spring-boot:run
   ```

5. Una vez en ejecución, accede al endpoint:  
   `http://localhost:8080/api/auth/login`

---

## Usuario de prueba

Puedes usar el siguiente usuario DummyJSON para autenticarte:

- **Username:** `emilys`
- **Password:** `emilyspass`

---

## Ejemplo `curl` para autenticación

```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"emilys","password":"emilyspass"}'
```

---

## Registro de login en base de datos

Cada vez que se realiza un login exitoso, se guarda un registro en la tabla `login_log` con los siguientes campos:

- `id`: UUID único
- `username`: Nombre del usuario autenticado
- `login_time`: Fecha y hora del login (timestamp)
- `access_token`: Token de acceso recibido
- `refresh_token`: (simulado)

---

## Requisitos cubiertos

-  Autenticación usando `/auth/login` de DummyJSON
-  Consulta del usuario autenticado con `/auth/me`
-  Registro en la base de datos PostgreSQL
-  Uso de Feign Client para consumo externo
-  Manejo de `accessToken` desde cookies
-  Principios SOLID aplicados
-  Prueba unitaria para flujo de login

---

## Licencia

MIT License
