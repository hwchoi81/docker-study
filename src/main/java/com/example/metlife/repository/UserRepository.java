 package com.example.metlife.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.metlife.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,String>{

	List<User> findByUserName(String Name);
	 
}