package com.dalvarez.videoclub.domain.services.impl;

import com.dalvarez.videoclub.domain.models.Movie;
import com.dalvarez.videoclub.domain.ports.MoviePersistence;
import com.dalvarez.videoclub.domain.services.MovieService;

import java.util.stream.Stream;

public class MovieServiceImpl implements MovieService {

    private MoviePersistence moviePersistence;

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
    public Movie create(final Movie movie) {
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
    public Movie updateDescription(String id, String description) {
        return moviePersistence.updateDescription(id, description);
    }

}
