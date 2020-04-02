package com.santosh.manager;

import java.util.List;

import com.santosh.dao.BookmarkDao;
import com.santosh.entities.Book;
import com.santosh.entities.Bookmark;
import com.santosh.entities.Movie;
import com.santosh.entities.User;
import com.santosh.entities.UserBookmark;
import com.santosh.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();
	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {

		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imbdRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imbdRating);
		return movie;

	}
	
	public Book createBook(long id, String title, String profileUrl,int publicationYear,String publisher,String[] author,String genre,double amazonRating) {
		
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		return book;
	}
	
	public WebLink createWeblink(long id, String title, String profileUrl,String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl);
		weblink.setUrl(url);
		weblink.setHost(host);
		return weblink;
	}
	public List<List<Bookmark>> getBookMarks(){
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
	UserBookmark userBookmark = new UserBookmark();
	userBookmark.setUser(user);
	userBookmark.setBookmark(bookmark);
	dao.saveUserBookmark(userBookmark);
		
	}

	public void setKidFriendlyStatus(User user,String kidFriendlyStatusDecision, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatusDecision);
		bookmark.setKidFriendyMarkedBy(user);
		System.out.println("kidFriendlyStatus::"+kidFriendlyStatusDecision +"mark by" +user.getEmail());
		
	}

	public static void getInstance(User user, Bookmark bookmark) {
		
		bookmark.setSharedBy(user);
		System.out.println("bookmark is shared by"+user.getEmail());
		if(bookmark instanceof Book) {
			System.out.println(((Book) bookmark).getItemData());
		}
		else if(bookmark instanceof WebLink)
			System.out.println(((WebLink) bookmark).getItemData());
		
	}


}
