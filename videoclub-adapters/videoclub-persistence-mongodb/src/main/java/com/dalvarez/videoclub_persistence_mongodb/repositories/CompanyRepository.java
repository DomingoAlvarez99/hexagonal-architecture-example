package com.dalvarez.videoclub_persistence_mongodb.repositories;

import com.dalvarez.videoclub_persistence_mongodb.entities.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<CompanyEntity, String>  {

}
