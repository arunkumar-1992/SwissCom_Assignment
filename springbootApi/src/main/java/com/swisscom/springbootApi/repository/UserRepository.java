package com.swisscom.springbootApi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.swisscom.springbootApi.model.User;

public interface UserRepository extends MongoRepository<User,String > {
	
	@Query(value = "{'firstName': ?0}")
    User findUserByFirstName(String firstName);

   

}
