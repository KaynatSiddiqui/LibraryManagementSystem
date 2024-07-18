package com.lms.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.LMS.request.BookRequest;
import com.lms.LMS.response.BookResponse;
import com.lms.LMS.response.Message;
import com.lms.LMS.service.LibraryService;


@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	LibraryService service;

	@PostMapping("/saveBooks")
	public ResponseEntity<Message> saveBook(@RequestBody BookRequest request) throws Exception {
		return new ResponseEntity<Message>(service.addBook(request), HttpStatus.OK);
	}

	@DeleteMapping("/deleteBookByIsbn")
	public ResponseEntity<Message> deleteBookByIsbn(@RequestParam("isbn") String isbn) throws Exception {
		return new ResponseEntity<Message>(service.deleteBookByIsbn(isbn), HttpStatus.OK);
	}

	@GetMapping("/getByTitle")
	public ResponseEntity<List<BookResponse>> getByTitle(@RequestParam("title") String title) throws Exception {
		return new ResponseEntity<List<BookResponse>>(service.findByTitle(title), HttpStatus.OK);
	}

	@GetMapping("/getByAuthor")
	public ResponseEntity<List<BookResponse>> getByAuthor(@RequestParam("author") String author) throws Exception {
		return new ResponseEntity<List<BookResponse>>(service.findBookByAuthor(author), HttpStatus.OK);
	}

	@GetMapping("/getAllBooks")
	public ResponseEntity<List<BookResponse>> getAllBooks() throws Exception {
		return new ResponseEntity<List<BookResponse>>(service.findAllBooks(), HttpStatus.OK);

	}

	@GetMapping("/getAvailableBooks")
	public ResponseEntity<List<BookResponse>> getAvailableBooks() throws Exception {
		return new ResponseEntity<List<BookResponse>>(service.getAvailableBooks(), HttpStatus.OK);
	}
}
