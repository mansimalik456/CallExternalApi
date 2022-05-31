package com.externalApi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.externalApi.model.VersionData;

@Repository
public interface VersionRepository extends MongoRepository<VersionData, String>{

}
