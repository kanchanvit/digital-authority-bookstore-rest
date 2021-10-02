package com.digital.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digital.bookstore.entity.Book;
import com.digital.bookstore.repository.BookRepository;
import com.digital.bookstore.request.BookRequest;
import com.digital.bookstore.request.Checkout;
import com.digital.bookstore.request.CheckoutRequest;
import com.digital.bookstore.response.BookResponse;
import com.digital.bookstore.response.CheckoutResponse;
import com.digital.bookstore.response.Status;
import static com.digital.bookstore.helper.BookHelper.BOOK_HELPER;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Optional<BookResponse> getAllBook() {
		List<Book> books = bookRepository.findAll();
		System.out.println("books" + books);
		return Optional.of(BookResponse.builder().books(BOOK_HELPER.constructBooks(books)).build());
	}



	/*public Book getBookById(int id) {
		return bookRepository.findById(id);
	}*/

	 @Transactional
	public Optional<Status> add(final BookRequest bookRequest) {
		boolean status = true;
		String message = "Successfully added the book record";
		Optional<Book> book = BOOK_HELPER.constructBook(bookRequest);
		book.ifPresent(tmpbook ->bookRepository.save(tmpbook));
		return BOOK_HELPER.constructStatus(status,message);
	}

	 
	public Optional<Status> delete(final Integer id) {
		boolean status = false;
		String message = "Unable to delete.";
		if(Objects.isNull(id)) {
			return BOOK_HELPER.constructStatus(status,message);
		}
		bookRepository.deleteById(id);
		status =  true;
		message = "Sucessfully deleted";
		return BOOK_HELPER.constructStatus(status,message);
	}

	 
	public Optional<Status> update(final BookRequest bookRequest) {
		
		
		boolean status = false;
		String message = "Unable to update either request is null or book id is null";
		if(Objects.isNull(bookRequest) || bookRequest.getId() == null || bookRequest.getId() == 0) {
			return BOOK_HELPER.constructStatus(status,message);
		}
		
		Optional<Book> bookexist = bookRepository.findById(bookRequest.getId());
		if(!bookexist.isPresent()) {
			message = "Unable to update. Book does not exist";
			return BOOK_HELPER.constructStatus(status,message);
		}
		Optional<Book> book = BOOK_HELPER.constructBook(bookRequest);
		book.ifPresent(tmpbook ->bookRepository.save(tmpbook));
		status =  true;
		message = "Sucessfully updated";
		return BOOK_HELPER.constructStatus(status,message);
	}
	 
	 public Optional<CheckoutResponse> checkout(final CheckoutRequest checkoutRequest) {
		 List<Checkout> checkout = checkoutRequest.getCheckout();
		 Objects.nonNull(checkout);
		// checkout.stream().
		 
		 return null; 
		 
	 }
}
