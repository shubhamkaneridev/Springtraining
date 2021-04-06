package com.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

		Company company = applicationContext.getBean("company", Company.class);
		
		
		company.showInfo();
		company.engineer.development();
		
		
		
		
		
		

	}
}
