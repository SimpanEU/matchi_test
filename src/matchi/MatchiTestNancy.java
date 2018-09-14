package matchi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MatchiTestNancy {
	
	private Matchi matchi = new Matchi();
	
	@Test
	public void test2() {
		/*
		// Loggar in med ogiltig data SQL injection
		matchi.login("'OR' '='", "'OR' '='");
		assertEquals(matchi.driver.getPageSource().contains("Logga in"), true);
		matchi.logout();
		
		// Glömt lösenord har bug
		matchi.forgetPassword("x", "x");
		assertEquals(matchi.driver.getTitle().contains("Mjuk Varutestare"), true);
		matchi.logout();
		
		// Sökning oglitiga tecken
		matchi.search("----------");
		assertEquals(matchi.driver.getPageSource().contains("Inga anläggningar hittades"), true);
		matchi.logout();
	
		// Sökning oglitiga tecken
		matchi.search("**********");
		assertEquals(matchi.driver.getPageSource().contains("Inga anläggningar hittades"), true);
		matchi.logout();
		*/

		// Återställa sökningen 
		matchi.login("x", "x");
		matchi.refreshSearch();
		assertTrue(matchi.checkRefreshSearch("Välj sport"));;
		
		
	}
}
