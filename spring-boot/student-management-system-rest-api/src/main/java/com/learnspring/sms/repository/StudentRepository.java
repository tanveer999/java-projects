package com.learnspring.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
