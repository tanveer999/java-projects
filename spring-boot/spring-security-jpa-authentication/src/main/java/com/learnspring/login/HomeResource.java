package com.learnspring.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	@GetMapping("/")
	public String home() {
		return("Home page");
	}
	
	@GetMapping("/user")
	public String user() {
		return("User page");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return("Admin page");
	}
}
