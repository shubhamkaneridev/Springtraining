package com.commons.entity;

public class Professor {

	private int id;
	private String professoreName;

	private College college;

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfessoreName() {
		return professoreName;
	}

	public void setProfessoreName(String professoreName) {
		this.professoreName = professoreName;
	}

}
