package org.dalvarez.videoclub.persistence_h2.adapters;

import org.dalvarez.videoclub.domain.exceptions.ConflictException;
import org.dalvarez.videoclub.domain.exceptions.NotFoundException;
import org.dalvarez.videoclub.domain.models.Movie;
import org.dalvarez.videoclub.domain.ports.MoviePersistence;
import org.dalvarez.videoclub.persistence_h2.config.TestConfig;
import org.dalvarez.videoclub.persistence_h2.service.SeederService;
import org.dalvarez.videoclub.persistence_h2.utils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class MoviePersistenceIT {

    @Autowired
    private MoviePersistence moviePersistence;

    @BeforeAll
    static void populateDatabase(@Autowired SeederService seederService) {
        seederService.seedDatabase();
    }

    @Test
    void testCreateSuccessful() {
        Movie expectedMovie = Utils.getDefaultMovie();
        Movie persistedMovie = moviePersistence.create(expectedMovie);

        assertEquals(persistedMovie.getId(), expectedMovie.getId());
        assertEquals(persistedMovie.getName(), expectedMovie.getName());
        assertEquals(persistedMovie.getDescription(), expectedMovie.getDescription());
        assertEquals(persistedMovie.getPublicationDate(), expectedMovie.getPublicationDate());
        assertEquals(persistedMovie.getRegistrationDate(), expectedMovie.getRegistrationDate());
        assertEquals(persistedMovie.getCompany(), expectedMovie.getCompany());
        assertArrayEquals(persistedMovie.getCategories().toArray(), expectedMovie.getCategories().toArray());
        assertEquals(persistedMovie, Utils.getDefaultMovie());
    }

    @Test
    void testCreateExpectedConflictExceptionThrown() {
        Movie movie = Utils.getDefaultMovies()[0];

        assertThrows(ConflictException.class, () -> moviePersistence.create(movie));
    }

    @Test
    void testCreateExpectedInvalidDataAccessApiUsageExceptionThrown() {
        Movie movie = Utils.getDefaultMovie();
        movie.setId(null);

        assertThrows(InvalidDataAccessApiUsageException.class, () -> moviePersistence.create(movie));
    }

    @Test
    void testReadByIdSuccessful() {
        Movie expectedMovie = Utils.getDefaultMovies()[0];
        Movie obtainedMovie = moviePersistence.readById(expectedMovie.getId());

        assertEquals(obtainedMovie.getId(), expectedMovie.getId());
        assertEquals(obtainedMovie.getName(), expectedMovie.getName());
        assertEquals(obtainedMovie.getDescription(), expectedMovie.getDescription());
        assertEquals(obtainedMovie.getPublicationDate(), expectedMovie.getPublicationDate());
        assertEquals(obtainedMovie.getRegistrationDate(), expectedMovie.getRegistrationDate());
        assertEquals(obtainedMovie.getCompany(), expectedMovie.getCompany());
        assertArrayEquals(obtainedMovie.getCategories().toArray(), expectedMovie.getCategories().toArray());
        assertEquals(obtainedMovie, expectedMovie);
    }

    @Test
    void testReadByIdExpectedNotFoundExceptionThrown() {
        String notExistsId = "a60dc08f-bc6b-482c-ae90-0c5fb9f198e9";

        assertThrows(NotFoundException.class, () -> moviePersistence.readById(notExistsId));
    }
}
