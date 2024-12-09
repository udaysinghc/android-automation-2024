package com.example.testcases;

import org.testng.annotations.Test;

import com.example.generalstoreapp.BaseClass;
import com.example.locators_pages.AddToCart_Locators;

public class AddToCart_T01 extends BaseClass {

	AddToCart_Locators addToCartLoc = new AddToCart_Locators(driver);

	@Test(priority = 1)
	public void ecommerceTest() {
		System.out.println("Priority = 1");
//		logger = extent.createTest("ecommerceTest"); 
//	    logger.info("Test started: ecommerceTest");
//	    logger.info("Entering username: Kriti");
		addToCartLoc.enterUsername("Kriti");
//		logger.pass("Username entered successfully");
		
//		logger.info("Hiding keyboard");
		driver.hideKeyboard();
//		logger.pass("Keyboard hidden successfully");
		addToCartLoc.clickRadioButton();
		addToCartLoc.letsShopCTA();
	}
}
