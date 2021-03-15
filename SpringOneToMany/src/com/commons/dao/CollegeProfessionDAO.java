package com.commons.dao;

import java.util.List;

import javax.sql.DataSource;
import com.commons.entity.Professor;


public interface CollegeProfessionDAO {
	
	public void setDataSource(DataSource ds);

	public void create(String collegeName,String professorName);

	
	public List<Professor> listCollegeProfessor();

	public void delete(Integer id);

	public void updateProfessor(String  collegeName,int collegeId);

	public List<Professor> getProfessor(int id);
	

	
	
}