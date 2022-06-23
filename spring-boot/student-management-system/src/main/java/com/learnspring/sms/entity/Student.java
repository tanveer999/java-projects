package com.learnspring.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Entity annotation defines that a class can be mapped to a table 
@Table(name="students") 
// Table means the actual Database table that you will access through your program
// if @Table is not provided JPA creates table with class name
public class Student {
	@Id // @Id annotation specifies the primary key of an entity
	@GeneratedValue // @GeneratedValue provides for the specification of generation strategies for the values of primary keys
	private Long id;
	
	// If @Column is not specified JPA creates column with the instance variable name
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	// hibernate requires default constructor

	public Student() {
		
	}
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
