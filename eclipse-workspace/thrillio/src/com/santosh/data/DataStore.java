package com.santosh.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.santosh.constants.BookGenre;
import com.santosh.constants.Gender;
import com.santosh.constants.MovieGenre;
import com.santosh.constants.UserType;
import com.santosh.entities.Bookmark;
import com.santosh.entities.User;
import com.santosh.entities.UserBookmark;
import com.santosh.manager.BookmarkManager;
import com.santosh.manager.UserManager;
public class DataStore {
	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;
	private static List<User> user = new ArrayList<>();
	public static List<User> getUser() {
		return user;
	}

	public static List<List<Bookmark>> getBookmarks() {
		return bookmarks;
	}
	private static List<List<Bookmark>> bookmarks = new ArrayList<>();
	private static UserBookmark[] userBookmark = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	private static int bookmarkIndex;
	public static void loadData() throws SQLException {
		/*
		 * loadUsers(); loadWeblinks(); loadMovies(); loadBooks();
		 */	
		
		
		try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_test","root","root");
				Statement stmt = conn.createStatement()){
			loadUsers(); 
			loadWeblinks(); 
			loadMovies(); 
			loadBooks();
		}
	}

private static void loadUsers() {
		
		user.add(UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M",
				Gender.MALE, UserType.USER));
		user.add(UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "Sam", "M",
				Gender.MALE, UserType.EDITOR));
		user.add( UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Anita", "m",
				Gender.FEMALE, UserType.EDITOR));
		user.add( UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Sara", "M",
				Gender.FEMALE, UserType.USER));
		user.add(UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Santosh", "M",
				Gender.MALE, UserType.CHIEF_EDITOR));
	}

	private static void loadWeblinks() {
		List<Bookmark> weblinks = new ArrayList<Bookmark>();
		
				weblinks.add( BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger", "Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com"));
				weblinks.add( BookmarkManager.getInstance().createWeblink(2001, "how to",
				"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com"));
				weblinks.add( BookmarkManager.getInstance().createWeblink(2002, "Interface vs Abstract Class",
				"http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com", "unknown"));
				weblinks.add(BookmarkManager.getInstance().createWeblink(2003, "NIO tutorial by Greg Travis",
				"http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf'", "http://cs.brown.edu", "unknown"));
				weblinks.add( BookmarkManager.getInstance().createWeblink(2004, "Virtual Hosting and Tomcat",
				"http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org",	
				"unknown"));
				bookmarks.add(weblinks);

	}
	
	private static void loadMovies() {
		List<Bookmark> movies = new ArrayList<Bookmark>();
	
		movies.add(BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.CLASSICS,8.5));
		movies.add(BookmarkManager.getInstance().createMovie(3001,"The Grapes of Wrath","",1940,new String[]{"Henry Fonda","Jane Darwell"}, new String[] {"John Ford"},MovieGenre.CLASSICS,8.2));
		movies.add(BookmarkManager.getInstance().createMovie(3002,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},"Classics",8.5));
		movies.add(BookmarkManager.getInstance().createMovie(3003,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},"Classics",8.5));
		movies.add(BookmarkManager.getInstance().createMovie(3004,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},"Classics",8.5));
		bookmarks.add(movies);
	}
	private static void loadBooks() {
		List<Bookmark> books = new ArrayList<Bookmark>();
	
				books.add(BookmarkManager.getInstance().createBook(4000,"Walden","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"},BookGenre.PHYLOSPHY,4.3));
				books.add(BookmarkManager.getInstance().createBook(4001,"Walden1","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"},BookGenre.PHYLOSPHY,4.3));
				books.add(BookmarkManager.getInstance().createBook(4002,"Walden2","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"},BookGenre.PHYLOSPHY,4.3));
				books.add(BookmarkManager.getInstance().createBook(4003,"Walden3","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"},BookGenre.PHYLOSPHY,4.3));
				books.add(BookmarkManager.getInstance().createBook(4004,"Walden3","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"},BookGenre.PHYLOSPHY,4.3));
				bookmarks.add(books);
	}

	public static void add(UserBookmark userBookMark) {
		
		userBookmark[bookmarkIndex]=userBookMark;
		bookmarkIndex++;
	}
	
	
}
