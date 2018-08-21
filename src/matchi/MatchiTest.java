package matchi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatchiTest {

	@Test
	public void test1() {
		Matchi matchi = new Matchi();
		matchi.login("mjukvarutestare4@mailinator.com", "mjukvarutestare");
		matchi.search("Hönö");
		matchi.bookFirstAvailable();
		matchi.payWithCard("2223 0000 4841 0010", "MjukVarutestare", "10", "2020", "737");
		matchi.unbook();
		
		matchi.search("Hönö");
		matchi.bookFirstAvailable();
		matchi.payWithExistingCard();
		matchi.unbook();
		/*
		matchi.search("Hönö");
		matchi.bookTime(22);
		matchi.payWithSwish();
		matchi.unbook();
		*/
		matchi.logout();
		matchi.quit();
	}
}
