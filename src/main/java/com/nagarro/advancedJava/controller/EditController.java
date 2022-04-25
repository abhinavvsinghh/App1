package com.nagarro.advancedJava.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advancedJava.domain.BookDetails;

@Controller
public class EditController {

	@PostMapping("/edit")
	public ModelAndView edit(@RequestParam("id") String id, @RequestParam("date") String date) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("date", date);
		mv.setViewName("EditBook");
		return mv;
	}

	@PostMapping("/edited")
	public ModelAndView edited(BookDetails bookDetails) {
		ModelAndView mv = new ModelAndView();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookDetails> requestEntity = new HttpEntity<>(bookDetails, headers);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/edited";
		ResponseEntity<BookDetails> responseEntity =restTemplate.postForEntity(url, requestEntity, BookDetails.class);
		mv.setViewName("BookDetails");
		return mv;
	}
}
