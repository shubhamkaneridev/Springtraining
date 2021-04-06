package com.training.pojo;

import java.util.Date;

public class Exam {

	private int id;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String studentName;
	private boolean attendence;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public boolean isAttendence() {
		return attendence;
	}

	public void setAttendence(boolean attendence) {
		this.attendence = attendence;
	}

}
