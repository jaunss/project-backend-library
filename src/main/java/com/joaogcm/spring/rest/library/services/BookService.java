package com.joaogcm.spring.rest.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogcm.spring.rest.library.entities.Book;
import com.joaogcm.spring.rest.library.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book insertBook(Book book) {
		return book = bookRepository.save(book);
	}

	public void deleteBookById(String idBook) {
		findBookById(idBook);
		bookRepository.deleteById(idBook);
	}

	public Book updateBook(String idBook, Book book) {
		Book newBook = bookRepository.save(book);
		updateDataBook(newBook, book);
		return bookRepository.save(newBook);
	}

	private void updateDataBook(Book newBook, Book book) {
		newBook.setTitleBook(book.getTitleBook());
		newBook.setAuthorBook(book.getAuthorBook());
		newBook.setIsbnBook(book.getIsbnBook());
		newBook.setPriceBook(book.getPriceBook());
		newBook.setCodeProviderBook(book.getCodeProviderBook());
	}

	public Book findBookById(String idBook) {
		Optional<Book> book = bookRepository.findById(idBook);
		return book.orElseThrow(() -> new RuntimeException("Nenhum livro encontrado"));
	}

	public List<Book> findAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}
}