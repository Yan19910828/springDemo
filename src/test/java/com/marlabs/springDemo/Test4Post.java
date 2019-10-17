package com.marlabs.springDemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.marlabs.springDemo.domains.Book;
import com.marlabs.springDemo.services.BookService;

public class Test4Post {

	@Mock
	BookService bs;
//	BookRepository br;

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Before
	public void setUp() {

	}

	@Test
	public void testPost() {
		Book b1 = new Book("Java", "YYQ", "1234");
//		Book b2 = mock(Book.class);
		List<Book> bb = new ArrayList<Book>();
		bb.add(b1);
//		bb.add(b2);

		when(bs.findByName("YYQ")).thenReturn(bb);
		assertEquals(bs.findByName("YYQ"), bb);
		verify(bs).findByName("YYQ");
		System.out.println(bb);

	}

//	public List<Book> findByName(String name) {
//		return bookService.findByName(name);
//	}
}
