package com.commons;


public class Student {
	private int age;
	private String name;

	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
	
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
	
		return name;
	}
	public void printThrowException(){
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}
}