package com.commons.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.commons.entity.CollegeProfessionMapper;
import com.commons.entity.Professor;

public class StudentJDBCTemplate implements CollegeProfessionDAO {
	private JdbcTemplate jdbcTemplateObject;

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String collegeName, String professorName) {

		try {
			String SQL1 = "insert into college (college_Name) values (?)";
			jdbcTemplateObject.update(SQL1, collegeName);

			String SQL2 = "select max(id) from college";
			Number number = jdbcTemplateObject.queryForObject(SQL2, null, Integer.class);

			String SQL3 = "insert into professor(professor_name,college_id) values (?,?)";
			jdbcTemplateObject.update(SQL3, professorName, number);

			System.out.println("Created data Sucessfully");

		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}

	}

	@Override
	public List<Professor> listCollegeProfessor() {

		String SQL = "\r\n"
				+ "select professor.professor_name,college.college_name from college, professor where professor.college_id=college.id;";
		List<Professor> professors = jdbcTemplateObject.query(SQL, new CollegeProfessionMapper());

		return professors;

	}

	@Override
	public List<Professor> getProfessor(int id) {

		String SQL = "select professor.professor_name,college.college_name from college, professor where professor.college_id=college.id and college.id=?"
				+ "";
		List<Professor> professors = jdbcTemplateObject.query(SQL, new Object[] { id }, new CollegeProfessionMapper());

		return professors;

	}

	@Override
	public void delete(Integer id) {

		String SQL2 = "delete from professor where id=?";

		jdbcTemplateObject.update(SQL2, id);
		System.out.println("Deleted Record with ID = " + id);
		return;

	}

	@Override
	public void updateProfessor(String collegeName, int professorId) {
		String SQL = "update professor set college_id=(select id from college where college_name=?) where id=?" + "";

		jdbcTemplateObject.update(SQL, collegeName, professorId);
		System.out.println("Updated Record with ID = " + professorId);
		return;
	}

}