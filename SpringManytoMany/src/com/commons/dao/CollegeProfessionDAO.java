package com.commons.dao;

import java.util.List;

import javax.sql.DataSource;

import com.commons.entity.CollegeProfession;


public interface CollegeProfessionDAO {
	
	public void setDataSource(DataSource ds);

	public void create(String collegeName,String professorName);

	
	public List<CollegeProfession> listCollegeProfessor();

	public void delete(Integer id);

	public void updateCollegeName(String  collegeName,int collegeId);

	public List<CollegeProfession> getProfessor(int id);
	

	public  List<CollegeProfession> getCollege(int id);
	
}