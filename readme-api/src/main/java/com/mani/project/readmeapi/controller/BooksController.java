package com.mani.project.readmeapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

	@GetMapping("/")
	public List<String> getAllBooks() {
		return new ArrayList<String>();
	} 
}
