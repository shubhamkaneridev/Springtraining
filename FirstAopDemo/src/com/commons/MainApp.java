package com.commons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	 public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      
	      Student student = (Student) context.getBean("student");
	      
	      System.out.println( student.getName());
	     System.out.println(  student.getAge());
	    
	      try {
	    	  student.printThrowException();
	      }catch (Exception e) {
		}
	     
	   }
}