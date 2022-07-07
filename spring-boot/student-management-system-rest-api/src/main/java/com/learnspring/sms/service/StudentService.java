package com.learnspring.sms.service;

import java.util.List;

import com.learnspring.sms.model.Student;

public interface StudentService {
	Student addStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
	
	Student getStudentByEmail(String email);
}
