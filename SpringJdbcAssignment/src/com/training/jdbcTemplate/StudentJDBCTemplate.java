package com.training.jdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.training.dao.StudentDAO;
import com.training.mapper.ExamTemplateMapper;
import com.training.pojo.ExamTemplate;
import com.training.pojo.Student;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public ExamTemplate getStudent(Integer id) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL = "select name,age,Exam_name from student_2,exam,examtemplate where student_2.id=examtemplate.ID and exam.id=examtemplate.EXAM_Id and student_2.id=?";

		ExamTemplate student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new ExamTemplateMapper());

		return student;

	}

	@Override
	public void create(String examName, String name, Integer age) {

		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL1 = "insert into Exam ( EXAM_NAME) values(?)";
		String SQL2 = "INSERT INTO Student_2 (NAME, AGE) values (?,?)";
		String SQL3 = "INSERT INTO examtemplate (STUDENT_Id, EXAM_Id) values (?,?)";

		// save data and return its identity id...
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplateObject.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL1, new String[] { "id" });
				ps.setString(1, examName);
				return ps;
			}
		}, keyHolder);

		Integer ExamId = Integer.parseInt(keyHolder.getKey().toString());

		// save data and return its identity id...
		KeyHolder keyHolder2 = new GeneratedKeyHolder();

		jdbcTemplateObject.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL2, new String[] { "id" });
				ps.setString(1, name);
				ps.setInt(2, age);

				return ps;
			}
		}, keyHolder2);

		Integer studentId = Integer.parseInt(keyHolder2.getKey().toString());

		jdbcTemplateObject.update(SQL3, ExamId, studentId);
		System.out.println("Created Record Name = " + name + " Age = " + age + " " + examName);
		return;

	}

	@Override
	public List<ExamTemplate> listStudents() {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL = "select name,age,Exam_name from student_2,exam,examtemplate where student_2.id=examtemplate.ID and exam.id=examtemplate.EXAM_Id";
		List<ExamTemplate> students = jdbcTemplateObject.query(SQL, new ExamTemplateMapper());
		return students;
	}

	@Override
	public void update(String name, Integer age, String examName, int id) {

		String SQL = "update student_2,exam,examtemplate set student_2.name =?,student_2.age = ?, exam.exam_name= ? where student_2.id=examtemplate.ID and exam.id=examtemplate.EXAM_Id and student_2.id=?";

		;
		jdbcTemplateObject.update(SQL, name, age, examName, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

	

	@Override
	public void delete(Integer id) {
		String SQL3 = "delete from examtemplate where id = ?";
		String SQL1 = "delete from student_2 where id = ?";
		String SQL2 = "delete from exam where id = ?";
		
		jdbcTemplateObject.update(SQL3, id);
		jdbcTemplateObject.update(SQL1, id);
		jdbcTemplateObject.update(SQL2, id);
	
		System.out.println("Deleted Record with ID = " + id);
		return;
	}


}