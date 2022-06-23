package com.learnspring.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.sms.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student getStudentById(Long id);
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
