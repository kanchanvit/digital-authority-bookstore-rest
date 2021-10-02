package com.digital.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
