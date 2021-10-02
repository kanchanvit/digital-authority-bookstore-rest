package com.digital.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digital.bookstore.entity.Book;
import com.digital.bookstore.repository.BookRepository;
import com.digital.bookstore.request.BookRequest;
import com.digital.bookstore.response.BookResponse;
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
	public Optional<Status> add(final BookRequest BookRequest) {
		boolean status = true;
		String message = "Successfully added the book record";
		Optional<Book> book = BOOK_HELPER.constructBook(BookRequest);
		book.ifPresent(tmpbook ->bookRepository.save(tmpbook));
		return BOOK_HELPER.constructStatus(status,message);
	}

	 
	/*public Optional<Status> delete(int id) {
		bookRepository.deleteById(id);
	}

	 
	public Optional<Status> update(BookRequest Book) {
		boolean status = true;
		String message = "Successfully update the book record";
		bookRepository.save(Book);
	}*/
}
