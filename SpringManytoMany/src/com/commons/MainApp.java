package com.commons;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.dao.CollegeProfessionDAO;
import com.commons.entity.CollegeProfession;


public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		CollegeProfessionDAO collegeProfessionDAO = (CollegeProfessionDAO) context.getBean("studentJDBCTemplate");

		/*
		 * System.out.println("------Records creation--------");
		 * collegeProfessionDAO.create("MMIT", "Rathod");
		 */

		
		  System.out.println("------Listing all the records--------");
		  
		  List<CollegeProfession> collegeProfessor = collegeProfessionDAO.listCollegeProfessor();
		 
		  
		  for (CollegeProfession collegeProfession : collegeProfessor) {
			
			  System.out.println(collegeProfession.getCollege().getCollegeName()+"======= "+collegeProfession.getProfessor().getProfessoreName());
		}
		  
		  
		  System.out.println("------College information--------");
		  
		  List<CollegeProfession> collegeProfessor2 = collegeProfessionDAO.getCollege(3);
		  
		
		  for (CollegeProfession collegeProfession : collegeProfessor2) {
			
			  System.out.println(collegeProfession.getCollege().getCollegeName()+"======= "+collegeProfession.getProfessor().getProfessoreName());
			}
		  
		  
		  
		  
		  
		  System.out.println("------professor information--------");
		  
		  List<CollegeProfession> collegeProfessor3 = collegeProfessionDAO.getProfessor(3);
		  
		
		  for (CollegeProfession collegeProfession : collegeProfessor3) {
			
			  System.out.println(collegeProfession.getCollege().getCollegeName()+"======= "+collegeProfession.getProfessor().getProfessoreName());
			}
		  
		  
		  
		  
		  
		  System.out.println("------update information--------");
		  
		  collegeProfessionDAO.updateCollegeName("Dayanand", 6);
		  
		  
		  
		  
		  System.out.println("------deleting information--------");
		  
		  collegeProfessionDAO.delete(7);;
		  
		  
		  
		  
		  
		  
		  
	}
}