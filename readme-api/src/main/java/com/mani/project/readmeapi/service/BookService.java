package com.mani.project.readmeapi.service;

import com.mani.project.readmeapi.app.Book;
import com.mani.project.readmeapi.app.BookSearchRequest;
import com.mani.project.readmeapi.app.BookSearchResponse;

public interface BookService {

	public BookSearchResponse searchBooks(BookSearchRequest bookSearchRequest);
	public Book getBookDetails(int bookId);
	public int addBook(Book book);
}
