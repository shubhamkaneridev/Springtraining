package com.customerserviceimplements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.customerservice.CustomerService;
import com.exceptionclasses.InvalidDataException;
import com.exceptionclasses.NoRecordFoundException;
import com.modelclasses.AddressModel;
import com.modelclasses.CustomerModel;
import com.utilclass.ValidationUtils;

public class CustomerServiceImpl implements CustomerService {

	List<CustomerModel> customerList = new ArrayList<CustomerModel>();

	Scanner scanner = new Scanner(System.in);

	@Override
	public void add() {

		try {

			System.out.println(" Enter your id");

			int id = scanner.nextInt();

			System.out.println(" Enter your FirstName");
			String firstName = scanner.next();
			System.out.println(" Enter your LastName");
			String lastName = scanner.next();

			System.out.println(" Enter your Email");
			String email = scanner.next();

			ValidationUtils.validateEmail(email);
			System.out.println(" Enter your MobileNo");
			String mobileNo = scanner.next();
			System.out.println(" Enter your AddressLine1");
			String addressLine1 = scanner.next();
			System.out.println(" Enter your AddressLine2");
			String addressLine2 = scanner.next();
			System.out.println(" Enter your  city");
			String city = scanner.next();
			System.out.println(" Enter your state");
			String state = scanner.next();
			System.out.println(" Enter your country");
			String country = scanner.next();

			customerList.add(new CustomerModel(id, firstName, lastName, email, mobileNo,
					new AddressModel(addressLine1, addressLine2, city, state, country)));
		}

		catch (InvalidDataException e) {
			System.out.println(e.getMessage());
		}

		catch (InputMismatchException e) {
			System.out.println(" plese enter valid data  and try again ");
		}

	}

	@Override
	public void edit() {

		try {
			if (customerList.isEmpty()) {
				throw new NoRecordFoundException("Customer list is Not Avaliable");
			}
		} catch (NoRecordFoundException e) {
			System.out.println(e.getMessage());
			return;
		}

		try {
			System.out.println(" enter customer id");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String temp = null;
			try {
				temp = bufferedReader.readLine();
			} catch (IOException e) {

				e.printStackTrace();
			}
			int flag=0;
			int customerId = Integer.parseInt(temp);
			for (CustomerModel customerModel : customerList) {

				if (customerModel.getId() == customerId)
				{

					System.out.println(customerModel.getId() + " " + customerModel.getFirstName() + " "
							+ customerModel.getMobileNo());

					System.out.println(
							"you can update \n 1. mobile No \n 2.email id \n 3.First Name \n 4.Last name \n5. addresssLine1");

					String data = scanner.next();
					getOptionForUpdate(customerModel, data);
					flag=1;
					break;

				}

			}
			if (flag==1) {
				return;
			} 

			else {

				throw new NoRecordFoundException("No Data Found");
			}

		} catch (NoRecordFoundException ex) {

			System.out.println(ex.getMessage());
		} catch (InvalidDataException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println(" plese enter valid data  and try again ");
		}

	}

	private void getOptionForUpdate(CustomerModel customerModel, String data) {
		if (data.equals("1")) {

			System.out.println(" please enter your mobile no");
			String mobileNo = scanner.next();

			customerModel.setMobileNo(mobileNo);
			System.out.println("  mobileNo updated sucessfully");

		}

		if (data.equals("2")) {

			System.out.println(" please enter your emailId");
			String emailId = scanner.next();

			customerModel.setEmail(emailId);
			System.out.println("  emilid updated sucessfully");
		}
		if (data.equals("3")) {

			System.out.println(" please enter your first Name");
			String firstName = scanner.next();

			customerModel.setFirstName(firstName);
			System.out.println(" first name updated sucessfully");
		}
		if (data.equals("4")) {

			System.out.println(" please enter your last Name");
			String lastName = scanner.next();

			customerModel.setLastName(lastName);
			System.out.println(" last name updated sucessfully");
		}

		if (data.equals("5")) {

			System.out.println(" please enter your AddressLine1");
			String addressLine1 = scanner.next();

			customerModel.getAddress().setAddressLine1(addressLine1);
			System.out.println(" AddressLine1 updated sucessfully");
		}
	}

	@Override
	public void list() {

		try {
			if (customerList.isEmpty()) {
				throw new NoRecordFoundException("Customer list is Not Avaliable please try again");
			}
		} catch (NoRecordFoundException e) {
			System.out.println(e.getMessage());
			return;
		}

		customerList.forEach(customerData -> System.out
				.println(customerData.getId() + " " + customerData.getFirstName() + " " + customerData.getMobileNo()
				+ " " + customerData.getEmail() + " " + customerData.getAddress().getAddressLine1()));

	}

	@Override
	public void searcch() {

		try {
			if (customerList.isEmpty()) {
				throw new NoRecordFoundException("Customer list is Not Avaliable please try again");
			}
		} catch (NoRecordFoundException e) {
			System.out.println(e.getMessage());
			return;
		}

		int flag = 0;
		try {
			System.out.println(" enter name");
			String customerName = scanner.next();

			for (CustomerModel customerModel : customerList) {

				if (customerModel.getFirstName().contains(customerName)) {

					System.out.println(customerModel.getId() + " " + customerModel.getFirstName() + " "
							+ customerModel.getMobileNo());
					flag = 1;

				}

			}

			if (flag == 1) {
				return;
			} else {

				throw new NoRecordFoundException("No Data Found");
			}

		} catch (NoRecordFoundException e) {

			System.out.println(e.getMessage());
		}

	}

}
