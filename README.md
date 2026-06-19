# asistencia-escolar

Repositorio principal del sistema escolar.

## Componentes

- `com.colegio.asistencia`: aplicación principal existente.
- `com.colegio.asistencia`: incluye asistencia, cursos, estudiantes, notas y comunicaciones.

## Comunicaciones

La funcionalidad de comunicaciones quedó integrada directamente en la aplicación principal bajo:

- [src/main/java/com/colegio/asistencia/model/Comunicacion.java](src/main/java/com/colegio/asistencia/model/Comunicacion.java)
- [src/main/java/com/colegio/asistencia/repository/ComunicacionRepository.java](src/main/java/com/colegio/asistencia/repository/ComunicacionRepository.java)
- [src/main/java/com/colegio/asistencia/service/ComunicacionService.java](src/main/java/com/colegio/asistencia/service/ComunicacionService.java)
- [src/main/java/com/colegio/asistencia/controller/ComunicacionController.java](src/main/java/com/colegio/asistencia/controller/ComunicacionController.java)

### Ejecución

Para levantar **todo el sistema** (asistencia + comunicaciones) desde el IDE, ejecuta la clase [AsistenciaApplication](src/main/java/com/colegio/asistencia/AsistenciaApplication.java).

También puedes levantarla desde la raíz del proyecto con Maven:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicación integrada expone comunicaciones en el mismo proceso.

### Endpoint de comunicaciones

- `GET /api/comunicaciones/todas`
- `POST /api/comunicaciones/registrar`
- `GET /api/comunicaciones/{id}`
- `GET /api/comunicaciones/curso/{cursoId}`
- `GET /api/comunicaciones/estudiante/{estudianteId}`
- `GET /api/comunicaciones/tipo/{tipo}`
- `DELETE /api/comunicaciones/{id}`

### Pruebas

```bash
mvn test
```

### Endpoint base

- `http://localhost:8083`

### Base de datos

```sql
CREATE DATABASE colegiodb;
```
