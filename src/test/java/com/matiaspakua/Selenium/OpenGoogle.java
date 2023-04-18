package com.matiaspakua.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(Lifecycle.PER_CLASS)
public class OpenGoogle {

	private WebDriver driver;

	@BeforeAll
	public void setup() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		// Set the property for webdriver.chrome.driver to be the location to your local
		// download of chromedriver

		System.setProperty("webdriver.chrome.driver", "C:\\WedDrivers\\chromedriver.exe");

		// Create new instance of ChromeDriver
		driver = new ChromeDriver(options);

	}

	@AfterAll
	public void tearDown() {		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	@Test
	public void testLogin() {

		// And now use this to visit Google
		driver.get("https://www.google.com/");

		// Find the text input element by its name WebElement
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Cheese!");

		// Now submit the form
		element.submit();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
