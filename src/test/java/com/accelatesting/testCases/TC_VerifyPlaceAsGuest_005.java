package com.accelatesting.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accelatesting.pageObjects.SearchProducts;
import com.accelatesting.pageObjects.SelectProductsToBasket;

public class TC_VerifyPlaceAsGuest_005 extends BaseClass {

	@Test
	public void ProceedtoPay() throws InterruptedException, IOException {
		SearchProducts sProd = new SearchProducts(driver);
		sProd.SearchField("Three Course Meal with Glass of Wine for Two at Prezzo");
		sProd.SearchButton();
		System.out.println("Search results displayed");
		SelectProductsToBasket clickPayButton = new SelectProductsToBasket(driver);
		clickPayButton.SelectProduct();
		Thread.sleep(3000);
		clickPayButton.ClickBuyButton();
		System.out.println("Product add to basket");
		clickPayButton.WriteMessage("Lunch meal for group");
		clickPayButton.SelectDeliveryMethod();
		clickPayButton.VerifyProccedToPayButton();
		Thread.sleep(5000);
		clickPayButton.VerifyEmailField("testing@gmail.com");

		WebElement personalText = driver.findElement(By
				.xpath("//div[@class='ng-scope'][1]/section[@id='chk_step1']/h3[@class='step_ttl ng-binding active']"));
		String guestText = personalText.getText();

		if (guestText.contains("YOUR PERSONAL DETAILS")) {
			Assert.assertTrue(true);
			System.out.println("Proceed as Guest for placing the order");
		} else {
			captureScreen(driver, "ContinueAsGuestPage");
			Assert.assertTrue(false);
			System.out.println("Guest Button is not working");
		}
		clickPayButton.VerifyGuestButton();
		Thread.sleep(3000);
	}

}
