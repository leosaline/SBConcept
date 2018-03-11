package com.wroclaw.saline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wroclaw.saline.entity.User;
import com.wroclaw.saline.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/newuser/{name}/{login}/{password}", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User createUser(@PathVariable(value="name") String name, @PathVariable(value="login") String login,
			@PathVariable(value="password") String password) {
		User user = new User();
		user.setLogin(login);
		user.setName(name);
		user.setPassword(password);
		
		return userService.createUser(user);
	}
	
	@RequestMapping(value="/finduser/{login}" , method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public User findUser(@PathVariable(value="login") String login) {
		return userService.findUserByNameOrLogin(login);
	}
	
}
