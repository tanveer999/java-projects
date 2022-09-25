package com.learnspring.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.login.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName);
}
