package com.demo.controller;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	@NotNull
	@Size(max =8 ,min=3,message =" Enter valid name")
	private String name;
	@Size(min=1,message="required")
	private String pass;
	
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
