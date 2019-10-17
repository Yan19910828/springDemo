package com.marlabs.springDemo.domains;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Override
	Page<Book> findAll(Pageable pageable);

	List<Book> deleteById(long id);

	List<Book> findByName(String name);

	List<Book> findByAuthor(String author);
//
//
//	List<Book> findByIsbn(String isbn);
//
//	List<Book> findByStatus(int status);

}
