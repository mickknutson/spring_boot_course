package com.springclass.boot.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springclass.boot.domain.User;
import com.springclass.boot.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping("/users")
	public String allUsers(Map<String, Object> model) {
		Iterable<User> users = repository.findAll();
		model.put("users", users);
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String findUserById(@PathVariable Long id, Map<String, Object> model) {
		User user = repository.findOne(id);
		model.put("user", user);
		return "user";
	}
}
