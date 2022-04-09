package com.techboat.firstwebservice.entities;

import java.time.LocalDate;
 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "the name must be present")
	private String name;
	@Size(min = 3,message = "the last name must be at least 3 character")
	private String lasteName;
	@Past(message = "the date must be in the past")
	private LocalDate dateBirth;

	public User(Long id, String name, String lasteName, LocalDate localDate) {
		super();
		this.id = id;
		this.name = name;
		this.lasteName = lasteName;
		this.dateBirth = localDate;
	}

	public User() {

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

	public String getLasteName() {
		return lasteName;
	}

	public void setLasteName(String lasteName) {
		this.lasteName = lasteName;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lasteName=" + lasteName + ", dateBirth=" + dateBirth + "]";
	}

}
