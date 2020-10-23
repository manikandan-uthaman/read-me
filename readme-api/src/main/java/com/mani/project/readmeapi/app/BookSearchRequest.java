package com.mani.project.readmeapi.app;

import javax.validation.constraints.Min;

import com.mani.project.readmeapi.constants.FilterCriteria;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ValidateFilter
public class BookSearchRequest {
	
	private FilterCriteria filterBy;
	private String searchString;
	
	@Min(value = 0, message = "Page number cannot be negative")
	private int pageNumber;
	
	@Min(value = 0, message = "Records per page cannot be negative")
	private int recordsPerPage;

}
