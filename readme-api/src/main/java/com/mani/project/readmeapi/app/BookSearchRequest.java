package com.mani.project.readmeapi.app;

import com.mani.project.readmeapi.constants.FilterCriteria;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ValidateFilter
public class BookSearchRequest {
	
	private FilterCriteria filterBy;
	private String searchString;	
	private int pageNumber;	
	private int recordsPerPage;

}
