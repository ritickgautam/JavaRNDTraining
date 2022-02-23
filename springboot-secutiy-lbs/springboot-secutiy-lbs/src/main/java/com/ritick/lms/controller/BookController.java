package com.ritick.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritick.lms.exception.NotFoundException;
import com.ritick.lms.model.Book;
import com.ritick.lms.service.BookService;

@RestController
@RequestMapping("lms/api/v1")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks(){
		System.out.println("In book service to return book details");
		return bookService.getBookDetails();
	}

	@GetMapping("/books/{bookId}")
	public Optional<Book> getBook(@PathVariable int bookId){
		System.out.println("In book service to return book detail");
		Optional<Book> tbook = bookService.getBookDetailsById(bookId);
		if(tbook==null)
		{
			System.out.println("Book not found ");
			throw new NotFoundException("Book not found Exception");
		}
		return tbook;
	}

	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book) {
		System.out.println("In book service to save book details");
		book.setBookId(0);
		bookService.registerBookDetails(book);
		return book;
	}

	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) {
		System.out.println("In book service to update book details");
		bookService.updateBookDetails(book);
		return book;
	}

	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) throws Exception{
		System.out.println("In book service to delete book");
		Optional<Book> tbook = bookService.getBookDetailsById(bookId);
		if(tbook==null)
		{
			System.out.println("Book not found ");
			throw new NotFoundException("Book not found Exception");
		}
		bookService.deleteBookDetails(bookId);
		return "Book has been deleted";
	}


}
