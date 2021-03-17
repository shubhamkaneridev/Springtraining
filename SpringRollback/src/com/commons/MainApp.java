package com.commons;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.commons.dao.StreetDAO;
import com.commons.entity.Pincode;

public class MainApp {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringJDBCConfiguration.class);

		StreetDAO studentJDBCTemplate = applicationContext.getBean(StreetDAO.class);

		System.out.println("------Records creation--------");
		// studentJDBCTemplate.create("xyz", "street22", 413531);

		System.out.println("------Listing all the records--------");
		List<Pincode> street = studentJDBCTemplate.listhouses();
		for (Pincode pincode : street) {
			System.out.println(
					pincode.getStreet().getStreetName() + " " + pincode.getHouse().getName() + " " + pincode.getCode());
		}
		
		  
		  System.out.println("------Update records  with id--------");
		  
		  studentJDBCTemplate.update(4, "shubham Nivas", "GaneshStreet");;
		 

		
		  System.out.println("------delete records  with id--------");
		  studentJDBCTemplate.delete(4);
		 

		
		applicationContext.close();
	}
}