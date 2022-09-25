package com.ta.springboorhelloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String ok() {
		return "ok";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello TA";
	}
}
