package com.learnspring.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learnspring.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	// get student by email
	@Query(value = "SELECT * FROM student WHERE email= :email", nativeQuery = true)
	public Student findStudentByEmail(String email);
}
