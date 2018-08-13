package matchi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

public class MATCHi {

	private WebDriver webDriver;

	public void MATCHi() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/garyh/Desktop/selenium-java-3.8.1/chromedriver.exe");
		WebElement element = webDriver.findElement(By.xpath(""));
		element.sendKeys("res1");
		WebElement element2 = webDriver.findElement(By.id("learn"));
		element2.click();

	}

}
