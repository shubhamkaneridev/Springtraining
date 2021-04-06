package com.roytuts.spring.mvc.jdbc.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDetail {

	private int id;

	@NotNull
	@Size(min = 1, message = "Please Fill First Name ")
	private String firstName;

	@NotNull
	@Size(min = 1, message = "Please Fill  Name ")
	private String lastName;

	@NotEmpty(message = "is required")
	@Email(message = "Invalid email! Please enter valid email")
	private String email;

	/* @DateTimeFormat(pattern="MM/dd/yyyy") */

	/* @DateTimeFormat(pattern="MM/dd/yyyy") */
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull @Past
    private Date dob;

	public UserDetail() {
	}

	public UserDetail(int id, String firstName, String lastName, String email, Date dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
