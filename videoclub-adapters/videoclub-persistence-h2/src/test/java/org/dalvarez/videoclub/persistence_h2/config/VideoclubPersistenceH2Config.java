package org.dalvarez.videoclub.persistence_h2.config;

import org.dalvarez.videoclub.domain.ports.MoviePersistence;

import org.dalvarez.videoclub.persistence_h2.adapters.MoviePersistenceH2Adapter;
import org.dalvarez.videoclub.persistence_h2.entities.MovieEntity;
import org.dalvarez.videoclub.persistence_h2.repositories.MovieRepository;
import org.dalvarez.videoclub.persistence_h2.service.SeederService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {MovieRepository.class})
@EntityScan(basePackageClasses = {MovieEntity.class})
@EnableAutoConfiguration
public class VideoclubPersistenceH2Config {

    @Bean
    public MoviePersistence articlePersistence(MovieRepository movieRepository) {
        return new MoviePersistenceH2Adapter(movieRepository);
    }

    @Bean
    public SeederService seederService(MovieRepository movieRepository) {
        return new SeederService(movieRepository);
    }

}

