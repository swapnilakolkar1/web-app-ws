package com.opti.shope.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opti.shope.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	//below are custom methods to execute on UserEntity poperties
	
	//find user by email id
	UserEntity findByEmail(String email);
	
	//check if record exist in table for given email
	boolean existsByEmail(String email);
	
	//find user by public id
	UserEntity findByUserId(String userId);
}
