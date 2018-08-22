package matchi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MatchiTest {
	
	private Matchi matchi = new Matchi();
	
	@Test
	public void test1() {
		// Loggar in med giltig data
		matchi.login("mjukvarutestare4@mailinator.com", "mjukvarutestare");
		assertEquals(matchi.driver.getTitle().contains("Mjuk Varutestare"), true);
		
		// S�ker, bokar och betalar med nytt betalningskort.
		matchi.search("H�n�");
		assertEquals(matchi.driver.getPageSource().contains("H�n� Tenniss�llskap"), true);
		matchi.bookFirstAvailable();
		assertEquals(matchi.driver.getPageSource().contains("Boka"), true);
		matchi.payWithCard("2223000048410010", "MjukVarutestare", "10", "2020", "737");
		assertEquals(matchi.driver.getPageSource().contains("Tack f�r din bokning!"), true);
		matchi.unbook();
		assertEquals(matchi.driver.getPageSource().contains("Inga kommande bokningar."), true);
		
		// S�ker, bokar och betalar med befintligt sparat betalningskort.
		matchi.search("H�n�");
		matchi.bookFirstAvailable();
		assertEquals(matchi.driver.getPageSource().contains("Boka"), true);
		matchi.payWithExistingCard();
		assertEquals(matchi.driver.getPageSource().contains("Tack f�r din bokning!"), true);
		matchi.unbook();
		assertEquals(matchi.driver.getPageSource().contains("Inga kommande bokningar."), true);
		
		/*
		// S�ker, bokar och betalar med swish.
		matchi.search("H�n�");
		matchi.bookFirstAvailable();
		matchi.payWithSwish("46701234567");
		matchi.unbook();
		*/
		
		// Loggar ut och st�nger av.
		matchi.logout();
		assertEquals(matchi.driver.getTitle().contains("Community och onlinebokning f�r racketsport"), true);
		matchi.quit();
	}
}
