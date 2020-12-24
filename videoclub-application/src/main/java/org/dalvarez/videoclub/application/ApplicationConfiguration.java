package org.dalvarez.videoclub.application;

import org.dalvarez.videoclub.domain.ports.MoviePersistence;
import org.dalvarez.videoclub.domain.services.MovieService;
import org.dalvarez.videoclub.domain.services.impl.MovieServiceImpl;
import org.dalvarez.videoclub.persistence_mongodb.adapters.MoviePersistenceMongodbAdapter;
import org.dalvarez.videoclub.persistence_mongodb.repositories.MovieRepository;
import org.dalvarez.videoclub.rest_web.controllers.MovieController;
import org.dalvarez.videoclub.rest_web.exception_handler.ApiExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackageClasses = {ApiExceptionHandler.class})
//@ComponentScan(basePackageClasses = {ApiExceptionHandler.class, MovieController.class, MoviePersistenceMongodbAdapter.class, MovieServiceImpl.class})
@Configuration
@EnableMongoRepositories(basePackageClasses = { MovieRepository.class })

public class ApplicationConfiguration {

    @Bean
    public MovieService movieService(MoviePersistence moviePersistence) {
        return new MovieServiceImpl(moviePersistence);
    }

    @Bean
    public MoviePersistence moviePersistence(MovieRepository movieRepository) {
        return new MoviePersistenceMongodbAdapter(movieRepository);
    }

    @Bean
    public MovieController movieController(MovieService movieService) {
        return new MovieController(movieService);
    }

}
