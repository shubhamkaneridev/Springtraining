package com.training.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.jdbcTemplate.ExamJDBCTemplate;
import com.training.pojo.Exam;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		ExamJDBCTemplate examJDBCTemplate = (ExamJDBCTemplate) context.getBean("examJDBCTemplate");

		System.out.println("------Records Creation--------");
		examJDBCTemplate.create("2021-12-12", true, "shubham");

		System.out.println("------Listing Multiple Records--------");
		List<Exam> exam = examJDBCTemplate.listExam();

		for (Exam record : exam) {
			System.out.print("ID : " + record.getId());
			System.out.print(", StudentName : " + record.getStudentName());
			System.out.println(", Date : " + record.getDate());
			System.out.println(", attendence : " + record.isAttendence());

		}
		System.out.println("----Listing Record with ID = 2 -----");
		Exam record = examJDBCTemplate.getExam(2);
		System.out.print("ID : " + record.getId());
		System.out.print(", StudentName : " + record.getStudentName());
		System.out.println(", Date : " + record.getDate());
		System.out.println(", attendence : " + record.isAttendence());

		System.out.println("----Updating Record with id=2");

		examJDBCTemplate.update(4, "saurabh");

		System.out.println("----delting Record with id=1");

		examJDBCTemplate.delete(5);
		

		System.out.println("------Listing Multiple Records--------");
		List<Exam> exam1 = examJDBCTemplate.listExam();

		for (Exam record1 : exam1) {
			System.out.print("ID : " + record1.getId());
			System.out.print(", StudentName : " + record1.getStudentName());
			System.out.println(", Date : " + record1.getDate());
			System.out.println(", attendence : " + record1.isAttendence());

		}

	}
}