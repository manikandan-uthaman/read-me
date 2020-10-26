package com.mani.project.readmeapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mani.project.readmeapi.app.Book;
import com.mani.project.readmeapi.app.BookBasicInfo;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	List<Book> findAll();
	Page<BookBasicInfo> findBy(Pageable paging);
	Page<BookBasicInfo> findByAuthorId(int authorId, Pageable paging);
	Page<BookBasicInfo> findByTitleStartsWith(String title, Pageable paging);
}
