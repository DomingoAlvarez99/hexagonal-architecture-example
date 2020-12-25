package org.dalvarez.videoclub.application;

import org.dalvarez.videoclub.domain.ports.MoviePersistence;
import org.dalvarez.videoclub.domain.services.MovieService;
import org.dalvarez.videoclub.domain.services.impl.MovieServiceImpl;
import org.dalvarez.videoclub.persistence_h2.adapters.MoviePersistenceH2Adapter;
import org.dalvarez.videoclub.rest_web.controllers.MovieController;
import org.dalvarez.videoclub.rest_web.exception_handler.ApiExceptionHandler;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackageClasses = {ApiExceptionHandler.class})
@Configuration
//@EnableMongoRepositories(basePackageClasses = {org.dalvarez.videoclub.persistence_mongodb.repositories.MovieRepository.class})
@EntityScan(basePackageClasses = {org.dalvarez.videoclub.persistence_h2.entities.MovieEntity.class})
@EnableJpaRepositories(basePackageClasses = { org.dalvarez.videoclub.persistence_h2.repositories.MovieRepository.class })
public class ApplicationConfiguration {

    @Bean
    public MovieService movieService(MoviePersistence moviePersistence) {
        return new MovieServiceImpl(moviePersistence);
    }

    /*
    @Bean
    public MoviePersistence moviePersistence(org.dalvarez.videoclub.persistence_mongodb.repositories.MovieRepository movieRepository) {
        return new MoviePersistenceMongodbAdapter(movieRepository);
    }
     */

    @Bean
    public MoviePersistence moviePersistence(org.dalvarez.videoclub.persistence_h2.repositories.MovieRepository movieRepository) {
        return new MoviePersistenceH2Adapter(movieRepository);
    }

    @Bean
    public MovieController movieController(MovieService movieService) {
        return new MovieController(movieService);
    }

}
