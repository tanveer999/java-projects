package com.learnspring.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.sms.model.Student;
import com.learnspring.sms.repository.StudentRepository;
import com.learnspring.sms.service.StudentService;


@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// uncomment the constructor if @Autowired is not used
//	public StudentController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable (value = "id") Long studentId) {
		return studentService.getStudentById(studentId);
	}
	
	@GetMapping("/{email}")
	public Student getStudentByEmail(@PathVariable (value = "eamil") String email) {
		return studentService.getStudentByEmail(email);
	}
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long studentId) {
		Student existingStudent = studentService.getStudentById(studentId);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		return studentService.updateStudent(existingStudent);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public void deleteStudent(@PathVariable("id") Long studentId) {
//		studentService.deleteStudentById(studentId);
//	}
	
	@DeleteMapping("/delete/")
	public void deleteStudent(@RequestParam(name = "id") Long id) {
		studentService.deleteStudentById(id);
	}
	
}
