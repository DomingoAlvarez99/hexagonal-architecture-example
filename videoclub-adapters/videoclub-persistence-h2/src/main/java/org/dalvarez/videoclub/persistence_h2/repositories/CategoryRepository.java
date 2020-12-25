package org.dalvarez.videoclub.persistence_h2.repositories;

import org.dalvarez.videoclub.persistence_h2.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

}
