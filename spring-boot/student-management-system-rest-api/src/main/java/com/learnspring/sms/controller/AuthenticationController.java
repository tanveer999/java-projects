package com.learnspring.sms.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.sms.model.Student;
import com.learnspring.sms.service.StudentService;


@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {
	
	Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private StudentService studentService;
	
	// default user name: user
	// password: (Using generated security password:) can be found in console
	@GetMapping("/security/all")
	public String allApiTest() {
		return "Accessible by All";
	}
	
	@GetMapping("/security/user")
	public String userApiTest() {
		return "Accessible by User";
	}
	
	@GetMapping("/security/admin")
	public String adminApiTest() {
		return "Accessible only by Admin";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String, String> student) {
		
		try {
			Student existingStudent = studentService.getStudentByEmail(student.get("email"));
			if(existingStudent.getPassword().equals(student.get("password"))) {
				logger.info(existingStudent.toString());
				return "Login Successful";
			} else {
				logger.info("Invalid credentials");
				return "Invalid Password";
			}
		}
		
		catch(NullPointerException e ) {
			logger.info("Student dosen't exist");
			return "Student dosen't exist with Email: " + student.get("email");
		}
		
	}
	
}
