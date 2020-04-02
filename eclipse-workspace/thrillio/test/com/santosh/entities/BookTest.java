package com.santosh.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.santosh.constants.BookGenre;
import com.santosh.manager.BookmarkManager;

class BookTest {

	@Test
	void testIsKidfriendlyEligible() {
		// test 1.  genre is phyloshphy --> kidfriendly is false
		Book book=BookmarkManager.getInstance().createBook(4000,"Walden","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"},BookGenre.PHYLOSPHY,4.3);
		boolean isKidFriendly = book.isKidfriendlyEligible();
		assertFalse("for Phyloshphy genre kid frindly should be false", isKidFriendly);
		
		
		// test2 genre is self-help --> kidfirndly is false
		
		 book=BookmarkManager.getInstance().createBook(4000,"Walden","",1854,"Wilder Publications",new String[]{"Henry David Thoreau"},BookGenre.SELF_HELP,4.3);
		 isKidFriendly = book.isKidfriendlyEligible();
		assertFalse("for self-help genre kid frindly should be false", isKidFriendly);
		
	}

}
