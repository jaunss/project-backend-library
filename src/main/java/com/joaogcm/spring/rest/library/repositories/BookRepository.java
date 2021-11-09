package com.joaogcm.spring.rest.library.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.spring.rest.library.entities.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}