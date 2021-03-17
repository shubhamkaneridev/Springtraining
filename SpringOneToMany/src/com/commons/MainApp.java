package com.commons;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.dao.CollegeProfessionDAO;
import com.commons.entity.Professor;



public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		CollegeProfessionDAO collegeProfessionDAO = (CollegeProfessionDAO) context.getBean("studentJDBCTemplate");

		
		/*
		 * System.out.println("------Records creation--------");
		 * collegeProfessionDAO.create("VIT", "SHINDE");
		 */

		
		
		  System.out.println("------Listing all the records--------");
		  
		  List<Professor> collegeProfessor =
		  collegeProfessionDAO.listCollegeProfessor();
		  for (Professor professor : collegeProfessor) {
			 System.out.println(professor.getProfessoreName()+"======="+professor.getCollege().getCollegeName());
		}
		  
		  
		  
		  
		  
		 
		  
		
		  
		  
		
		  System.out.println("------professor information--------");
		  
		  List<Professor> collegeProfessor3 =
		  collegeProfessionDAO.getProfessor(1);
		  
		for (Professor professor : collegeProfessor3) {
			
			 System.out.println(professor.getProfessoreName()+"======="+professor.getCollege().getCollegeName());
		}
		  
		  
		
		/*
		 * System.out.println("------update information--------");
		 * 
		 * collegeProfessionDAO.updateProfessor("RSML", 6);
		 */
		/*
		*/
		/*
		 * System.out.println("------deleting information--------");
		 * 
		 * collegeProfessionDAO.delete(7);;
		 * 
		 */
		 
		  
		  
		  
		  
	}
}