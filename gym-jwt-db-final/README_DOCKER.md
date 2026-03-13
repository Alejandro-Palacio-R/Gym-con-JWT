## Docker

### Build
```bash
docker build -t gym-jwt-db .
```

### Run
```bash
docker run --rm -p 8080:8080 -e APP_JWT_SECRET=pon-aqui-una-clave-larga gym-jwt-db
```

App: http://localhost:8080
H2 Console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:file:./data/gymdb`, user: `sa`, pass: vacio)

## Azure

Configura al menos esta variable:

```bash
APP_JWT_SECRET=pon-aqui-una-clave-larga-y-segura
```

Para persistir H2:

- Azure App Service (Linux): `DB_PATH=/home/data/gymdb`
- Azure Container Apps con volumen: `DB_PATH=/mnt/data/gymdb`

Si usas una base administrada en Azure, define:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
