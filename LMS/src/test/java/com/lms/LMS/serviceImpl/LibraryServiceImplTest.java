package com.lms.LMS.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.LMS.model.Book;
import com.lms.LMS.model.Department;
import com.lms.LMS.repository.BookRepository;
import com.lms.LMS.repository.DepartmentRepository;
import com.lms.LMS.request.BookRequest;
import com.lms.LMS.response.Message;

@SpringBootTest
public class LibraryServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private LibraryServiceImpl libraryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBook_Success() throws Exception {
        // Mocking the repository behavior
        when(bookRepository.findByisbn("1234567890")).thenReturn(null);

        BookRequest request = new BookRequest();
        request.setIsbn("1234567890");
        request.setTitle("Sample Book");
        request.setAuthor("John Doe");
        request.setGenre("Fiction");
        request.setPublicationYear("2023");
        request.setAvailable(true);

        Department department = new Department();
        department.setId(1L);
        department.setName("Fiction");
        department.setLocation("First Floor");

        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        Message message = libraryService.addBook(request);
        assertEquals("Data saved successfully.", message.getMessage());
    }

    @Test
    public void testAddBook_DuplicateIsbn() throws Exception {
        // Mocking the repository behavior
        Book existingBook = new Book();
        existingBook.setIsbn("1234567890");
        when(bookRepository.findByisbn("1234567890")).thenReturn(existingBook);

        BookRequest request = new BookRequest();
        request.setIsbn("1234567890");
        request.setTitle("Sample Book");
        request.setAuthor("John Doe");
        request.setGenre("Fiction");
        request.setPublicationYear("2023");
        request.setAvailable(true);

        Message message = libraryService.addBook(request);
        assertEquals("The ISBN given is already assigned to another book.", message.getMessage());
    }

    @Test
    public void testAddBook_InvalidRequest() throws Exception {
        BookRequest request = new BookRequest();
        request.setIsbn(null); // Invalid ISBN

        Message message = libraryService.addBook(request);
        assertTrue(message.getMessage().contains("Please enter ISBN"));
    }

    @Test
    public void testDeleteBookByIsbn_Success() throws Exception {
        String isbn = "1234567890";
        Message message = libraryService.deleteBookByIsbn(isbn);
        assertEquals("Book deleted successfully.", message.getMessage());
    }

    // Add more test cases for findByTitle, findBookByAuthor, findAllBooks, getAvailableBooks methods

}
