package org.dalvarez.videoclub_persistence_mongodb.config;

import com.dalvarez.videoclub.domain.ports.MoviePersistence;
import org.dalvarez.videoclub_persistence_mongodb.adapters.MoviePersistenceMongodbAdapter;
import org.dalvarez.videoclub_persistence_mongodb.repositories.MovieRepository;
import org.dalvarez.videoclub_persistence_mongodb.service.SeederService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = { MovieRepository.class })
@EnableAutoConfiguration
public class VideoclubPersistenceMongodbConfig {

    @Bean
    public MoviePersistence articlePersistence(MovieRepository movieRepository) {
        return new MoviePersistenceMongodbAdapter(movieRepository);
    }

    @Bean
    public SeederService seederService(MovieRepository movieRepository) {
        return new SeederService(movieRepository);
    }

}

