package com.nagarro.advancedJava.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class BookDetails {

	@Id
	@Column
	int code;
	@Column
	String name;
	@Column
	String author;
	@Column
	String date;
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public String getDate() {
		return date;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BookDetails [code=" + code + ", name=" + name + ", author=" + author + ", date=" + date + "]";
	}
}
