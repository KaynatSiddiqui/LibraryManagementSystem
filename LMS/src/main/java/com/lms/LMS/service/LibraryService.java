package com.lms.LMS.service;

import java.util.List;

import com.lms.LMS.request.BookRequest;
import com.lms.LMS.response.BookResponse;
import com.lms.LMS.response.Message;



public interface LibraryService {
	
	public Message addBook(BookRequest requset) throws Exception;
	
	public Message deleteBookByIsbn(String id) throws Exception;
	
	public List<BookResponse> findByTitle(String title) throws Exception;
	
	public List<BookResponse> findBookByAuthor(String author) throws Exception;
	
	public List<BookResponse> findAllBooks() throws Exception;
	
	public List<BookResponse> getAvailableBooks() throws Exception;

}