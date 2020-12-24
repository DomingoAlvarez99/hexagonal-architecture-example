package org.dalvarez.videoclub.persistence_mongodb.repositories;

import org.dalvarez.videoclub.persistence_mongodb.entities.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<CompanyEntity, String>  {

}
