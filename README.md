## Videoclub hexagonal
> Este proyecto es un ejemplo práctico del desarrollo de una API REST siguiendo una Arquitectura Hexagonal.

### Tecnologías necesarias
`Java` `Maven`

### :gear: Instalación del proyecto
1. Clonar el repositorio en tu equipo:
```sh
> cd <folder path>
> git clone https://github.com/DomingoAlvarez99/videoclub-hexagonal-sync
```
2. Importar el proyecto mediante **IntelliJ IDEA**
   1. **Import Project**, y seleccionar la carpeta del proyecto.
   1. Marcar **Create Project from external model**, elegir **Maven**.  

### :wrench: Configuración
1. Bean & context
   1. MongoDB
   ```java
   package org.dalvarez.videoclub.application;

   @EnableMongoRepositories(basePackageClasses = {org.dalvarez.videoclub.persistence_mongodb.repositories.MovieRepository.class})
   public class ApplicationConfiguration {

       @Bean
       public MoviePersistence moviePersistence(org.dalvarez.videoclub.persistence_mongodb.repositories.MovieRepository movieRepository) {
           return new MoviePersistenceMongodbAdapter(movieRepository);
       }

   }
   ```
   2. JPA & H2
   ```java
   package org.dalvarez.videoclub.application;

   @EntityScan(basePackageClasses = {org.dalvarez.videoclub.persistence_h2.entities.MovieEntity.class})
   @EnableJpaRepositories(basePackageClasses = {org.dalvarez.videoclub.persistence_h2.repositories.MovieRepository.class})
   public class ApplicationConfiguration {

       @Bean
       public MoviePersistence moviePersistence(org.dalvarez.videoclub.persistence_h2.repositories.MovieRepository movieRepository) {
           return new MoviePersistenceH2Adapter(movieRepository);
       }

   }
   ```
2. Application.properties
   1. MongoDB
   ```properties
   spring.data.mongodb.auto-index-creation=false
   ```
   2. JPA & H2
   ```properties
   spring.jpa.database=H2
   spring.jpa.hibernate.ddl-auto=create
   spring.database.driverClassname=org.h2.Driver
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.datasource.username=sa
   spring.datasource.password=
   ```

### :rocket: Ejecución
1. Desplegar el proyecto localmente: `> mvn clean install`
2. Arrancar el proyecto: `> mvn spring-boot:run -pl videoclub-application`

