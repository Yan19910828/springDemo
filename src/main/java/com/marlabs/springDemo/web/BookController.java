package com.marlabs.springDemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marlabs.springDemo.domains.Book;
import com.marlabs.springDemo.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bs = new BookService();

	@GetMapping("/books")
	public String list(Model mode) {
		List<Book> books = bs.findAllBooks();
		mode.addAttribute("books", books);
		return "books";
	}

	@PostMapping("/books")
	public String post(Book book) {
		bs.addBook(book);
		return "redirect:/books";
	}

	@GetMapping("/books/{id}")
	public String details(@PathVariable long id, Model mode) {
		Book book = bs.findOneBook(id);
		mode.addAttribute("book", book);
		return "book";
	}

	@GetMapping("/books/addbook")
	public String addBook(Model mode) {
		mode.addAttribute("book", new Book());
		return "addBook";
	}

	@GetMapping("/books/addbook/{id}")
	public String editBook(@PathVariable long id, Model mode) {
		Book book = bs.findOneBook(id);
		mode.addAttribute("book", book);
		return "addBook";
	}

	@DeleteMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable long id, final RedirectAttributes ra) {
		bs.deleteBook(id);
		ra.addFlashAttribute("message", "Deleted");
		return "redirect:/books";

	}
}
