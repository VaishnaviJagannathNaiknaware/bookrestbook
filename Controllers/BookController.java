 package com.api.Book.bootrestbook.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.Book.bootrestbook.entities.Book;
import com.api.Book.bootrestbook.services.Bookservice;

@RestController
public class BookController {
	@Autowired
	private Bookservice bookService; 
	
	//get all books handler
	@GetMapping("/books")
	public List<Book> getBooks() 
	{
	return this.bookService.getAllBooks();
	} 
	
	//get single book handler
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}
	
	//new book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book  book)
	{
		Book b = this.bookService.addBook(book);
		return b;
	}
	
	//delete book handler
	
	@DeleteMapping("/book/{bookId}")
	public void deleteBook(@PathVariable("bookId")int bookId) 
	{
		this.bookService.deleteBook(bookId);
    }
	
	//update book handler
	@PutMapping("/book/{bookId}") 
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId")int bookId) 
	
	{  
	     this.bookService.updateBook(book ,bookId);
	     return book;
    }
}
	
	
	