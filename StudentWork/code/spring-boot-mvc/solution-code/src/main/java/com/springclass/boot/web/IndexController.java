package com.springclass.boot.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Default Message";

	// inject via application.properties
	@Value("${about.message:test}")
	private String aboutMessage = "Default About Message";

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}

	@RequestMapping("/about")
	public String about(Map<String, Object> model) {
		model.put("aboutMessage", this.aboutMessage);
		return "about";
	}
}