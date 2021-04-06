package com.training.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.training.pojo.Users;

public interface TaskDAO {

	

	public List<Users> listUser();

	public List<Users> listUser(String activityType);

	public void updateTask(Integer id, String userName, String taskName, Timestamp date, String description, int age,
			String activitytype, String locationName, String status);

	public void delete(Integer id);
	
	public void createTask(String taskName,Timestamp date_time,String taskDescription,String userName,   int age,
			String activitytype, String locationName, String status);



}