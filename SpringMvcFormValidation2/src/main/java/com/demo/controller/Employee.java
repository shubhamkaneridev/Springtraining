package com.demo.controller;
import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	@NotNull
	@Size(max =8 ,min=3,message =" Enter valid name")
	private String name;
	@Size(min=1,message="required")
	private String pass;
	
	@NotBlank(message = "not blank")
	@Email(message = "must be valid")
	private String email;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@DateTimeFormat
	private Date date;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
