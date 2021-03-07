package com.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.pojo.Student;


public class StudentMapper implements RowMapper<Student> {
	   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Student student = new Student();
	      student.setId(rs.getInt("id"));
	      student.setName(rs.getString("name"));
	      student.setAge(rs.getInt("age"));
	      return student;
	   }
	}