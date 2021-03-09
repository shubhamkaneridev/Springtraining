package com.training.pojo;

public class Exam {

	private int id;
	private String examName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", examName=" + examName + "]";
	}
	
	
	
}
