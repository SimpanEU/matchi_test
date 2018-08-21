package matchi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatchiTest {

	@Test
	public void test() {
		Matchi matchi = new Matchi();
		matchi.login("mjukvarutestare@mailinator.com", "mjukvarutestare");
		matchi.search("Hönö");
		matchi.booking();
		matchi.payment();
		matchi.logout();
		matchi.quit();
	}
}
