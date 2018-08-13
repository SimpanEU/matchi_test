package matchi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Matchi {

	private WebDriver webDriver;

	public Matchi() {
		String user = System.getProperty("user.name");
		System.setProperty("webdriver.chrome.driver", "C:/Users/" + user + "/eclipse-workspace/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
	}
	
	public void run() {
		webDriver.get("http://beta1.matchi.se");
	}

}