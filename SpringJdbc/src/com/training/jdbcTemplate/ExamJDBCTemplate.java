package com.training.jdbcTemplate;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.training.dao.ExamDAO;
import com.training.mapper.ExamMapper;
import com.training.pojo.Exam;

public class ExamJDBCTemplate implements ExamDAO {
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String date, boolean attendence, String studentName) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL = "insert into Exam (DATE, ATTENDENCE,STUDENT_NAME) values (?, ?,?)";

		jdbcTemplateObject.update(SQL, date, attendence, studentName);
		System.out.println("Created Record StudentName = " + studentName + " Date = " + date + " Attendence" + attendence);
		
		return;

	}

	@Override
	public Exam getExam(Integer id) {
		
		String SQL = "select * from Exam where id = ?";
		
		Exam exam = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new ExamMapper());
		
		return exam;

	}

	@Override
	public List<Exam> listExam() {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL = "select * from Exam";
		List<Exam> exam = jdbcTemplateObject.query(SQL, new ExamMapper());
		return exam;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Exam where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	public void update(Integer id, String studentName) {
		String SQL = "update Exam set STUDENT_NAME = ? where id = ?";
		jdbcTemplateObject.update(SQL, studentName, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

	

}