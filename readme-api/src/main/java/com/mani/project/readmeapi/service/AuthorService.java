package com.mani.project.readmeapi.service;

import java.util.List;

import com.mani.project.readmeapi.app.Author;

public interface AuthorService {
	
	public List<Author> getAllAuthors();
	public Author addAuthor(Author author);
}
