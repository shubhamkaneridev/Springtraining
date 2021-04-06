package org.o7planning.springmvcforms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applicants")
public class Applicant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 50, nullable = false)
	private String id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "position", length = 50, nullable = false)	
	private String position;

	@Column(name = "gender", length = 10, nullable = false)
	private String gender;

	@Column(name = "skills", length = 255, nullable = false)
	private String skills;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}