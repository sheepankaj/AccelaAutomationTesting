package com.accelatesting.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accelatesting.pageObjects.SearchProducts;
import com.accelatesting.pageObjects.SelectProductsToBasket;

public class TC_VerifyProductPriceAtBasket_004 extends BaseClass {

	@Test
	public void VerifyProductPriceOfBasket() throws InterruptedException {

		SearchProducts sProd = new SearchProducts(driver);
		sProd.SearchField("Three Course Meal with Glass of Wine for Two at Prezzo");
		sProd.SearchButton();
		System.out.println("Search results displayed");
		Thread.sleep(2000);

		SelectProductsToBasket clickPayButton = new SelectProductsToBasket(driver);
		clickPayButton.SelectProduct();
		Thread.sleep(2000);
		System.out.println("Product Selected");
		WebElement productPrice = driver.findElement(By.id("product-price-current"));
		String price = productPrice.getText();
		System.out.println(price);
		Thread.sleep(2000);
		driver.findElement(By.id("bag-modal-close")).click();
		clickPayButton.ClickBuyButton();

		WebElement basketPrice = driver
				.findElement(By.xpath("//*[@id=\"basket_contents\"]/div/form/div/div/div[1]/div[6]/div[2]/span"));
		String bPrice = basketPrice.getText();
		System.out.println(bPrice);
		Assert.assertEquals(price, bPrice);
		System.out.println("The product price matched");

	}

}
