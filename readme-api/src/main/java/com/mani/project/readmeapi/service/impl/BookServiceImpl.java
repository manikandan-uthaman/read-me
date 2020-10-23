package com.mani.project.readmeapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mani.project.readmeapi.app.Book;
import com.mani.project.readmeapi.app.BookBasicInfo;
import com.mani.project.readmeapi.app.BookSearchRequest;
import com.mani.project.readmeapi.app.BookSearchResponse;
import com.mani.project.readmeapi.constants.FilterCriteria;
import com.mani.project.readmeapi.constants.GlobalConstants;
import com.mani.project.readmeapi.repository.BookRepository;
import com.mani.project.readmeapi.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookSearchResponse searchBooks(BookSearchRequest bookSearchRequest) {
		Page<BookBasicInfo> response = null;
		int pageIndex = (bookSearchRequest.getPageNumber()) <= 0? GlobalConstants.DEFAULT_PAGE_INDEX : (bookSearchRequest.getPageNumber() -1);
		int recordsPerPage = (bookSearchRequest.getRecordsPerPage() <= 0) ? GlobalConstants.DEFAULT_RECORDS_PER_PAGE : bookSearchRequest.getRecordsPerPage();
		log.debug("Get books for page index {}", pageIndex);
		
		Pageable paging = PageRequest.of(pageIndex, recordsPerPage); 
		
		if (bookSearchRequest.getFilterBy() == null) {
			log.info("Get books without any filter");
			response = bookRepository.findBy(paging);
		} else if (bookSearchRequest.getFilterBy() == FilterCriteria.AUTHOR) {
			log.info("Get books filtered by author with id: {}", bookSearchRequest.getSearchString());
			response = bookRepository.findByAuthorId(Integer.parseInt(bookSearchRequest.getSearchString()), paging);
		} else if (bookSearchRequest.getFilterBy() == FilterCriteria.TITLE) {
			log.info("Get books filtered by title starting with: {}", bookSearchRequest.getSearchString());
			response = bookRepository.findByTitleStartsWith(bookSearchRequest.getSearchString(), paging);
		}
		
		BookSearchResponse result = new BookSearchResponse();
		result.setBooks(response.getContent());
		result.setPageNumber(response.getNumber()+1);
		result.setResultsPerPage(bookSearchRequest.getRecordsPerPage());
		result.setTotalNumberOfElements(response.getTotalElements());
		return result;
	}
	
	@Override
	public Book getBookDetails(int bookId) {
		log.info("Get details of book with id: {}", bookId);
		Optional<Book> book = bookRepository.findById(bookId);
		return book.orElse(null);
	}
	
	@Override
	public int addBook(Book book) {
		Book b = bookRepository.save(book);
		return b.getId();
	}
}
