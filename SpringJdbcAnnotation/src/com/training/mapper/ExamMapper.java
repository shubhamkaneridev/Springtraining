package com.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.pojo.Exam;

public class ExamMapper implements RowMapper<Exam> {

	public Exam mapRow(ResultSet rs, int rowNum) throws SQLException {

		Exam exam = new Exam();
		exam.setId(rs.getInt("ID"));
		exam.setStudentName(rs.getString("STUDENT_NAME"));
		exam.setDate(rs.getString("DATE"));
		exam.setAttendence(rs.getBoolean("ATTENDENCE"));

		return exam;
		
		
	}
}