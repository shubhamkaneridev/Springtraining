package com.demo.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<Password, String> {

	public boolean isValid(String s, ConstraintValidatorContext cvc) {

		if (s.length() >= 4) {

			return true;
		}
		return false;

	}
}
