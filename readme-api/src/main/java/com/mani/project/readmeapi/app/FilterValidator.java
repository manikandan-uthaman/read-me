package com.mani.project.readmeapi.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		List<String> errorMessages = new ArrayList<String>();
    	if(filterBy != null && searchString == null) {
			log.error("Search string is empty");
			errorMessages.add("Search string cannot be null");
		} else if (FilterCriteria.AUTHOR.equals(filterBy) && !searchString.matches("\\d+")) {
			log.error("Author id should be integer");
			errorMessages.add("Author id should be integer");
		}
    	if(bookSearchRequest.getPageNumber() < 0) {
    		errorMessages.add("Page number cannot be negative");
    	}
    	if(bookSearchRequest.getRecordsPerPage() < 0) {
    		errorMessages.add("Records per page cannot be negative");    		
    	}
    	
    	if(errorMessages.size() > 0) {
    		throw new IllegalArgumentException(errorMessages.stream().collect(Collectors.joining("|")));
    	}
		
    	return true;
    }
}
