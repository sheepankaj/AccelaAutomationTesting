package com.accelatesting.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HomePage_001 extends BaseClass {

	@Test
	public void OpenUrl() throws IOException {

		logger.info("Url is opened");

		if (driver.getTitle().equals("Buyagift | Experience Days | Gift Experiences")) {

			Assert.assertTrue(true);
			logger.info("OpenUrl test passed");
		} else {
			captureScreen(driver, "OpenUrl");
			Assert.assertTrue(false);
			logger.info("OpenUrl test failed");
		}

	}

	@Test
	public void VerifyEachProductPrice() {
		List<WebElement> EachProductPrice = driver.findElements(By.id("price-drop"));
		// System.out.println("Each Product Price is: " + EachProductPrice);
		for (WebElement price : EachProductPrice) {
			System.out.println("Each Product prices dispalyed :" + price.getText());
		}

	}
}
