package com.mani.project.readmeapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.project.readmeapi.app.Author;
import com.mani.project.readmeapi.repository.AuthorRepository;
import com.mani.project.readmeapi.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAllAuthors() {
		log.info("Get list of all authors");
		return authorRepository.findAll();
	}

	@Override
	public Author addAuthor(Author author) {
		Author newAuthor = authorRepository.save(author);
		log.info("Created new author with id: {}", newAuthor.getId());
		return newAuthor;
	}
}
