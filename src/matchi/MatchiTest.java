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
		
		// Söker, bokar och betalar med nytt betalningskort.
		matchi.search("Hönö");
		assertEquals(matchi.driver.getPageSource().contains("Hönö Tennissällskap"), true);
		matchi.bookFirstAvailable();
		assertEquals(matchi.driver.getPageSource().contains("Boka"), true);
		matchi.payWithCard("2223000048410010", "MjukVarutestare", "10", "2020", "737");
		assertEquals(matchi.driver.getPageSource().contains("Tack för din bokning!"), true);
		matchi.unbook();
		assertEquals(matchi.driver.getPageSource().contains("Inga kommande bokningar."), true);
		
		// Söker, bokar och betalar med befintligt sparat betalningskort.
		matchi.search("Hönö");
		matchi.bookFirstAvailable();
		assertEquals(matchi.driver.getPageSource().contains("Boka"), true);
		matchi.payWithExistingCard();
		assertEquals(matchi.driver.getPageSource().contains("Tack för din bokning!"), true);
		matchi.unbook();
		assertEquals(matchi.driver.getPageSource().contains("Inga kommande bokningar."), true);
		
		/*
		// Söker, bokar och betalar med swish.
		matchi.search("Hönö");
		matchi.bookFirstAvailable();
		matchi.payWithSwish("46701234567");
		matchi.unbook();
		*/
		
		// Loggar ut och stänger av.
		matchi.logout();
		assertEquals(matchi.driver.getTitle().contains("Community och onlinebokning för racketsport"), true);
		matchi.quit();
	}
}
