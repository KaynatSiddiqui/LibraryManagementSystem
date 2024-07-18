package com.lms.LMS.response;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "TITLE", "AUTHOR", "ISBN", "GENRE", "USER_EMAIL", "PUBLICATION_YEAR", "BOOK_ID", "DEPARTMENTS",
		"AVAILABLE", "MESSAGE" })
@Generated("jsonschema2pojo")
public class BookResponse {

	@JsonProperty("TITLE")
	private String title;
	@JsonProperty("AUTHOR")
	private String author;
	@JsonProperty("ISBN")
	private String ISBN;
	@JsonProperty("GENRE")
	private String genre;
	@JsonProperty("PUBLICATION_YEAR")
	private String publicationYear;
	@JsonProperty("BOOK_ID")
	private String bookId;
	@JsonProperty("DEPARTMENTS")
	private DepartmentResponse departments;
	@JsonProperty("AVAILABLE")
	private boolean available;
	@JsonProperty("MESSAGE")
	private Message message;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public DepartmentResponse getDepartments() {
		return departments;
	}

	public void setDepartments(DepartmentResponse departments) {
		this.departments = departments;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
