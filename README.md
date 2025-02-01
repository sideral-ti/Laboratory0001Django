


### Swagger
Swagger

http://localhost:9000/sideralti/api/v1/swagger-ui/index.html

http://localhost:9000/sideralti/api/v1/api-docs



### Estructura en capas del proyecto

```plaintext
proyecto-crud/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── proyectocrud/
│   │   │               ├── ProyectoCrudApplication.java
│   │   │               ├── config/
│   │   │               │   └── DatabaseConfig.java
│   │   │               ├── controller/
│   │   │               │   └── ProyectoController.java
│   │   │               ├── dto/
│   │   │               │   └── ProyectoDTO.java
│   │   │               ├── entity/
│   │   │               │   ├── Proyecto.java
│   │   │               │   ├── EstadoProyecto.java
│   │   │               │   └── NivelPrioridad.java
│   │   │               ├── mapper/
│   │   │               │   └── ProyectoMapper.java
│   │   │               ├── repository/
│   │   │               │   └── ProyectoRepository.java
│   │   │               └── service/
│   │   │                   └── ProyectoService.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       ├── data.sql
│   │       └── schema.sql
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── proyectocrud/
│                       └── ProyectoServiceTest.java
└── pom.xml
```