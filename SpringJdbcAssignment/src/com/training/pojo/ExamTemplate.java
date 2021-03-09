package com.training.pojo;

public class ExamTemplate {

	private int id;
	
	private Student student;
	private Exam exam;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	@Override
	public String toString() {
		return "ExamTemplate [id=" + id + ", student=" + student + ", exam=" + exam + "]";
	}
	
	
}
