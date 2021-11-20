package com.joaogcm.spring.rest.library.exceptions;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2910628588629101301L;

	public BookNotFoundException(String message) {
		super(message);
	}
}