package com.lms.LMS.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.LMS.model.Book;
import com.lms.LMS.model.Department;
import com.lms.LMS.repository.BookRepository;
import com.lms.LMS.repository.DepartmentRepository;
import com.lms.LMS.request.BookRequest;
import com.lms.LMS.request.DepartmentRequest;
import com.lms.LMS.response.BookResponse;
import com.lms.LMS.response.DepartmentResponse;
import com.lms.LMS.response.Message;
import com.lms.LMS.service.LibraryService;

import jakarta.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Message addBook(BookRequest requset) throws Exception {
		List<DepartmentRequest> dept = requset.getDepartments();
		List<Department> deptEntity = new ArrayList<Department>();
		Message msg = valiateRequest(requset);
		Message message = new Message();
		Book book = null;

		try {
			if (msg.getMessage().isBlank()) {
				book = bookRepository.findByisbn(requset.getIsbn());
				if (book == null) {
					book = new Book();
					book.setAuthor(requset.getAuthor() == null ? "" : requset.getAuthor());
					book.setTitle(requset.getTitle() == null ? "" : requset.getTitle());
					book.setIsbn(requset.getIsbn() == null ? "" : requset.getIsbn());
					book.setGenre(requset.getGenre() == null ? "" : requset.getGenre());
					book.setPublicationYear(Integer
							.parseInt(requset.getPublicationYear() == null ? "0" : requset.getPublicationYear()));
					book.setAvailable(requset.isAvailable());
					for (DepartmentRequest req : dept) {
						Department department = new Department();
						department.setName(req.getName() == null ? "" : req.getName());
						department.setLocation(req.getLocation() == null ? "" : req.getLocation());
						departmentRepository.save(department);
						deptEntity.add(department);
					}
					book.setDepartments(deptEntity);
					bookRepository.save(book);
					message.setMessage("Data saved successfully.");
				} else {
					message.setMessage("The ISBN given is already assigned to another book.");
				}
			}else
			{
				return msg;
			}

		} catch (Exception e) {
			e.printStackTrace();
			message.setMessage("Something went wrong please contact admin");
			return message;
		}
		return message;
	}

	public Message valiateRequest(BookRequest requset) {
		Message message = new Message();
		String msg = "";
		if (requset.getIsbn() == null || requset.getIsbn().equals("")) {
			msg = "Please enter ISBN";
		}
		if (requset.getTitle() == null || requset.getTitle().equals("")) {
			msg = msg + " and title as well";
		}
		message.setMessage(msg);
		return message;

	}

	@Override
	public Message deleteBookByIsbn(String isbn) throws Exception {
		Message message = new Message();
		try {
			bookRepository.deleteBookByisbn(isbn);
		} catch (Exception e) {
			e.printStackTrace();
			message.setMessage("Something went wrong please contact admin");
			return message;
		}
		message.setMessage("Book deleted successfully.");
		return message;
	}

	@Override
	public List<BookResponse> findByTitle(String title) throws Exception {

		List<BookResponse> response = new ArrayList<BookResponse>();
		try {
			List<Book> byTitle = bookRepository.findByTitle(title);
			if (!byTitle.isEmpty()) {
				for (Book res : byTitle) {
					BookResponse bookRespobnse = new BookResponse();
					DepartmentResponse deptEntity = new DepartmentResponse();
					bookRespobnse.setAuthor(res.getTitle());
					bookRespobnse.setAvailable(res.isAvailable());
					bookRespobnse.setTitle(res.getTitle());
					bookRespobnse.setGenre(res.getGenre());
					bookRespobnse.setPublicationYear(String.valueOf(res.getPublicationYear()));
					bookRespobnse.setDepartments(null);
					bookRespobnse.setISBN(res.getIsbn());
					bookRespobnse.setBookId(String.valueOf(res.getId()));
					List<Department> dept = res.getDepartments();
					deptEntity.setId(dept.get(0).getId());
					deptEntity.setLocation(dept.get(0).getLocation());
					deptEntity.setName(dept.get(0).getName());
					bookRespobnse.setDepartments(deptEntity);
					response.add(bookRespobnse);
				}
			} else {

				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

	@Override
	public List<BookResponse> findBookByAuthor(String author) throws Exception {

		List<BookResponse> response = new ArrayList<BookResponse>();
		try {
			List<Book> byTitle = bookRepository.findBookByAuthor(author);
			if (!byTitle.isEmpty()) {
				for (Book res : byTitle) {
					BookResponse bookRespobnse = new BookResponse();
					DepartmentResponse deptEntity = new DepartmentResponse();
					bookRespobnse.setAuthor(res.getTitle());
					bookRespobnse.setAvailable(res.isAvailable());
					bookRespobnse.setTitle(res.getTitle());
					bookRespobnse.setGenre(res.getGenre());
					bookRespobnse.setPublicationYear(String.valueOf(res.getPublicationYear()));
					bookRespobnse.setDepartments(null);
					bookRespobnse.setISBN(res.getIsbn());
					bookRespobnse.setBookId(String.valueOf(res.getId()));
					List<Department> dept = res.getDepartments();
					deptEntity.setId(dept.get(0).getId());
					deptEntity.setLocation(dept.get(0).getLocation());
					deptEntity.setName(dept.get(0).getName());
					bookRespobnse.setDepartments(deptEntity);
					response.add(bookRespobnse);
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

	@Override
	public List<BookResponse> findAllBooks() throws Exception {

		List<BookResponse> response = new ArrayList<BookResponse>();
		try {
			List<Book> byTitle = bookRepository.findAll();
			if (!byTitle.isEmpty()) {
				for (Book res : byTitle) {
					BookResponse bookRespobnse = new BookResponse();
					DepartmentResponse deptEntity = new DepartmentResponse();
					bookRespobnse.setAuthor(res.getTitle());
					bookRespobnse.setAvailable(res.isAvailable());
					bookRespobnse.setTitle(res.getTitle());
					bookRespobnse.setGenre(res.getGenre());
					bookRespobnse.setPublicationYear(String.valueOf(res.getPublicationYear()));
					bookRespobnse.setDepartments(null);
					bookRespobnse.setISBN(res.getIsbn());
					bookRespobnse.setBookId(String.valueOf(res.getId()));
					List<Department> dept = res.getDepartments();
					deptEntity.setId(dept.get(0).getId());
					deptEntity.setLocation(dept.get(0).getLocation());
					deptEntity.setName(dept.get(0).getName());
					bookRespobnse.setDepartments(deptEntity);
					response.add(bookRespobnse);
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

	@Override
	public List<BookResponse> getAvailableBooks() throws Exception {

		List<BookResponse> response = new ArrayList<BookResponse>();
		try {
			List<Book> byTitle = bookRepository.findByAvailableTrue();
			if (!byTitle.isEmpty()) {
				for (Book res : byTitle) {
					BookResponse bookRespobnse = new BookResponse();
					DepartmentResponse deptEntity = new DepartmentResponse();
					bookRespobnse.setAuthor(res.getTitle());
					bookRespobnse.setAvailable(res.isAvailable());
					bookRespobnse.setTitle(res.getTitle());
					bookRespobnse.setGenre(res.getGenre());
					bookRespobnse.setPublicationYear(String.valueOf(res.getPublicationYear()));
					bookRespobnse.setDepartments(null);
					bookRespobnse.setISBN(res.getIsbn());
					bookRespobnse.setBookId(String.valueOf(res.getId()));
					List<Department> dept = res.getDepartments();
					deptEntity.setId(dept.get(0).getId());
					deptEntity.setLocation(dept.get(0).getLocation());
					deptEntity.setName(dept.get(0).getName());
					bookRespobnse.setDepartments(deptEntity);
					response.add(bookRespobnse);
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

}
