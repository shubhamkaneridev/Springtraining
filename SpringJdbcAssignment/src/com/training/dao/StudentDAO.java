package com.training.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.training.pojo.ExamTemplate;
import com.training.pojo.Student;

public interface StudentDAO {

	public void setDataSource(DataSource ds);

	public void create(String examName, String name, Integer age);

	public List<ExamTemplate> listStudents();

	public ExamTemplate getStudent(Integer id);

	public void update(String name, Integer age, String examName, int id);

	public void delete(Integer id);
}