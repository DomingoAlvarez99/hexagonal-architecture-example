package org.dalvarez.videoclub.persistence_h2.repositories;

import org.dalvarez.videoclub.persistence_h2.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity, String> {

    Optional<MovieEntity> findByName(String movie);

}
