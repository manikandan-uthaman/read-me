package com.mani.project.readmeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mani.project.readmeapi.app.Author;
import com.mani.project.readmeapi.service.AuthorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/authors")
@Api(value = "/authors")
@Slf4j
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/")
	@ApiOperation(value = "Get list of all authors")
	public List<Author> getAllBooks() {
		log.info("Get list of all authors");
		return authorService.getAllAuthors();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a author entry")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Author deleted successfully"),
			@ApiResponse(code = 500, message = "Unexpected exception")
	})
	public void getAllBooks(@ApiParam(name = "authorId", value = "Id of the author") @PathVariable("id") int id) {
		log.info("Get list of all authors");
		authorService.deleteAuthor(id);
	}
}
