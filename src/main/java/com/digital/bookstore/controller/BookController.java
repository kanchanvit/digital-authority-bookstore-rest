package com.digital.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.bookstore.request.BookRequest;
import com.digital.bookstore.request.CheckoutRequest;
import com.digital.bookstore.response.BookResponse;
import com.digital.bookstore.response.CheckoutResponse;
import com.digital.bookstore.response.Status;
import com.digital.bookstore.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<BookResponse> getAllBooks(){
		return ResponseEntity.of(this.bookService.getAllBook());
	}
	
	@PostMapping
	public ResponseEntity<Status> add(@RequestBody BookRequest BookRequest){
		return ResponseEntity.of(this.bookService.add(BookRequest));
	}
	
	@PutMapping
	public ResponseEntity<Status> update(@RequestBody BookRequest BookRequest){
		//return ResponseEntity.of(this.bookService.update(BookRequest));
		return null;
	}
	
	@PostMapping("/checkout")
	public ResponseEntity<CheckoutResponse> checkout(@RequestBody CheckoutRequest checkoutRequest){
		System.out.println(checkoutRequest);
		
		return ResponseEntity.of(this.bookService.checkout(checkoutRequest));
	}
}
