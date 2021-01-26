package com.project.simplecrudreactspringboot.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "user_group")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String name;
	private String address;
	private String city;
	private String stateOrProvince;
	private String country;
	private String postalCode;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Event> events = new HashSet<Event>();

	public Group() {
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group(Long id, String name, String address, String city, String stateOrProvince, String country,
			String postalCode, User user) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.country = country;
		this.postalCode = postalCode;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
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
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", stateOrProvince="
				+ stateOrProvince + ", country=" + country + ", postalCode=" + postalCode + ", user=" + user
				+ ", events=" + events + "]";
	}

}