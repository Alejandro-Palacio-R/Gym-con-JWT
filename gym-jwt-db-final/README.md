# Gimnasio API (JWT + Roles)

Este proyecto cumple:

- Auth Service: **/api/auth/register** y **/api/auth/login**
- Roles: **ADMIN** y **USER**
- **ADMIN**: acceso total
- **USER**: acceso solo a 1 servicio funcional (Miembros). No puede acceder a Clases.
- Spring Security + JWT (Bearer)

## Credenciales demo

- ADMIN: `admin / admin123`
- USER: `user / user123`

## Servicios funcionales

- Servicio A (permitido a ADMIN y USER): `/api/members/**`
- Servicio B (solo ADMIN): `/api/classes/**`

## Como correr local

1. Abre el proyecto en IntelliJ.
2. Maven: Reload / Download dependencies.
3. Run: `GymApplication`.

Por defecto corre en `http://localhost:8080`.

## Despliegue en Azure

La app ya queda lista para Azure App Service o Azure Container Apps:

- Usa el puerto dinamico con `PORT`.
- Lee el secreto JWT desde `APP_JWT_SECRET`.
- Permite configurar la base por variables de entorno.
- Por defecto guarda H2 en `./data/gymdb`, que funciona localmente y dentro del contenedor.

### Variables recomendadas

- `APP_JWT_SECRET=pon-aqui-una-clave-larga-y-segura-de-32-caracteres-o-mas`
- `APP_JWT_EXPIRATION_MS=86400000`

### Si despliegas con H2 en archivo

Si quieres persistencia entre reinicios, define un path persistente en Azure:

- Azure App Service (Linux): `DB_PATH=/home/data/gymdb`
- Azure Container Apps: monta un volumen y usa algo como `DB_PATH=/mnt/data/gymdb`

Tambien puedes reemplazar H2 por una base administrada configurando:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

### Pasos generales

1. Sube este repositorio a GitHub.
2. Crea el recurso en Azure usando este repositorio o la imagen Docker.
3. Configura `APP_JWT_SECRET`.
4. Si quieres persistencia con H2, configura `DB_PATH` hacia almacenamiento persistente.
5. Despliega la app.

### Resultado esperado

- URL publica de Azure accesible.
- Login: `POST /api/auth/login`
- Registro: `POST /api/auth/register`
- Miembros: `/api/members`
- Clases: `/api/classes`

### Nota importante

Si no configuras almacenamiento persistente, la base H2 se puede perder cuando Azure recrea el contenedor o la instancia. Para un entorno mas serio, conviene usar Azure Database for PostgreSQL o MySQL.
