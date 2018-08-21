package matchi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Matchi {

	private WebDriver driver;
	private String baseUrl;

	public Matchi() {
		baseUrl = "https://beta1.matchi.se/";
		String user = System.getProperty("user.name");
		System.setProperty("webdriver.chrome.driver", "C:/Users/" + user + "/eclipse-workspace/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	public void search(String name) {
	    driver.findElement(By.id("q")).clear();
	    driver.findElement(By.id("q")).sendKeys(name);
	    driver.findElement(By.name("submit")).click();
	    
	}
	public void booking() {
		driver.get("http://beta1.matchi.se");
	}
	public void payment() {
		driver.get("http://beta1.matchi.se");
	}
	public void logout() {
	    driver.findElement(By.xpath("//img[contains(@src,'https://beta1.matchi.se//images/avatar_default.png')]")).click();
	    driver.findElement(By.linkText("Logga ut")).click();
	}
	public void quit() {
	driver.quit();
	}
}