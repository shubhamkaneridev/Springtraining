package com.training.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.jdbcTemplate.StudentJDBCTemplate;
import com.training.pojo.Car;
import com.training.pojo.Store;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		System.out.println(
				"***********************************************************************************************************");

		System.out.println("need to read by company all details with car model and store");

		System.out.println(
				"***********************************************************************************************************");
		List<Store> student = studentJDBCTemplate.listStudents();
		System.out.println("COMPANY_NAME  |   MODEL_NAME |  OWNER_NAME   | city_name  | country_name |Stored_id");
		for (Store store : student) {

			System.out.println(store.getCompany().getCompanyName() + "       |     " + store.getCar().getModelName()
					+ "  |    " + store.getCompany().getOwnerName() + "  |   " + store.getCity().getCityName()
					+ "   |   " + store.getCountry().getCountryName() + "    | " + store.getId());
		}

		System.out.println(
				"***********************************************************************************************************");
		System.out.println(" need to read by car model base on its company id");

		System.out.println(
				"***********************************************************************************************************");
		List<Car> car = studentJDBCTemplate.getCarModel(1);
		for (Car car2 : car) {
			System.out.println(" |" + car2.getModelName() + " |");
		}

		/*  */

		System.out.println(
				"***********************************************************************************************************");
		System.out.println(" need to read by store base on company id....");

		System.out.println(
				"***********************************************************************************************************");
		List<Store> store = studentJDBCTemplate.getStoreBaseInfo(1);
		for (Store store2 : store) {

			System.out.println(store2.getCity().getCityName() + " " + store2.getCountry().getCountryName() + " "
					+ store2.getId() + " " + store2.getCompany().getCompanyName());
		}

		

	}
}