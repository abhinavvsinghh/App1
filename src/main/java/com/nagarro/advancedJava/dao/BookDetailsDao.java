package com.nagarro.advancedJava.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.advancedJava.domain.BookDetails;

public class BookDetailsDao {
	
	private List<BookDetails> books = new ArrayList<BookDetails>();
	
	public void display() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/books";
		ResponseEntity<BookDetails[]> responseEntity = restTemplate.getForEntity(url, BookDetails[].class);
		BookDetails[] book = responseEntity.getBody();
		books = Arrays.asList(book);
	}
	
	public List<BookDetails> getBooks() {
		return books;
	}

	public void setBooks(List<BookDetails> books) {
		this.books = books;
	}
}
