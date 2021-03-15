package com.commons.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.commons.entity.CollegeProfession;
import com.commons.entity.CollegeProfessionMapper;

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

			String SQL3 = "insert into professor(professor_name) values (?)";
			jdbcTemplateObject.update(SQL3, professorName);

			String SQL4 = "select max(id) from professor";
			Number number1 = jdbcTemplateObject.queryForObject(SQL4, null, Integer.class);

			String SQL5 = "insert into college_profession values(?,?);";
			jdbcTemplateObject.update(SQL5, number, number1);

			System.out.println("Created data Sucessfully");

		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}

	}

	@Override
	public List<CollegeProfession> listCollegeProfessor() {

		String SQL = "select college.college_name,professor.professor_name  from college, professor,college_profession where college.id=college_profession.college_id and professor.id=professor_id;";
		List<CollegeProfession> collegeProfessions = jdbcTemplateObject.query(SQL, new CollegeProfessionMapper());

		return collegeProfessions;

	}

	@Override
	public void updateCollegeName(String collegeName, int collegeId) {
		String SQL = "\r\n"
				+ "		update college, professor,college_profession set college.college_name=? where college.id=college_profession.college_id and professor.id=professor_id and college.id=?"
				+ "";

		jdbcTemplateObject.update(SQL, collegeName, collegeId);
		System.out.println("Updated Record with ID = " + collegeId);
		return;

	}

	@Override
	public List<CollegeProfession> getProfessor(int id) {

		String SQL = "\r\n"
				+ "		select college.college_name,professor.professor_name  from college, professor,college_profession where college.id=college_profession.college_id and professor.id=professor_id and professor.id=?"
				+ "";
		List<CollegeProfession> collegeProfessions = jdbcTemplateObject.query(SQL, new Object[] { id },
				new CollegeProfessionMapper());

		return collegeProfessions;

	}

	@Override
	public List<CollegeProfession> getCollege(int id) {

		String SQL = "\r\n"
				+ "select college.college_name,professor.professor_name  from college, professor,college_profession where college.id=college_profession.college_id and professor.id=professor_id and college.id=?"
				+ "\r\n" + "		";
		List<CollegeProfession> collegeProfessions = jdbcTemplateObject.query(SQL, new Object[] { id },
				new CollegeProfessionMapper());

		return collegeProfessions;
	}

	@Override
	public void delete(Integer id) {

		String SQL1 = "delete from college_profession where professor_id=?";
		String SQL2 = "delete from professor where id=?";

	
		jdbcTemplateObject.update(SQL1, id);
		jdbcTemplateObject.update(SQL2, id);
		System.out.println("Deleted Record with ID = " + id);
		return;

	}

}