package com.accelatesting.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accelatesting.pageObjects.SearchProducts;
import com.accelatesting.pageObjects.SelectProductsToBasket;

public class TC_SelectProducttoBasket_003 extends BaseClass {

	@Test
	public void AddProductToBasket() throws InterruptedException {
		SearchProducts sProd = new SearchProducts(driver);
		sProd.SearchField("Three Course Meal with Glass of Wine for Two at Prezzo");
		sProd.SearchButton();
		System.out.println("Search results displayed");

		SelectProductsToBasket buyproduct = new SelectProductsToBasket(driver);
		buyproduct.SelectProduct();
		logger.info("Three course meal clicked");
		Thread.sleep(5000);
		buyproduct.ClickBuyButton();
		System.out.println("Product add to basket");

	}

	@Test(dependsOnMethods = { "AddProductToBasket" })
	public void WritePersonalizedMessage() throws IOException {
		SelectProductsToBasket wrtMessage = new SelectProductsToBasket(driver);
		wrtMessage.WriteMessage("Lunch meal for group");
		System.out.println("Personalized message wrote");
		logger.info("Personalized message wrote");
		WebElement textMessage = driver
				.findElement(By.xpath("//*[@id=\"basket_contents\"]/div/form/div/div/div[2]/div[2]/span"));
		String message = textMessage.getText();

		if (message.contains("Add a personalised message")) {
			Assert.assertTrue(true);
			logger.info("Wrote message test passed");
		} else {
			captureScreen(driver, "PersonalizedMessage");
			Assert.assertTrue(false);
			logger.info("Wrote message test failed");
		}

	}

	@Test
	public void DeliveryMethod() throws InterruptedException, IOException {
		SelectProductsToBasket delivery = new SelectProductsToBasket(driver);
		delivery.SelectDeliveryMethod();
		System.out.println("E-Voucher delivery method selected");
		Thread.sleep(3000);
		WebElement textelement = driver.findElement(By.xpath("//*[@id=\"page_introduction\"]/h1"));
		String text = textelement.getText();

		if (text.contains("Your Basket")) {
			Assert.assertTrue(true);
			logger.info("DeliveryMethod test passed");
		} else {
			captureScreen(driver, "DeliveryMethod");
			Assert.assertTrue(false);
			logger.info("DeliveryMethod test failed");
		}

	}

	@Test
	public void FreeDelivery() throws IOException, InterruptedException {
		WebElement deliveryfree = driver
				.findElement(By.xpath("//*[@id=\"basket_summary\"]/div/div[1]/div[4]/div/div[4]/div[2]/span[2]"));
		String textdelivery = deliveryfree.getText();
		System.out.println(textdelivery);
		Thread.sleep(5000);
		if (textdelivery.contains("£0.00")) {
			Assert.assertTrue(true);
			System.out.println("Delivery is free and Payment option is E-Voucher selected");
		} else {
			captureScreen(driver, "FreeDelivery");
			Assert.assertTrue(false);
			System.out.println("Delivery is not free and Payment option is not E-Voucher selected.");
		}
	}

}
