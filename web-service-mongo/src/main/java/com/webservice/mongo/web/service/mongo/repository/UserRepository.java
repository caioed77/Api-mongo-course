package com.webservice.mongo.web.service.mongo.repository;

import com.mongodb.client.MongoClient;
import com.webservice.mongo.web.service.mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
