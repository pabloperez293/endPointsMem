# productos-api

API REST sencilla en Spring Boot para gestionar productos.

## Características
- CRUD de productos mediante endpoints REST
- Almacenamiento en memoria para pruebas y aprendizaje
- Estructura básica lista para extenderse con base de datos

## Requisitos
- Java 21
- Maven

## Ejecución
Desde la carpeta del proyecto, ejecuta:

```bash
./mvnw spring-boot:run
```

En Windows:

```powershell
mvnw.cmd spring-boot:run
```

## Endpoints disponibles

- GET /productos
- GET /productos/{id}
- POST /productos
- PUT /productos/{id}
- DELETE /productos/{id}

## Ejemplo de cuerpo para crear un producto

```json
{
  "id": 1,
  "nombre": "Laptop",
  "precio": 999.99
}
```

## Estructura del proyecto

- src/main/java: código fuente de la aplicación
- src/main/resources: archivos de configuración
- src/test/java: pruebas del proyecto
