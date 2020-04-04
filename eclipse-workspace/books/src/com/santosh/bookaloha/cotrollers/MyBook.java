package com.santosh.bookaloha.cotrollers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.santosh.bookaloha.entities.Book;
import com.santosh.bookaloha.managers.BooksManager;

/**
 * Servlet implementation class MyBook
 */
//@WebServlet("/MyBook")
public class MyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 1. get data from manager
	Collection<Book> books =BooksManager.getInstance().getMyBooks();
	System.out.println(books);
	request.setAttribute("books", books);

	// 2. forward responst to jsp
	RequestDispatcher rd=request.getRequestDispatcher("MyBook.jsp");
	rd.forward(request, response);
	
	
	}
}
