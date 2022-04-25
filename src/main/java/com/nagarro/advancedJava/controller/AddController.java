package com.nagarro.advancedJava.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.nagarro.advancedJava.domain.BookDetails;

@Controller
public class AddController {
	
	@PostMapping("/addbook")
	public String addBook()
	{	
		return "AddBook";
	}
	
	@PostMapping("/books")
	public String create( BookDetails bookDetails)
	{	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookDetails> requestEntity = new HttpEntity<>(bookDetails, headers);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/books";
		ResponseEntity<BookDetails> responseEntity = restTemplate.postForEntity(url, requestEntity, BookDetails.class);
	
		return"BookDetails";
	}

}
