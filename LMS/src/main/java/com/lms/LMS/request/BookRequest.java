package com.lms.LMS.request;

import java.util.List;

public class BookRequest {
	private String title;
	private String author;
	private String isbn;
	private String genre;
	private String publicationYear;

	private List<DepartmentRequest> departments;

	private boolean available;

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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public List<DepartmentRequest> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentRequest> departments) {
		this.departments = departments;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
