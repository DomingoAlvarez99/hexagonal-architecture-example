package com.dalvarez.videoclub.domain.ports;

import com.dalvarez.videoclub.domain.models.Movie;

public interface MoviePersistence extends GenericPersistence<Movie, String> {

    Movie findByName(String name);

    Movie updateDescription(String id, String description);
}
