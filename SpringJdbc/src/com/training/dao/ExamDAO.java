package com.training.dao;


import java.util.List;

import javax.sql.DataSource;

import com.training.pojo.Exam;

public interface ExamDAO {

	public void setDataSource(DataSource ds);

	public void create(String date, boolean attendence, String studentName);

	public Exam getExam(Integer id);

	public List<Exam> listExam();

	public void delete(Integer id);

	public void update(Integer id, String studentName);
	
	
}