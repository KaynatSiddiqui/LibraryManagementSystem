package com.lms.LMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.lms.LMS.model.Book;

@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByisbn(String ISBN);

	List<Book> findByTitle(String title);

	List<Book> findBookByAuthor(String author);

	List<Book> findByAvailableTrue();

	@Modifying
	void deleteBookByisbn(String isbn);
}
