package com.mani.project.readmeapi.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mani.project.readmeapi.app.Author;
import com.mani.project.readmeapi.app.Book;
import com.mani.project.readmeapi.app.BookSearchRequest;
import com.mani.project.readmeapi.app.BookSearchResponse;
import com.mani.project.readmeapi.exception.ResourceNotFoundException;
import com.mani.project.readmeapi.service.AuthorService;
import com.mani.project.readmeapi.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Api(value = "/books")
@Slf4j
public class BooksController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
		
	@PostMapping("/search")
	@ApiOperation(value = "Get list of all books")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Books fetched sucessfully"),
			@ApiResponse(code = 400, message = "Invalid search criteria"),
			@ApiResponse(code = 500, message = "Unexpected exception")
	})
	public BookSearchResponse getBooks(@Validated @RequestBody BookSearchRequest bookSearchRequest, BindingResult bindingResult) {
		if(bindingResult.hasGlobalErrors()) {
			String errorMessage = bindingResult.getAllErrors().stream().map(error -> {
				return error.getDefaultMessage();
			}).collect(Collectors.joining("|"));
			throw new IllegalArgumentException(errorMessage);
		}
		log.info("Get list of all books");
		return bookService.searchBooks(bookSearchRequest);
	}

	
	@GetMapping("/{bookid}")
	@ApiOperation(value = "Get details based on book id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Book details fetched sucessfully"),
			@ApiResponse(code = 404, message = "Requested book was not found"),
			@ApiResponse(code = 500, message = "Unexpected exception")
	})
	public Book getBookDetails(@ApiParam(name = "bookid", value = "Id of the book") @PathVariable("bookid") int bookid) {
		log.info("Get details of a particular book");
		Book book = bookService.getBookDetails(bookid);
		if(book != null) {
			return book;
		} else {
			log.error("Book id not found");
			throw new ResourceNotFoundException("Requested book is not found");
		}
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Add a new book")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "New book entry created sucessfully"),
			@ApiResponse(code = 400, message = "Invalid input"),
			@ApiResponse(code = 500, message = "Unexpected exception")
	})
	public int addBook(@Validated @RequestBody Book book, BindingResult bindingResult) {
		if(bindingResult.getAllErrors().size() > 0) {
			String errorMessage = bindingResult.getAllErrors().stream().map(error -> {
				return error.getDefaultMessage();
			}).collect(Collectors.joining(" | "));
			throw new IllegalArgumentException(errorMessage);
		}
		if(book.getAuthor().getId() == 0) {
			log.debug("Adding new author");
			Author a = authorService.addAuthor(book.getAuthor());
			log.debug("New author created with id {}", a.getId());
			book.setAuthor(a);
		}
		log.debug("Create new book entry");
		return bookService.addBook(book);
	}
}
