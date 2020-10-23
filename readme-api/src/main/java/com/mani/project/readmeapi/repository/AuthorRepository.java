package com.mani.project.readmeapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mani.project.readmeapi.app.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
	List<Author> findAll();
}
