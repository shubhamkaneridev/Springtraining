package com.training.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.jdbcTemplate.StudentJDBCTemplate;
import com.training.pojo.ExamTemplate;
import com.training.pojo.Student;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		System.out.println(" inserting data into DataBase");
		
		  studentJDBCTemplate.create("Php", "saurabh", 25);
		  studentJDBCTemplate.create("Php", "saurabh", 25);
		  studentJDBCTemplate.create("Php", "saurabh", 25);
		  studentJDBCTemplate.create("Php", "saurabh", 25);
		 

		System.out.println(" All students  and their exam from database");

		List<ExamTemplate> student = studentJDBCTemplate.listStudents();

		for (ExamTemplate examTemplate : student) {

			System.out.println(examTemplate.getStudent().getName() + " " + examTemplate.getStudent().getAge() + " "
					+ examTemplate.getExam().getExamName());

		}

		System.out.println(" All students  and their exam from through id");

		ExamTemplate student2 = studentJDBCTemplate.getStudent(4);

		System.out.println(student2.getStudent().getName() + " " + student2.getStudent().getAge() + " "
				+ student2.getExam().getExamName());

		System.out.println(" updating student and exam database");

		studentJDBCTemplate.update("jhon", 25, "HSC", 2);

		System.out.println(" deleting student and exam database");

		studentJDBCTemplate.delete(2);

		
		
		
		
		
		
		
	}
}