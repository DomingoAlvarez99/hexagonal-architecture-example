package org.dalvarez.videoclub.domain.services;

import org.dalvarez.videoclub.domain.models.Movie;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public interface MovieService {

    Stream<Movie> readAll();

    Movie readById(final String id);

    Movie create(final Movie movie);

    Movie update(final Movie movie);

    void deleteById(final String id);

    Movie findByName(final String name);

    Movie updateDescription(String id, String description);
}
