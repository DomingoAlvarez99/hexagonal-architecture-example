package org.dalvarez.videoclub.domain.ports;

import org.dalvarez.videoclub.domain.models.Movie;

public interface MoviePersistence extends GenericPersistence<Movie, String> {

    Movie findByName(String name);

    Movie updateDescription(String id, String description);
}
