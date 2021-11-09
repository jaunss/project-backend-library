package com.joaogcm.spring.rest.library.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Table(name = "bookEntity")
public class Book implements Serializable {

	private static final long serialVersionUID = -5550544386768607975L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idBook;
	private String titleBook;
	private String authorBook;
	private String isbnBook;
	private Double priceBook;
	private String codeProviderBook;

	public Book() {

	}

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

	public String getTitleBook() {
		return titleBook;
	}

	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}

	public String getAuthorBook() {
		return authorBook;
	}

	public void setAuthorBook(String authorBook) {
		this.authorBook = authorBook;
	}

	public String getIsbnBook() {
		return isbnBook;
	}

	public void setIsbnBook(String isbnBook) {
		this.isbnBook = isbnBook;
	}

	public Double getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(Double priceBook) {
		this.priceBook = priceBook;
	}

	public String getCodeProviderBook() {
		return codeProviderBook;
	}

	public void setCodeProviderBook(String codeProviderBook) {
		this.codeProviderBook = codeProviderBook;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (idBook == null) {
			if (other.idBook != null)
				return false;
		} else if (!idBook.equals(other.idBook))
			return false;
		return true;
	}
}