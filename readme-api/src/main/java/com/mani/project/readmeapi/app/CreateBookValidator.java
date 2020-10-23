package com.mani.project.readmeapi.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateBookValidator implements ConstraintValidator<ValidateBookObject, Book> {

	@Override
	public boolean isValid(Book value, ConstraintValidatorContext context) {
		
		return true;
	}

}
