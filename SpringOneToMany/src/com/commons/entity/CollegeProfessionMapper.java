package com.commons.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CollegeProfessionMapper implements RowMapper<Professor> {
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {

		College college = new College();
		Professor professor = new Professor();

		college.setCollegeName(rs.getString("college_name"));
		professor.setProfessoreName(rs.getString("professor_name"));
		professor.setCollege(college);

		return professor;
	}
}