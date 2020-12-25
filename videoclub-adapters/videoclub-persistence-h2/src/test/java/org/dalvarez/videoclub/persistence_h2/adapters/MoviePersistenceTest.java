package org.dalvarez.videoclub.persistence_h2.adapters;

import org.dalvarez.videoclub.domain.exceptions.NotFoundException;
import org.dalvarez.videoclub.domain.models.Movie;
import org.dalvarez.videoclub.domain.ports.MoviePersistence;
import org.dalvarez.videoclub.persistence_h2.config.TestConfig;
import org.dalvarez.videoclub.persistence_h2.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@TestConfig
class MoviePersistenceTest {

    @MockBean
    private MoviePersistence moviePersistence;

    @Test
    void testCreateSuccessful() {
        given(moviePersistence.create(any())).willReturn(Utils.getDefaultMovie());
        Movie movie = moviePersistence.create(any());
        verify(moviePersistence, times(1)).create(any());

        assertEquals(movie.getId(), Utils.DEFAULT_MOVIE_ID);
        assertEquals(movie.getName(), Utils.DEFAULT_MOVIE_NAME);
        assertEquals(movie.getDescription(), Utils.DEFAULT_MOVIE_DESCRIPTION);
        assertEquals(movie.getPublicationDate(), Utils.DEFAULT_MOVIE_PUBLICATION_DATE);
        assertEquals(movie.getRegistrationDate(), Utils.DEFAULT_MOVIE_REGISTRATION_DATE);
        assertEquals(movie.getCompany(), Utils.getDefaultCompany());
        assertArrayEquals(movie.getCategories().toArray(), Utils.getDefaultCategoryList().toArray());
        assertEquals(movie, Utils.getDefaultMovie());
    }

    @Test
    void testCreateExpectedNotFoundExceptionThrown() {
        given(moviePersistence.create(any())).willThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> moviePersistence.create(any()));

        verify(moviePersistence, times(1)).create(any());
    }

    @Test
    void testReadAll() {
        given(moviePersistence.readAll()).willReturn(Stream.of(Utils.getDefaultMovie()));
        Stream<Movie> movies = moviePersistence.readAll();
        verify(moviePersistence, times(1)).readAll();
        assertEquals(movies.count(), 1);
    }

}
