package com.santosh.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.santosh.constants.MovieGenre;
import com.santosh.manager.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidfriendlyEligible() {
		// test1. genre is gay and lesbian  --> kidfrindly is false
		Movie movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.GAY_AND_LESBIAN,8.5);
		boolean isKidFrindly=movie.isKidfriendlyEligible();
		assertFalse("for gay and lesbine genre isKidfriendly should retun false", isKidFrindly);
		// test2 genre is horror  -->kidfriendly is false
		 movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.HORROR,8.5);
		 isKidFrindly=movie.isKidfriendlyEligible();
		assertFalse("for horror genre isKidfriendly should retun false", isKidFrindly);
		
		// test3. genre is horror  -->kidfriendly is false
		 movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.THRILLERS,8.5);
		 isKidFrindly=movie.isKidfriendlyEligible();
		assertFalse("for horror genre isKidfriendly should retun false", isKidFrindly);
		
		
		// test4. title is porn  ->kidfrindly is false
		movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane porn","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.HORROR,8.5);
		 isKidFrindly=movie.isKidfriendlyEligible();
			assertFalse("if title contains forn isKidfrindly should retun false", isKidFrindly);
		
	}

}
