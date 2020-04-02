package com.santosh.data;

import java.util.Iterator;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;

import com.santosh.constants.KidFrindlyStatus;
import com.santosh.constants.UserType;
import com.santosh.controllers.BookmarkController;
import com.santosh.entities.Bookmark;
import com.santosh.entities.User;
import com.santosh.partner.Shareable;

public class View {
	/*
	 * public static void bookmark(User user,Bookmark[][] bookmarks) {
	 * System.out.println("\n"+ user.getEmail() +"is bookmarking"); for(int
	 * i=0;i<DataStore.USER_BOOKMARK_LIMIT;i++) { int typeOffset =
	 * (int)Math.random()*DataStore.BOOKMARK_TYPES_COUNT; int bookmarkOffset =(int)
	 * (Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE); Bookmark bookmark =
	 * bookmarks[typeOffset][bookmarkOffset];
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 * System.out.println(bookmark); } }
	 */

	public static void browse(User user, List<List<Bookmark>> bookmarks) {
		System.out.println("\n" + user.getEmail() + "is browsing items");
		int bookmakCount = 0;
		for (List bookmarkList : bookmarks) {
			Iterator<Bookmark> bookmark= bookmarkList.iterator();
			while(bookmark.hasNext()) {
				Bookmark bookmarkItem=bookmark.next();
				if (bookmakCount < DataStore.USER_BOOKMARK_LIMIT) {
					
					boolean isBookmarked = getBookmarkDecision(bookmarkItem);
					if (isBookmarked) {
						bookmakCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmarkItem);
						System.out.println("New item book marked  ----" + bookmarkItem);
					}
				}
				// kid friendly eligible
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if (bookmarkItem.isKidfriendlyEligible()
							&& bookmarkItem.getKidFriendlyStatus().equals(KidFrindlyStatus.UNKNOWN)) {
					String kidFriendlyStatusDecision =	getKidFriendlyMakeDecision(bookmarkItem);
					
					if(!kidFriendlyStatusDecision.equals(KidFrindlyStatus.UNKNOWN)) {
						BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatusDecision,bookmarkItem);
						
						
						
						
					}
					}
					
					if(bookmarkItem.getKidFriendlyStatus().equals(KidFrindlyStatus.APPROVED) && bookmarkItem instanceof Shareable) {
						boolean isShared= makeShareDecision() ;
						if(isShared) {
							BookmarkController.getInstance().share(user,bookmarkItem);
						}
						
					}
					
					
				}
			}
		}

	}

	private static boolean makeShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}

	private static String getKidFriendlyMakeDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFrindlyStatus.APPROVED
				: Math.random() >= 0.4 && Math.random() < 0.8 ? KidFrindlyStatus.REJECTED : KidFrindlyStatus.UNKNOWN;

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}

}
