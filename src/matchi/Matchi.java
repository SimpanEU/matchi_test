package matchi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Matchi {

	WebDriver driver;
	private String baseUrl;

	public Matchi() {
		baseUrl = "https://beta1.matchi.se/";
		String user = System.getProperty("user.name");
		System.setProperty("webdriver.chrome.driver", "C:/Users/" + user + "/eclipse-workspace/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void login(String user, String pass) {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Logga in")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	public void logout() {
		driver.findElement(By.linkText("Mjuk")).click();
		driver.findElement(By.linkText("Logga ut")).click();
	}

	public void search(String name) {
		driver.findElement(By.linkText("Boka")).click();
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(name);
		driver.findElement(By.name("submit")).click();
		sleep(1000);
	}

	public void bookFirstAvailable() {
		sleep(1000);
		driver.findElement(By.xpath("//ul[@class='list-inline no-margin']//li[1]//button[1]")).click();
		sleep(1000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/table[1]/tbody[1]/tr[1]/td[6]/a[1]")).click();
	}

	public void payWithCard(String cardnr, String name, String month, String year, String cvv) {
		sleep(1000);
		driver.findElement(By.xpath("//label[@for='CREDIT_CARD']")).click();
		driver.findElement(By.xpath("//form[@id='confirmForm']/div[2]/div[3]/div[2]/div[2]/div/label")).click();
		sleep(1000);
		driver.findElement(By.id("btnSubmit")).click();
		sleep(1000);
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(cardnr);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
		new Select(driver.findElement(By.xpath("//form[@id='adyen-encrypted-form']/div/div/div/div[2]/div[3]/select")))
				.selectByVisibleText(month);
		new Select(driver.findElement(By.id("expiryYear"))).selectByVisibleText(year);
		driver.findElement(By.xpath("(//input[@type='tel'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys(cvv);
		driver.findElement(By.cssSelector("input.btn.btn-success")).click();
		sleep(2500);
	}

	public void payWithExistingCard() {
		sleep(1000);
		driver.findElement(By.id("btnSubmit")).click();
		sleep(2500);
	}

	public void payWithSwish(String nr) {
		sleep(1000);
		driver.findElement(By.xpath("//label[@for='swish']")).click();
		sleep(1000);
		driver.findElement(By.id("btnSubmit")).click();
		sleep(3000);
		driver.findElement(By.xpath("//input[@id='swish.telephoneNumber']")).clear();
		driver.findElement(By.xpath("//input[@id='swish.telephoneNumber']")).sendKeys(nr);
		driver.findElement(By.xpath("//input[@id='mainSubmit']")).click();
		sleep(3000);
	}

	public void unbook() {
		driver.get(baseUrl + "profile/bookings");
		sleep(1000);
		driver.findElement(By.linkText("Avboka")).click();
		sleep(1000);
		driver.findElement(By.linkText("Avboka")).click();
		driver.findElement(By.id("cancelCloseBtn")).click();
		driver.get(baseUrl);
	}

	public void quit() {
		sleep(5000);
		driver.quit();
	}

	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}