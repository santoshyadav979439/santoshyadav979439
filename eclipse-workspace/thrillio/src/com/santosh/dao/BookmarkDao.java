package com.santosh.dao;

import java.util.List;

import com.santosh.data.DataStore;
import com.santosh.entities.Bookmark;
import com.santosh.entities.User;
import com.santosh.entities.UserBookmark;

public class BookmarkDao {
	public List<List<Bookmark>> getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
}
