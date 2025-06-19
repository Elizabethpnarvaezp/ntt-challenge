# User Management API

API REST que permite autenticarse usando DummyJSON y registra los logins en PostgreSQL.

---

## 🔧 Tecnologías usadas

- Java 21
- Spring Boot 3.2+
- PostgreSQL
- Feign Client
- Lombok
- JUnit 5

---

## ▶️ Ejecución

1. Asegúrate de tener PostgreSQL instalado y corriendo.
2. Crea la base de datos:
   ```sql
   CREATE DATABASE usermanagementdb;

3. Ejecuta el proyecto:
   ```mvn
   ./mvnw spring-boot:run
4. Accede al endpoint /api/auth/login.

🧑‍💻 Usuario de prueba

``` Username: emilys ```

``` Password: emilyspass ``` 

📤 Ejemplo curl de login
 ```
curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"emilys","password":"emilyspass"}'
```
5. 📁 Registro de login


Cada vez que se hace login exitoso, se guarda en la tabla login_log con los campos:

```
id: UUID único
username
login_time: Timestamp
access_token
refresh_token
```
6. 📝 Licencia: MIT License