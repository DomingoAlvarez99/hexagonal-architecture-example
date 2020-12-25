package org.dalvarez.videoclub.persistence_h2.repositories;

import org.dalvarez.videoclub.persistence_h2.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {

}
