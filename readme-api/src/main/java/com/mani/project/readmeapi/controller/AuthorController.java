package com.mani.project.readmeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mani.project.readmeapi.app.Author;
import com.mani.project.readmeapi.service.impl.AuthorServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/authors")
@Api(value = "/authors")
@Slf4j
public class AuthorController {

	@Autowired
	private AuthorServiceImpl authorService;
	
	@GetMapping("/")
	@ApiOperation(value = "Get list of all authors")
	public List<Author> getAllBooks() {
		log.info("Get list of all authors");
		return authorService.getAllAuthors();
	} 
}
