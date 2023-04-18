package com.matiaspakua.Selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

@TestInstance(Lifecycle.PER_CLASS)
public class ScrollToElement {
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

		driver.manage().window().maximize();
	}

	@AfterEach
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

	@Test
	public void given_pageWithLotsOfText_when_moveToElement_then_inputDataSuccess() {

		driver.get("https://formy-project.herokuapp.com/scroll");
		
		WebElement name = driver.findElement(By.id("name"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(name);
		
		name.sendKeys("Matias Miguez");
		
		WebElement date = driver.findElement(By.id("date"));
		
		date.sendKeys("17/03/1985");
	}

}
