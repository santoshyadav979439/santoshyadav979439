package com.santosh.controllers;

import com.santosh.entities.Bookmark;
import com.santosh.entities.User;
import com.santosh.manager.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	public static BookmarkController getInstance() {
		return instance;
	}
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
		
	}
	public void setKidFriendlyStatus(User user,String kidFriendlyStatusDecision, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatusDecision,bookmark);
		
	}
	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance(user,bookmark);
		
	}
}
