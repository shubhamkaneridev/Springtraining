package com.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Company {

	@Value("${company.name}")
	String companyName;
	
	@Autowired
	@Qualifier("softwareEngineer")
	Engineer engineer;

	public void showInfo() {
		System.out.println(" Hello Details !!!");
		System.out.println("Company Name is "+companyName);
	}

}
