package com.accelatesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.accelatesting.pageObjects.SearchProducts;

public class TC_SearchProducts_002 extends BaseClass {

	@Test
	public void searchProducts() throws InterruptedException, IOException {
		SearchProducts sProd = new SearchProducts(driver);
		sProd.SearchField("Three Course Meal with Glass of Wine for Two at Prezzo");
		sProd.SearchButton();
		sProd.SearchProductByMenu();
		System.out.println("Search results displayed " + driver.getTitle());

		if (driver.getTitle().equals("Buyagift - Search Results")) {
			Assert.assertTrue(true);
			logger.info("OpenUrl test passed");
		} else {
			captureScreen(driver, "OpenUrl");
			Assert.assertTrue(false);
			logger.info("OpenUrl test failed");
		}
	}

}
