package com.project.simplecrudreactspringboot.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private Instant date;
	private String title;
	private String description;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<User> attendees = new HashSet<User>();

	public Event() {
	}

	public Event(String title, String description, Instant date) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
	}
	
	public Event(String title, String description, Instant date, User user) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.attendees.add(user);
	}

	public Event(Long id, Instant date, String title, String description) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<User> attendees) {
		this.attendees = attendees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", date=" + date + ", title=" + title + ", description=" + description
				+ ", attendees=" + attendees + "]";
	}

}