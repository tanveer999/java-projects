package com.learnspring.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspring.sms.entity.Student;
import com.learnspring.sms.repository.StudentRepository;
import com.learnspring.sms.service.StudentService;

@Service
// It is used to mark the class as a service provider. 
// So overall @Service annotation is used with classes that provide some business functionalities
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository; // injecting the repository interface
	
	// constructor base DI
	// when there is only one constructor, @Autowired annotation can be skipped 
	public StudentServiceImpl(StudentRepository studentRepository) { 
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
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
