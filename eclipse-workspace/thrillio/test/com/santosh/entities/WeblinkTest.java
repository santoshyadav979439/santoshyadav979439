package com.santosh.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.santosh.manager.BookmarkManager;

class WeblinkTest {

	@Test
	void testIsKidfriendlyEligible() {
		
		
		
		// test 1. porn in url -- false
		
		WebLink weblink=BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger", "Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		boolean isKidFrindlyEligible = weblink.isKidfriendlyEligible();
		assertFalse("For porn in url - iskidfriendly should be false",isKidFrindlyEligible);
		
		// test 2. porn in title --false
		 weblink=BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger p	orn", "Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFrindlyEligible = weblink.isKidfriendlyEligible();
		assertFalse("For porn in title - iskidfriendly should be false",isKidFrindlyEligible);
		
		// test 3. adult i n host --false
		 weblink=BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger", "Part 2",
					"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
					"http://www.adult.com");
			isKidFrindlyEligible = weblink.isKidfriendlyEligible();
			assertFalse("For adult in host - iskidfriendly should be false",isKidFrindlyEligible);
		
		// test 4. adult in url but not in host --true
			
			 weblink=BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger", "Part 2",
						"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
						"http://www.java.com");
				isKidFrindlyEligible = weblink.isKidfriendlyEligible();
				assertTrue("For adult in url - iskidfriendly should be true",isKidFrindlyEligible);	
		
		// test 5. adult in title only --true
				
				weblink=BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger adult", "Part 2",
						"http://www.javaworld.com/article/2072759/core-java/taming-fg--part-2.html",
						"http://www.java.com");
				isKidFrindlyEligible = weblink.isKidfriendlyEligible();
				assertTrue("For adult in title - iskidfriendly should be true",isKidFrindlyEligible);
	}

}
