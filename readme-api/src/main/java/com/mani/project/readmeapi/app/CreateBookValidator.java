package com.mani.project.readmeapi.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateBookValidator implements ConstraintValidator<ValidateBookObject, Book> {

	@Override
	public boolean isValid(Book book, ConstraintValidatorContext context) {
		if(book.getAuthor() == null || (book.getAuthor().getId() == 0 && book.getAuthor().getName() == null)) {
			return false;
		}
		return true;
	}

}
