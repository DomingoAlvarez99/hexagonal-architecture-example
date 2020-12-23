package org.dalvarez.videoclub.persistence_mongodb.repositories;

import org.dalvarez.videoclub.persistence_mongodb.entities.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface MovieRepository extends MongoRepository<MovieEntity, String> {

    Optional<MovieEntity> findByName(String movie);

}
