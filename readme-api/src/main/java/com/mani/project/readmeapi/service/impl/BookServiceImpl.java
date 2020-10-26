package com.mani.project.readmeapi.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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

	@Autowired
	private Cloudinary cloudinaryService;

	private static final String PATH_DELIMITER = "/";

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
	
	@SuppressWarnings("rawtypes")
	@Override
	public int addBook(MultipartFile file, Book book) throws Exception {
		Map uploadResult = null;
		if(file != null) {
			File convFile = new File(System.getProperty("java.io.tmpdir") + PATH_DELIMITER + file.getOriginalFilename());
			try {
				file.transferTo(convFile);
				uploadResult = cloudinaryService.uploader().upload(convFile,
				        ObjectUtils.asMap("resource_type", "auto"));
			} catch (IllegalStateException | IOException e) {
				log.error("File upload failed");
				throw e;
			}
		}

		if(uploadResult != null) {
			book.setUrl((String) uploadResult.get("url"));
		}

		Book b = bookRepository.save(book);
		return b.getId();
	}
}
