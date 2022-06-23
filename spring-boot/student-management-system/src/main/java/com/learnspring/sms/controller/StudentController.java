package com.learnspring.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learnspring.sms.entity.Student;
import com.learnspring.sms.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService; // injecting StudentService

	// only one constructor so no need of @Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler method to handle list students and return model and view

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());

		return "students"; // students is the view
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student"; // create student is a view
	}

	@PostMapping("/students")
	// @ModelAttribute is an annotation that binds a method parameter or
	// method return value to a named model attribute,
	// and then exposes it to a web view.
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("students/{id}")
	public String updateStudent(@PathVariable Long id , @ModelAttribute("student") Student student, Model model) {
		// get student from DB by id
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save the updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
