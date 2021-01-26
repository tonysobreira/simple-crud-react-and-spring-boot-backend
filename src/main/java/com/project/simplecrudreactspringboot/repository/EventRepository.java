package com.project.simplecrudreactspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.simplecrudreactspringboot.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	Event findByTitle(String title);
}