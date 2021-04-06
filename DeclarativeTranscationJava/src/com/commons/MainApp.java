package com.commons;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.dao.StudentDAO;
import com.commons.dao.StudentJDBCTemplate;
import com.commons.entity.StudentMarks;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		StudentDAO studentJDBCTemplate = (StudentDAO) context.getBean("studentJDBCTemplate");

		
		  System.out.println("------Records creation--------");
		  studentJDBCTemplate.create("Zara", 11, 99, 2002);
		  studentJDBCTemplate.create("Nuha", 20, 97, 2020);
		  studentJDBCTemplate.create("Ayan", 25, 100, 2021);
		 
		/*
		 * System.out.println("------Listing all the records--------");
		 * List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		 * 
		 * for (StudentMarks record : studentMarks) { System.out.print("ID : " +
		 * record.getId()); System.out.print(", Name : " + record.getName());
		 * System.out.print(", Marks : " + record.getMarks());
		 * System.out.print(", Year : " + record.getYear());
		 * System.out.println(", Age : " + record.getAge()); }
		 * 
		 * 
		 * System.out.println("------Update records  with id--------");
		 * 
		 * studentJDBCTemplate.update(15, "saurabh", 88, 2020, 23);
		 * 
		 * System.out.println("------delete records  with id--------");
		 * studentJDBCTemplate.delete(14);
		 * 
		 * 
		 * 
		 * 
		 * StudentMarks student = studentJDBCTemplate.getStudent(10);
		 * 
		 * System.out.println(student.getName() + " " + student.getAge() + "  " +
		 * student.getMarks() + " " + student.getYear());
		 */
	}
}