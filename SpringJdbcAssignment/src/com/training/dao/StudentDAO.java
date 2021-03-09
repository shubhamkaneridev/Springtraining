package com.training.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.training.pojo.ExamTemplate;
import com.training.pojo.Student;

public interface StudentDAO {
	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the Student table.
	 */


	public void create(String examName, String name, Integer age);
	public List<ExamTemplate> listStudents();
	
	public ExamTemplate getStudent(Integer id);
	

	

	public void update(String name, Integer age, String examName, int id);
	public void delete(Integer id);
}