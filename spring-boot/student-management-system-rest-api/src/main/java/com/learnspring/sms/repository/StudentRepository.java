package com.learnspring.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learnspring.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	// get student by email
	// :email indicates use of email parameter
	// (?1) indicates the use of first parameter
	
	@Query(value = "SELECT first_name FROM student WHERE email= :email", nativeQuery = true)
//	@Query(value = "SELECT * FROM student WHERE email= :(?1)", nativeQuery = true)
	public String findStudentFirstNameByEmail(String email);
	
	@Query(value = "SELECT * FROM student WHERE email= :email", nativeQuery = true)
	public Student findStudentByEmail(String email);
}
