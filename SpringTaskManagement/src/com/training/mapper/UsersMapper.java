package com.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import com.training.pojo.ActivityType;
import com.training.pojo.Task;
import com.training.pojo.TaskLocation;
import com.training.pojo.TaskStatus;
import com.training.pojo.Users;

public class UsersMapper implements RowMapper<Users> {

	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

		Users users = new Users();
		TaskLocation taskLocation = new TaskLocation();
		ActivityType activityType = new ActivityType();
		TaskStatus taskStatus = new TaskStatus();
		Task task = new Task();

		activityType.setActivityType(rs.getString("ACTIVITY_TYPE"));
		task.setTaskName(rs.getString("TASK_NAME"));

		String temp = rs.getString("TASK_DATE_TIME");
		String[] datetime = temp.split(" ");
		String[] date = datetime[0].split("-");
		String[] time = datetime[1].split(":");

		LocalDateTime localDateTime = LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]),
				Integer.parseInt(date[2]), Integer.parseInt(time[0]), Integer.parseInt(time[1]));

		String str = localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"));
		/* System.out.println(str+"jdfhjdskfdksf"); */

		task.setDateTime(str);
		taskLocation.setLocationName(rs.getString("LOCATION_NAME"));
		taskStatus.setTaskStatus(rs.getString("TASK_STATUS"));
		users.setTaskStatus(taskStatus);
		users.setTaskLocation(taskLocation);
		users.setTask(task);
		users.setActivityType(activityType);
		users.setUserName(rs.getString("USERS_NAME"));
		users.setAge(rs.getInt("AGE"));

		return users;

	}
}