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

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter @Setter
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int id;

	@Column(name = "title")
	@NotNull
	public String title;
	
	@OneToOne
	@JoinColumn(name = "author", referencedColumnName = "id")
	@NotNull
	public Author author;
	
	@Column(name = "price")
	@NotNull
	public int price;
	
	@Column(name = "year")
	@NotNull
	public String year;
	
	@Column(name = "rating")
	@NotNull
	public float rating;
	
	@Column(name = "url")
	@NotNull
	public String url;
	
	@Column(name = "description")
	@NotNull
	public String description;
}
