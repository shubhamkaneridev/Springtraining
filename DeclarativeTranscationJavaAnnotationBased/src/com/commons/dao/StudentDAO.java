package com.commons.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.Transactional;

import com.commons.entity.StudentMarks;

@Transactional
public interface StudentDAO {
	

	/**
	 * This is the method to be used to create a record in the Student and Marks
	 * tables.
	 */
	public void create(String name, Integer age, Integer marks, Integer year);

	/**
	 * This is the method to be used to list down all the records from the Student
	 * and Marks tables.
	 */
	public List<StudentMarks> listStudents();

	public void delete(Integer id);

	public void update(Integer id, String studentName, int marks, int year, int age);

	public StudentMarks getStudent(int id);

}