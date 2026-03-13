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

## Despliegue en Railway

La app ya esta preparada para Railway:

- Usa el puerto dinamico con `PORT`.
- Lee el secreto JWT desde `APP_JWT_SECRET`.
- Guarda H2 en archivo con `DB_PATH` para poder persistir si montas un volumen.

### Pasos

1. Sube este repositorio a GitHub.
2. En Railway crea un proyecto nuevo con **Deploy from GitHub repo**.
3. Selecciona este repositorio.
4. En el servicio, agrega una variable:
   `APP_JWT_SECRET=pon-aqui-una-clave-larga-y-segura-de-32-caracteres-o-mas`
5. Opcional pero recomendado: agrega un volumen y montalo en `/app/data`.
6. Si montaste el volumen, agrega tambien:
   `DB_PATH=/app/data/gymdb`

### Resultado esperado

- URL publica de Railway: la API quedara accesible alli.
- Login: `POST /api/auth/login`
- Registro: `POST /api/auth/register`
- Miembros: `/api/members`
- Clases: `/api/classes`

### Nota importante

Si no montas un volumen, la app funciona igual, pero la base H2 se reinicia cuando Railway reconstruye o reinicia el contenedor.
