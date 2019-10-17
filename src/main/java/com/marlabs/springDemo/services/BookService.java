package com.marlabs.springDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.marlabs.springDemo.domains.Book;
import com.marlabs.springDemo.domains.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Page<Book> findAllByPage() {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(1, 2, sort);
		return bookRepository.findAll(pageable);
	}

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Book addBook(Book book) {

		return bookRepository.save(book);
	}

	public Book findOneBook(long id) {
		return bookRepository.findById(id).orElse(null);
	}

	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}

	public List<Book> findByName(String name) {
		return bookRepository.findByName(name);
	}

	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

//	public List<Book> findByIsbn(String isbn) {
//		return bookRepository.findByIsbn(isbn);
//	}
//
//	public List<Book> findByStatus(int status) {
//		return bookRepository.findByStatus(status);
//	}

}
