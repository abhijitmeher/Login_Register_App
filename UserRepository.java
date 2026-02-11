package com.durgasoft.App018.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.durgasoft.App018.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	// All method available inside the mongosh repository !
	
	public User findByEmailAndPassword(String email, String password);
	
}
