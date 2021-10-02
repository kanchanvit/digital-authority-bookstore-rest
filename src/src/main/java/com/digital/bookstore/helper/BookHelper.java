package com.digital.bookstore.helper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.digital.bookstore.entity.Book;
import com.digital.bookstore.request.BookRequest;
import com.digital.bookstore.response.Status;

 

public enum BookHelper {

	BOOK_HELPER;
	
	public List<BookRequest> constructBooks(List<Book> books){
		return books.stream().filter(Objects::nonNull).map(this::constructBookRequest).collect(Collectors.toList());
	}
	
	private BookRequest constructBookRequest(final Book book) {
		return BookRequest.builder().id(book.getId()).name(book.getName()).description(book.getDescription()).author(book.getAuthor()).classification(book.getClassification()).price(book.getPrice()).ISBN(book.getISBN()).build();
	}
	
	public Optional<Book> constructBook(final BookRequest bookRequest){
		return Objects.nonNull(bookRequest) ? Optional.of(Book.builder().id(bookRequest.getId()).name(bookRequest.getName()).description(bookRequest.getDescription()).author(bookRequest.getAuthor()).classification(bookRequest.getClassification()).price(bookRequest.getPrice()).ISBN(bookRequest.getISBN()).build()) : Optional.empty();
	}
	
	public Optional<Status> constructStatus(final boolean status, final String message){
		return Optional.of(Status.builder().status(status).message(message).build());
	}
}
