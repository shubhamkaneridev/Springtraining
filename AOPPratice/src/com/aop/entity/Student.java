package com.aop.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {

	public int studyAnything(int i, int j) {
		System.out.println(" i am in school and studying right Now !");
		return 800;
	}

	public String doOperationSomething() throws MYException 
	{
		throw new MYException(" this is my exception");
	}

	
	
	
	public int rankOfVideo(int  watchTime, int noOfViews)
	{
		return(noOfViews*watchTime) -(noOfViews+watchTime);
	}
	
	
	
	
	
}
