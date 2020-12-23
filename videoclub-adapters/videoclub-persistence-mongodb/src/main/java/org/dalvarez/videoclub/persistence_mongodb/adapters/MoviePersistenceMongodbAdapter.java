package org.dalvarez.videoclub.persistence_mongodb.adapters;

import org.dalvarez.videoclub.domain.exceptions.ConflictException;
import org.dalvarez.videoclub.domain.exceptions.NotFoundException;
import org.dalvarez.videoclub.domain.models.Movie;
import org.dalvarez.videoclub.domain.ports.MoviePersistence;
import org.dalvarez.videoclub.persistence_mongodb.entities.MovieEntity;
import org.dalvarez.videoclub.persistence_mongodb.repositories.MovieRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.stream.Stream;

@Transactional
public class MoviePersistenceMongodbAdapter implements MoviePersistence {

    private MovieRepository movieRepository;

    public MoviePersistenceMongodbAdapter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Stream<Movie> readAll() {
        return movieRepository.findAll()
                .stream()
                .findAny().map(e -> movieRepository.findAll().stream().map(MovieEntity::toMovie))
                .orElseThrow(() -> new NotFoundException("Movies not found"));

    }

    @Override
    public Movie readById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie id: " + id))
                .toMovie();
    }

    @Override
    public Movie create(@Valid Movie movie) {
        assertIdNotExist(movie.getId());

        return movieRepository.save(MovieEntity.fromMovie(movie))
                .toMovie();
    }

    @Override
    public Movie update(@Valid Movie movie) {
        assertIdNotExist(movie.getId());

        return movieRepository.save(MovieEntity.fromMovie(movie))
                .toMovie();
    }

    @Override
    public Movie updateDescription(String id, String description) {
        MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie id: " + id));
        movieEntity.setDescription(description);

        return movieRepository.save(movieEntity).toMovie();
    }

    @Override
    public void deleteById(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie findByName(String name) {
        return movieRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Movie name: " + name))
                .toMovie();
    }

    private void assertIdNotExist(String id) {
        movieRepository.findById(id).ifPresent(m -> {
            throw new ConflictException("Movie id already exists: " + id);
        });
    }

}
