package com.commons.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CollegeProfessionMapper implements RowMapper<CollegeProfession> {
	   public CollegeProfession mapRow(ResultSet rs, int rowNum) throws SQLException {
		   
		   
		   CollegeProfession collegeProfession= new CollegeProfession();
		   College college= new College();
		   Professor professor= new Professor();
		   
		   
		   college.setCollegeName(rs.getString("college_name"));
		   professor.setProfessoreName(rs.getString("professor_name"));
		   collegeProfession.setCollege(college);
		   collegeProfession.setProfessor(professor);
		   
	

	      return collegeProfession;
	   }
	}