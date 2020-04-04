package com.santosh.bookaloha.managers;

import java.util.ArrayList;
import java.util.Collection;

import com.santosh.bookaloha.entities.Book;

public class BooksManager {
private static BooksManager instance = new BooksManager();
private BooksManager() {};

public static BooksManager getInstance() {
	return instance;
}
public Collection<Book> getMyBooks() {
	Collection<Book> books = new ArrayList<Book>();
	// book1
	Book book = new Book();
	book.setImageUrl("santosh");
	book.setAuthor("santosh");
	book.setRating(4.3);
	books.add(book);
	// book2
	book= new Book();
	book.setImageUrl("dasdas");
	book.setAuthor("adada");
	book.setRating(5.2);
	books.add(book);
	
	return books;
	
}
/*public static void main(String[] args)
{
	ArrayList ls =(ArrayList) getInstance().getMyBooks();
	Iterator itr = ls.iterator();
	while(itr.hasNext()) {
		Book book=(Book) itr.next();
		String author= book.getAuthor();
		String url = book.getImageUrl();
		System.out.println("author is::"+ author +" and url is "+url);
	}*/
}


