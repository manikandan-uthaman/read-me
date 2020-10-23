package com.mani.project.readmeapi.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mani.project.readmeapi.constants.FilterCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilterValidator implements ConstraintValidator<ValidateFilter, BookSearchRequest> {

    @Override
    public boolean isValid(BookSearchRequest bookSearchRequest, ConstraintValidatorContext context) {
    	FilterCriteria filterBy = bookSearchRequest.getFilterBy();
    	String searchString = bookSearchRequest.getSearchString();
		if(filterBy != null && searchString == null) {
			log.error("Search string is empty");
			throw new IllegalArgumentException("Search string cannot be null");
//			return false;
		} else if (FilterCriteria.AUTHOR.equals(filterBy) && !searchString.matches("\\d+")) {
			log.error("Author id should be integer");
			throw new IllegalArgumentException("Author id should be integer");
//			return false;
		}
    	return true;
    }
}
