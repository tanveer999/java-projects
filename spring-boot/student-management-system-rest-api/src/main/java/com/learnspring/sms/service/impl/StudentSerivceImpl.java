package com.learnspring.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.sms.model.Student;
import com.learnspring.sms.repository.StudentRepository;
import com.learnspring.sms.service.StudentService;

@Service
public class StudentSerivceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	public StudentSerivceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}
	
}
