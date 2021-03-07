package com.utilclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.exceptionclasses.InvalidChoiceException;
import com.exceptionclasses.InvalidDataException;

public class ValidationUtils {

	public static boolean validateChoice(String input) {

		try {
			int number = Integer.parseInt(input);

			if (number < 6) {

				return true;
			} else {

				throw new InvalidChoiceException(" Invlid choice exception please enter Again");
			}
		}

		catch (InvalidChoiceException e) {

			System.out.println(e.getMessage());

		}

		return true;

	}

	public static boolean validateEmail(String emailId) {

		String emailPattern = "[a-zA-Z0-9][a-zA-Z0-9-.]*@gmail.com";

		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcherEmail = pattern.matcher(emailId);

		try {

			if (matcherEmail.find()) {

			} else {
				throw new InvalidDataException(" email is not valid please try again");

			}
		} catch (InvalidDataException e) {
			System.out.println(e.getMessage());
			System.exit(0);

		}
		return true;

	}
}
