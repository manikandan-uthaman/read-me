package com.mani.project.readmeapi.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter @Setter
@ValidateBookObject
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int id;

	@Column(name = "title")
	@NotNull(message = "Title cannot be empty")
	public String title;
	
	@OneToOne
	@JoinColumn(name = "author", referencedColumnName = "id")
	@NotNull(message = "Author of a book is mandatory")
	public Author author;
	
	@Column(name = "price")
	@NotNull(message = "Price field cannot be null")
	public int price;
	
	@Column(name = "year")
	@NotNull(message = "Year field cannot be null")
	public String year;
	
	@Column(name = "rating")
	@NotNull(message = "Rating field cannot be null")
	public float rating;
	
	@Column(name = "url")
	public String url;
	
	@Column(name = "description")
	@NotNull(message = "Description cannot be empty")
	public String description;
}
