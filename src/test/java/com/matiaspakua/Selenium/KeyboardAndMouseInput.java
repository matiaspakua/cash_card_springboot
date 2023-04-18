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
public class KeyboardAndMouseInput {

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
		driver.quit();
	}

	@Test
	public void given_EnterFormyProject_when_clickAndInput_then_success() {
		driver.get("https://formy-project.herokuapp.com/keypress");

		WebElement name = driver.findElement(By.id("name"));
		name.click();
		name.sendKeys("Meaghan Lewis");

		WebElement button = driver.findElement(By.id("button"));
		button.click();	

	}
}
