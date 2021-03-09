package com.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.pojo.Exam;
import com.training.pojo.ExamTemplate;
import com.training.pojo.Student;

public class ExamTemplateMapper implements RowMapper<ExamTemplate> {
	public ExamTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		ExamTemplate examTemplate = new ExamTemplate();
		Exam exam = new Exam();
		exam.setExamName(rs.getString("EXAM_NAME"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		examTemplate.setExam(exam);
		examTemplate.setStudent(student);
		return examTemplate;
	}
}