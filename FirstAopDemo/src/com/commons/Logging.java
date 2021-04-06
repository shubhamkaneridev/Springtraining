package com.commons;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logging {
	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	public void beforeAdvice() {
		System.out.println("Going to setup student profile.");
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	public void afterReturningAdvice(Object retVal) {
		if (retVal !=null) {
			System.out.println(" returning :"+retVal.toString());
		}
	}

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised.
	 */
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}

	
	 public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable{
	      System.out.println("Around advice");
	      Object[] args = jp.getArgs();
	      if(args.length>0){
	         System.out.print("Arguments passed: " );
	         for (int i = 0; i < args.length; i++) {
	            System.out.print("arg "+(i+1)+": "+args[i]);
	         }
	      }

	      Object result = jp.proceed(args);
	      System.out.println("Returning " + result);
	      return result;
	   }   
	

}