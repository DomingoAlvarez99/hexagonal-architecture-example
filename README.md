## Videoclub hexagonal
> Este proyecto es un ejemplo práctico del desarrollo de una api siguiendo una Arquitectura Hexagonal.

### Tecnologías usadas
`Java` `Maven` `Spring-boot` `MongoDB` `Swagger` 

### :gear: Instalación del proyecto
1. Clonar el repositorio en tu equipo:
```sh
> cd <folder path>
> git clone https://github.com/DomingoAlvarez99/videoclub-hexagonal-sync
```
2. Importar el proyecto mediante **IntelliJ IDEA**
   1. **Import Project**, y seleccionar la carpeta del proyecto.
   1. Marcar **Create Project from external model**, elegir **Maven**.  
   
3. Ejecución.
   1. Desplegar el proyecto localmente: `> mvn clean install`
   1. Arrancar el proyecto: `> mvn spring-boot:run -pl videoclub-application`

### :book: Más información
1. Arquitectura hexagonal y DDD

   La arquitectura hexagonal se considera una arquitectura limpia ya que separa la lógica de negocio de la bases de datos y de otros agentes externos.
   1. Independiente del framework.
   1. Testable.
   1. Promueve la inyección de dependencias.
   1. Independiente de la UI
   1. Independiente de la base de datos.
   1. Independiente de agentes externos.
   1. Reutilizable.
   1. Mantenible.

2. Módulos maven

    Un módulo de maven es un sub-proyecto. El proyecto padre debe de tener el packaging de tipo **pom** mientas que los hijos deben de tener packaging de tipo **jar**.
    
3. Tipos de pruebas unitarias

    1. Pruebas unitarias "normales".
    1. Pruebas unitarias mockeadas.
    1. Pruebas unitarias de integración. Estas llevan el sufijo **IT**.

4. Validaciones

    Las validaciones de los modelos se realizan a través de anotaciones.
    
5. Mapping de atributos

    Los mapeados de atributos se realizan usando la librería JMAPPER.
    
    https://www.baeldung.com/java-performance-mapping-frameworks

6. Swagger

   http://localhost:7070/api/v0/swagger-ui.html#
