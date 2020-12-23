package com.dalvarez.videoclub_persistence_mongodb.service;

import com.dalvarez.videoclub_persistence_mongodb.entities.MovieEntity;
import com.dalvarez.videoclub_persistence_mongodb.repositories.MovieRepository;
import com.dalvarez.videoclub_persistence_mongodb.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class SeederService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeederService.class);

    private MovieRepository movieRepository;

    public SeederService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void seedDatabase() {
        LOGGER.warn("Seeding the database");
        movieRepository.saveAll(
                Arrays.stream(Utils.getDefaultMovies())
                        .map(MovieEntity::fromMovie)
                        .collect(Collectors.toSet())
        );
        Assertions.assertEquals(Utils.getDefaultMovies().length, movieRepository.findAll().size());
    }

    public void deleteAll() {
        LOGGER.warn("Deleting the records of the database");
        movieRepository.deleteAll();
    }
}
