package com.wroclaw.saline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wroclaw.saline.entity.User;
import com.wroclaw.saline.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User findUserByNameOrLogin(String login) {
		return userRepository.findUserByLogin(login);
	}

}
