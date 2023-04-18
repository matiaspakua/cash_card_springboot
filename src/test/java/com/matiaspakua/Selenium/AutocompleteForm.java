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
public class AutocompleteForm {

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
	public void given_aGenericForm_when_inputData_then_autocompleteSuccess() {
		driver.get("https://formy-project.herokuapp.com/autocomplete");

		WebElement autocomplete = driver.findElement(By.id("autocomplete"));
		
		autocomplete.sendKeys("1555 Park Blvr, Palo Alto, CA");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
		WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
		autocompleteResult.click();
	}
}
