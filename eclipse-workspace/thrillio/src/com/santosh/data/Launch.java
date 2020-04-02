package com.santosh.data;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.santosh.entities.Bookmark;
import com.santosh.entities.User;
import com.santosh.manager.BookmarkManager;
import com.santosh.manager.UserManager;

public class Launch {
	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;

	private static void loadData() {
		System.out.println("1:: loading data:::");
		try {
			DataStore.loadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookMarks();
		// System.out.println("printing data::");
		// printUserData();
		// printBookmarkData();
	}

	private static void start() {
	//	System.out.println("\n 2:: bookmarking data:::");
		for (User user : users) {
			View.browse(user, bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
		start();
	}

	private static void printBookmarkData() {
		/*
		 * for (List bookmarkList : bookmarks) { for (Bookmark bookmark : bookmarkList)
		 * { System.out.println(bookmark); } }
		 */
		Iterator bookmarkList= bookmarks.iterator();
		while(bookmarkList.hasNext()) {
			Iterator bookmark= bookmarks.iterator();
			while(bookmark.hasNext()) {
				System.out.println(bookmark.next());
			}
		}

	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);
		}

	}

}
