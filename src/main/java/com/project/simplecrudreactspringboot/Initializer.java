package com.project.simplecrudreactspringboot;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.simplecrudreactspringboot.model.Event;
import com.project.simplecrudreactspringboot.model.Group;
import com.project.simplecrudreactspringboot.model.User;
import com.project.simplecrudreactspringboot.repository.EventRepository;
import com.project.simplecrudreactspringboot.repository.GroupRepository;
import com.project.simplecrudreactspringboot.repository.UserRepository;

@Component
class Initializer implements CommandLineRunner {

	private final GroupRepository groupRepository;
	private final UserRepository userRepository;
	private final EventRepository eventRepository;

	public Initializer(GroupRepository groupRepository, UserRepository userRepository, EventRepository eventRepository) {
		this.groupRepository = groupRepository;
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
	}

	@Override
	public void run(String... strings) {
		Group g1 = new Group("Denver JUG");
		Group g2 = new Group("Utah JUG");
		Group g3 = new Group("Seattle JUG");
		Group g4 = new Group("Richmond JUG");
		groupRepository.saveAll(Arrays.asList(g1, g2, g3, g4));
		
		User u1 = new User("User1", "user1@gmail.com");
		User u2 = new User("User2", "user2@gmail.com");
		User u3 = new User("User3", "user3@gmail.com");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Event e1 = new Event("Full Stack Reactive", "Reactive with Spring Boot + React", Instant.parse("2018-12-12T18:00:00.000Z"));
		Event e2 = new Event("Java Spring Boot", "Java + Spring Boot", Instant.parse("2021-01-30T18:00:00.000Z"));
		Event e3 = new Event("React REST", "React + REST", Instant.parse("2021-02-01T18:00:00.000Z"));
		eventRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		//e1.setAttendees(Collections.singleton(u1));
		e1.getAttendees().add(u1);
		e1.getAttendees().add(u2);
		//g1.setEvents(Collections.singleton(e1));
		e2.getAttendees().add(u3);
		g1.setEvents(Stream.of(e1, e2).collect(Collectors.toSet()));
		g1.setAddress("Street 1");
		g1.setCity("City 1");
		g1.setStateOrProvince("State or Province 1");
		groupRepository.save(g1);
		
		groupRepository.findAll().forEach(System.out::println);
		
//		Stream.of("Denver JUG", "Utah JUG", "Seattle JUG", "Richmond JUG")
//				.forEach(name -> groupRepository.save(new Group(name)));

//		Group djug = groupRepository.findByName("Denver JUG");
		
//		Event e = new Event("Full Stack Reactive", "Reactive with Spring Boot + React", Instant.parse("2018-12-12T18:00:00.000Z"));
		
//		djug.setEvents(Collections.singleton(e));
		
//		groupRepository.save(djug);
		
//		groupRepository.findAll().forEach(System.out::println);
	}
}