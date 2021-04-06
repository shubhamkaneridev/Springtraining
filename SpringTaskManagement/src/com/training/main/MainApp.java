package com.training.main;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.TaskDAO;


import com.training.pojo.Users;

public class MainApp {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringJDBCConfiguration.class);

		
		
		
		TaskDAO examJDBCTemplate = applicationContext.getBean(TaskDAO.class);
		/*
		 * Timestamp dateTime = new Timestamp(System.currentTimeMillis());
		 * 
		 * examJDBCTemplate.createTask("Tv Reparing", dateTime, "TV CRT", "Sanket", 23,
		 * "Electronic", "Latur", "Scheduled");
		 */
		

		System.out.println("------Listing Multiple Records--------");
		List<Users> users = examJDBCTemplate.listUser();
		for (Users users2 : users) {

			System.out.println(users2.getUserName() + " " + users2.getAge() + " "
					+ users2.getActivityType().getActivityType() + " " + users2.getTask().getTaskName() + ""
					+ users2.getTask().getDateTime() + " " + users2.getTaskLocation().getLocationName() + " "
					+ users2.getTaskStatus().getTaskStatus());
		}

		
		
		/*
		 * Timestamp str = new Timestamp(System.currentTimeMillis());
		 * 
		 * examJDBCTemplate.updateTask(5, "jhon", "TvReparing", str, "mobile", 30,
		 * "Electronic", "Latur", "In Progress");
		 */
		 // examJDBCTemplate.delete(2);
		 

		
		
	}
}