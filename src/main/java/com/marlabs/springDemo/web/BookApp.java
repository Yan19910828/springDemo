package com.marlabs.springDemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marlabs.springDemo.domains.Book;
import com.marlabs.springDemo.services.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookApp {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getAll() {

		return bookService.findAllBooks();
	}

	@PostMapping("/books")
	public Book addBook(@RequestParam("name") String name, @RequestParam("author") String author,
			@RequestParam("isbn") String isbn, @RequestParam("status") int status) {

		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setIsbn(isbn);
		book.setStatus(status);
		return bookService.addBook(book);
	}

	@GetMapping("/books/")
	public Book getOneBook(@RequestParam("id") long id) {
		return bookService.findOneBook(id);
	}

	@PutMapping("/books/")
	public Book updateBook(@RequestParam("id") long id, @RequestParam("name") String name,
			@RequestParam("author") String author, @RequestParam("isbn") String isbn,
			@RequestParam("status") int status) {

		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setIsbn(isbn);
		book.setStatus(status);
		return bookService.addBook(book);
	}

	@DeleteMapping("/books/")
	public void deleteBook(@RequestParam("id") long id) {
		bookService.deleteBook(id);
		System.out.println("Deleted:" + id);
	}

	@PostMapping("/books/search")
	public List<Book> findByName(@RequestParam("name") String name) {
		return bookService.findByName(name);
	}

}
