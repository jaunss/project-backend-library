package com.joaogcm.spring.rest.library.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogcm.spring.rest.library.entities.Book;
import com.joaogcm.spring.rest.library.services.BookService;

@RestController
@RequestMapping(value = "book")
public class BookResource {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/insertBook")
	public ResponseEntity<?> insertBook(@RequestBody Book book) {
		book = bookService.insertBook(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idBook}").buildAndExpand(book.getIdBook())
				.toUri();
		return ResponseEntity.created(uri).body(book);
	}

	@DeleteMapping(value = "/{idBook}")
	public ResponseEntity<?> deleteBookById(@PathVariable String idBook) {
		bookService.deleteBookById(idBook);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/updateBook/{idBook}")
	public ResponseEntity<?> updateBook(@PathVariable String idBook, @RequestBody Book book) {
		bookService.updateBook(idBook, book);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{idBook}")
	public ResponseEntity<?> findBookById(@PathVariable String idBook) {
		Book book = bookService.findBookById(idBook);
		return ResponseEntity.ok().body(book);
	}

	@GetMapping(value = "/findAllBooks")
	public ResponseEntity<?> findAllBooks() {
		List<Book> book = bookService.findAllBooks();
		return ResponseEntity.ok().body(book);
	}
}