package com.marlabs.springDemo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class HelloController {

	public @ResponseBody String hello() {
		return "Hello, it's your first Spring Boot Application";
	}

	@GetMapping("/books")
	public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size", defaultValue = "10") int size) {

		Map<String, Object> book = new HashMap<>();
		book.put("name", "Java从入门到放弃");
		book.put("author", "Benwei Lu");
		book.put("ISBN", "9527");
		Map<String, Object> book2 = new HashMap<>();
		book2.put("name", "CPP从入门到放弃");
		book2.put("author", "Benwei Lu");
		book2.put("ISBN", "9528");
		List<Map> booklist = new ArrayList<>();
		booklist.add(book);
		booklist.add(book2);

		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("page", page);
		pageMap.put("size", size);
		pageMap.put("booklist", booklist);

		return pageMap;
	}

	@PostMapping("/books")
	public Object post(@RequestParam("name") String name, @RequestParam("author") String author,
			@RequestParam("isbn") String isbn) {

		Map<String, Object> book = new HashMap<>();
		book.put("name", name);
		book.put("author", author);
		book.put("isbn", isbn);

		return book;

	}

}
