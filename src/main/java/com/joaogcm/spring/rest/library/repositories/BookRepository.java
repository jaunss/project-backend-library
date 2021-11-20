package com.joaogcm.spring.rest.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.spring.rest.library.entities.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

	@Query("SELECT b.titleBook FROM Book b WHERE b.titleBook like %?1%")
	public List<Book> findBookByTitleBook(String titleBook);
}