package com.mani.project.readmeapi.app;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookSearchResponse {

	List<BookBasicInfo> books;
	Integer pageNumber;
	Long totalNumberOfElements;
	Integer resultsPerPage;

}
