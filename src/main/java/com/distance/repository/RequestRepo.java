package com.distance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.distance.modal.Path;

@Repository
public interface RequestRepo extends MongoRepository<Path, String> {

	

}
