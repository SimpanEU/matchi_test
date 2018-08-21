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
		matchi.login("mjukvarutestare4@mailinator.com", "mjukvarutestare");
		assertEquals(matchi.driver.getTitle().contains("Mjuk Varutestare"), true);
		matchi.search("H�n�");
		assertEquals(matchi.driver.getPageSource().contains("H�n� Tenniss�llskap"), true);
		matchi.bookFirstAvailable();
		assertEquals(matchi.driver.getPageSource().contains("Boka"), true);
		matchi.payWithCard("2223 0000 4841 0010", "MjukVarutestare", "10", "2020", "737");
		matchi.unbook();
		assertEquals(matchi.driver.getPageSource().contains("Inga kommande bokningar."), true);
		
		matchi.search("H�n�");
		matchi.bookFirstAvailable();
		matchi.payWithExistingCard();
		matchi.unbook();
		/*
		matchi.search("H�n�");
		matchi.bookFirstAvailable();
		matchi.payWithSwish();
		matchi.unbook();
		*/
		matchi.logout();
		assertEquals(matchi.driver.getTitle().contains("Community och onlinebokning f�r racketsport"), true);
		matchi.quit();
	}
}
