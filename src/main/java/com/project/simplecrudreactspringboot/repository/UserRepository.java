package com.project.simplecrudreactspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.simplecrudreactspringboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String name);
}