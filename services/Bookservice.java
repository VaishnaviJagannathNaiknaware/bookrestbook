package com.api.Book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.Book.bootrestbook.entities.Book;


@Component
public class Bookservice {
	
	private static List<Book> list=new ArrayList();
	
	static {
	list.add(new Book(124,"Java Complete Reference","ABC"));
	list.add(new Book(125,"Head First to Java","PQR"));
	list.add(new Book(126,"Thing in Java","LMN"));
	}
	
	//get all books 
	public List<Book> getAllBooks(){
		return list;
	}
	 
	
	//get single book by id
	public Book getBookById(int id) {
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book; 
	}
	
	//adding the book
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
	
	//delete book
	public void deleteBook(int bid) 
	{
		list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
	}
	
	//update the book 
	public void updateBook(Book book,int bookId)
	{
		list=list.stream().map(b->{
			if(b.getId()==bookId)
			{
				b.setTitle(book.getTitle());
				b.setAuther(book.getAuther());
			}
			return b;
			
		}).collect(Collectors.toList());
    }
}