package com.mani.project.readmeapi.service;

import org.springframework.web.multipart.MultipartFile;

import com.mani.project.readmeapi.app.Book;
import com.mani.project.readmeapi.app.BookSearchRequest;
import com.mani.project.readmeapi.app.BookSearchResponse;

public interface BookService {

	public BookSearchResponse searchBooks(BookSearchRequest bookSearchRequest);
	public Book getBookDetails(int bookId);
	public int addBook(MultipartFile file, Book book) throws Exception;
}
