package com.springclass.boot.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springclass.boot.domain.User;
import com.springclass.boot.domain.UserRepository;

@Controller
public class WelcomeController {
	
	@Autowired
	private UserRepository repository;

    /**
     * http://localhost:8080/welcome
     * @param model
     * @return
     */
	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		User user = repository.findOne(1L);
		model.put("user", user);
		return "welcome";
	}
}


/*
    *.html
    *.jsp
    *.jsf
 */