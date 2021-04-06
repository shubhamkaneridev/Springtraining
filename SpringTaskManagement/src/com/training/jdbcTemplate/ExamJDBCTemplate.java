package com.training.jdbcTemplate;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.training.dao.TaskDAO;

import com.training.mapper.UsersMapper;

import com.training.pojo.Users;


public class ExamJDBCTemplate implements TaskDAO {

	
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplateObject = jdbcTemplate;
	}

	@Override
	public List<Users> listUser() {
		String SQL = "select  users.USERS_NAME, users.AGE, activity_type.ACTIVITY_TYPE, task.TASK_NAME, task.TASK_DATE_TIME, task.TASK_DESCRIPTION, task_location.LOCATION_NAME,task_status.TASK_STATUS from\r\n"
				+ "activity_type,task,task_location,task_status,users\r\n" + "where task.id=users.task_id \r\n"
				+ "and task_status.id=users.task_status_id\r\n" + "and activity_type.id=users.ACTIVITY_TYPE_ID\r\n"
				+ "and task_location.id=users.TASK_LOCATION_ID;";

		List<Users> users = jdbcTemplateObject.query(SQL, new UsersMapper());
		return users;
	}

	@Override
	public void updateTask(Integer id, String userName, String taskName, Timestamp date, String description, int age,
			String activitytype, String locationName, String status) {

		String Sql = "update task,users,activity_type,task_location,task_status set task.task_name=?,task.TASK_DATE_TIME=?,task.TASK_DESCRIPTION=?,\r\n"
				+ "users.users_Name=?,users.age=? ,users.ACTIVITY_TYPE_ID=(select id from ACTIVITY_TYPE where ACTIVITY_TYPE=?),\r\n"
				+ "users.TASK_LOCATION_ID=(select id from task_location where LOCATION_NAME=?),\r\n"
				+ "users.TASK_STATUS_ID=(select id from task_status where TASK_STATUS=?)\r\n"
				+ "where task.id=users.task_id \r\n" + "and task_status.id=users.task_status_id\r\n"
				+ "and activity_type.id=users.ACTIVITY_TYPE_ID\r\n"
				+ "and task_location.id=users.TASK_LOCATION_ID and users.id=?;";
		jdbcTemplateObject.update(Sql, taskName, date, description, userName, age, activitytype, locationName, status,
				id);
	}

	@Override
	public List<Users> listUser(String activityType) {
		String SQL = "select  users.USERS_NAME, users.AGE, activity_type.ACTIVITY_TYPE, task.TASK_NAME, task.TASK_DATE_TIME, task.TASK_DESCRIPTION, task_location.LOCATION_NAME,task_status.TASK_STATUS from\r\n"
				+ "activity_type,task,task_location,task_status,users\r\n" + "where task.id=users.task_id \r\n"
				+ "and task_status.id=users.task_status_id\r\n" + "and activity_type.id=users.ACTIVITY_TYPE_ID\r\n"
				+ "and task_location.id=users.TASK_LOCATION_ID    and activity_type.activity_type=?";
		List<Users> users = jdbcTemplateObject.query(SQL, new Object[] { activityType }, new UsersMapper());
		return users;
	}

	@Override
	public void delete(Integer id) {
		String SQL1 = "	delete from users where id=?";

		String SQL2 = "	delete from task where id=?";

		jdbcTemplateObject.update(SQL1, id);

		jdbcTemplateObject.update(SQL2, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	@Override
	public void createTask(String taskName, Timestamp date_time, String taskDescription, String userName, int age,
			String activitytype, String locationName, String status) {

		String SQL1 = "INSERT INTO task (task_name,task_date_time,task_description) values (?,?,?);";

		jdbcTemplateObject.update(SQL1, taskName, date_time, taskDescription);

		String SQL2 = "select max(id) from task";
		Number number = jdbcTemplateObject.queryForObject(SQL2, null, Integer.class);

		String SQL3 = "INSERT INTO users ( USERS_NAME, AGE, TASK_LOCATION_ID, ACTIVITY_TYPE_ID, TASK_STATUS_ID, TASK_ID) values (?,?,(select id from task_location where LOCATION_NAME=?),(select id from ACTIVITY_TYPE where ACTIVITY_TYPE=?), (select id from task_status where TASK_STATUS=?),?);";

		jdbcTemplateObject.update(SQL3, userName, age, locationName, activitytype, status, number.intValue());
		System.out.println("Created Data Sucessfully");

	}

}