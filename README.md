# Act3 - CRUD con Spring Boot y JPA (Libro / Autor)

CRUD completo en Spring Boot con MySQL. Relación: **muchos libros pertenecen a un autor** (`@ManyToOne` / `@OneToMany`).

## Entidades

- **Autor**: `id`, `nombre`. Tiene `@OneToMany(mappedBy = "autor")`.
- **Libro**: `id`, `titulo`, `autor`. Tiene `@ManyToOne` y `@JoinColumn(name = "autor_id")`, que es la llave foránea.

![Entidad Autor](capturas/01-entidad-autor.png)
![Entidad Libro](capturas/02-entidad-libro.png)

## Estructura del proyecto

- `entity`: Autor y Libro
- `repository`: AutorRepository y LibroRepository (JpaRepository)
- `service`: LibroService (lógica de negocio)
- `controller`: LibroController y AutorController

## Endpoints

| Método | URL | Descripción |
|---|---|---|
| POST | /api/autores | Crear autor |
| GET | /api/autores | Listar autores |
| POST | /api/libros | Crear libro |
| GET | /api/libros | Listar libros |
| GET | /api/libros/{id} | Ver un libro |
| PUT | /api/libros/{id} | Actualizar libro |
| DELETE | /api/libros/{id} | Eliminar libro |

## Capturas del CRUD

### Crear
![Crear autor](capturas/03-crear-autor.png)
![Crear libro](capturas/04-crear-libro.png)

### Leer (se ve el nombre del autor, no solo el ID)
![Leer libros](capturas/05-leer-libros.png)

### Actualizar
![Actualizar libro](capturas/06-actualizar-libro.png)

### Eliminar
![Eliminar libro](capturas/07-eliminar-libro.png)

## Base de datos

Tabla `libro` con la llave foránea `autor_id`:

![Workbench](capturas/08-workbench-tablas.png)

## Cómo ejecutar

1. Crear la base de datos: `CREATE DATABASE biblioteca_db;`
2. Definir la contraseña como variable de entorno (PowerShell):

```powershell
$env:DB_PASSWORD="tu_contraseña"
.\mvnw spring-boot:run
```

La app corre en `http://localhost:8083`.