package com.project.simplecrudreactspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.simplecrudreactspringboot.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
	Group findByName(String name);
}