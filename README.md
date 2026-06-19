# asistencia-escolar

Repositorio principal del sistema escolar.

## Componentes

- `com.colegio.asistencia`: aplicación principal existente.
- `com.colegio.comunicaciones`: módulo integrado de comunicaciones y mensajería.

## Microservicio de comunicaciones

El código del microservicio `ms-comunicaciones` quedó integrado en el árbol principal del repositorio bajo:

- [src/main/java/com/colegio/comunicaciones](src/main/java/com/colegio/comunicaciones)
- [src/test/java/com/colegio/comunicaciones](src/test/java/com/colegio/comunicaciones)
- [src/main/resources/application-comunicaciones.properties](src/main/resources/application-comunicaciones.properties)

### Ejecución

Para levantar la aplicación de comunicaciones desde el IDE, ejecuta la clase [MsComunicacionesApplication](src/main/java/com/colegio/comunicaciones/MsComunicacionesApplication.java).

La configuración específica del módulo usa el archivo `application-comunicaciones.properties`.

### Pruebas

```bash
mvn test
```

### Endpoint base

- `http://localhost:8083`

### Base de datos

```sql
CREATE DATABASE db_comunicaciones;
```
