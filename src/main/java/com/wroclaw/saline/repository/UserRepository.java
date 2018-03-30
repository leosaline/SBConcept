package com.wroclaw.saline.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wroclaw.saline.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query(value="Select u from User u where u.login = :login ")
	public User findUserByLogin(@Param("login") String login);
	
}
