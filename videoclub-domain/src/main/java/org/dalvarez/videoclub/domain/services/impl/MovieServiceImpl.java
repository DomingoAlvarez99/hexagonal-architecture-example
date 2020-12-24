package org.dalvarez.videoclub.domain.services.impl;

import org.dalvarez.videoclub.domain.models.Movie;
import org.dalvarez.videoclub.domain.ports.MoviePersistence;
import org.dalvarez.videoclub.domain.services.MovieService;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

public class MovieServiceImpl implements MovieService {

    private final MoviePersistence moviePersistence;

    public MovieServiceImpl(MoviePersistence moviePersistence) {
        this.moviePersistence = moviePersistence;
    }

    @Override
    public Stream<Movie> readAll() {
        return moviePersistence.readAll();
    }

    @Override
    public Movie readById(final String id) {
        return moviePersistence.readById(id);
    }

    @Override
    public Movie create(Movie movie) {
        movie.setId(UUID.randomUUID().toString());
        movie.setRegistrationDate(LocalDate.now());

        return moviePersistence.create(movie);
    }

    @Override
    public Movie update(final Movie movie) {
        return moviePersistence.update(movie);
    }

    @Override
    public void deleteById(final String id) {
        moviePersistence.deleteById(id);
    }

    @Override
    public Movie findByName(final String name) {
        return moviePersistence.findByName(name);
    }

    @Override
    public Movie updateDescription(final String id, final String description) {
        return moviePersistence.updateDescription(id, description);
    }

}
