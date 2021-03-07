package com.controller;

import java.util.Scanner;

import com.customerserviceimplements.CustomerServiceImpl;
import com.utilclass.ValidationUtils;

public class CustomerManagement {

	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);
		

		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

		do {

			System.out.println("   1.add \n 2.edit\n 3.list\n 4.search \n5.exit");
			String choice = scanner.nextLine();
			
			 ValidationUtils.validateChoice(choice);
			
			switch (choice)
			{
			case "1":
				customerServiceImpl.add();
				break;
			case "2":
				customerServiceImpl.edit();
				;
				break;
			case "3":
				customerServiceImpl.list();
				break;
			case "4":
				customerServiceImpl.searcch();
				break;

			case "5":
				
				System.exit(0);
				break;
				
				
			}

		} while (true);

	}

}
