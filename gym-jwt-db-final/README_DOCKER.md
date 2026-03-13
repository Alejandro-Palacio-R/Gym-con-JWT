## Docker

### Build
```bash
docker build -t gym-jwt-db .
```

### Run
```bash
docker run --rm -p 8080:8080 gym-jwt-db
```

App: http://localhost:8080  
H2 Console: http://localhost:8080/h2-console  (JDBC URL: jdbc:h2:mem:gymdb, user: sa, pass: vacío)
