package org.dalvarez.videoclub.domain.services;

import org.dalvarez.videoclub.domain.config.TestConfig;
import org.dalvarez.videoclub.domain.models.Movie;
import org.dalvarez.videoclub.domain.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@TestConfig
class MovieServiceTest {

    @MockBean
    private MovieService movieService;

    @Test
    void testCreate() {
        Movie expectedMovie = Utils.getDefaultMovie();
        given(movieService.create(any())).willReturn(expectedMovie);
        Movie movie = movieService.create(any());
        verify(movieService, times(1)).create(any());

        assertEquals(movie.getId(), expectedMovie.getId());
        assertEquals(movie.getName(), expectedMovie.getName());
        assertEquals(movie.getDescription(), expectedMovie.getDescription());
        assertEquals(movie.getPublicationDate(), expectedMovie.getPublicationDate());
        assertEquals(movie.getRegistrationDate(), expectedMovie.getRegistrationDate());
        assertEquals(movie.getCompany(), expectedMovie.getCompany());
        assertArrayEquals(movie.getCategories().toArray(), expectedMovie.getCategories().toArray());
        assertEquals(movie, expectedMovie);
    }

}
