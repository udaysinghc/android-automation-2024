package com.example.locators_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.generalstoreapp.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class AddToCart_Locators extends BaseClass {

//	public WebDriver driver;

	private By usernameField = By.id("com.androidsample.generalstore:id/nameField");
	private By femaleRadioButton = By.id("com.androidsample.generalstore:id/radioFemale");
	private By letsShopButton = By.id("com.androidsample.generalstore:id/btnLetsShop");

	// Constructor
//	public AddToCart_Locators(WebDriver driver) {
//		this.driver = driver;
//	}

	public AddToCart_Locators(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// Actions
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void clickRadioButton() {
		driver.findElement(femaleRadioButton).click();
	}

	public void letsShopCTA() {
		driver.findElement(letsShopButton).click();
	}

}
