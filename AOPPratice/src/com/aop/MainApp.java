package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.aop.entity.Employee;
import com.aop.entity.MYException;
import com.aop.entity.Student;

public class MainApp {

	public static void main(String[] args) throws MYException {

		AbstractApplicationContext abstractApplicationContext = new AnnotationConfigApplicationContext(Config.class);

		Student student = abstractApplicationContext.getBean("student", Student.class);
//Joint
		/*
		 * student.studyAnything(5,5); student.doOperationSomething();
		 */
		
		student.rankOfVideo(100, 65);

		Employee employee = abstractApplicationContext.getBean("employee", Employee.class);
		// Join
		//employee.studySomething();

	}

}
