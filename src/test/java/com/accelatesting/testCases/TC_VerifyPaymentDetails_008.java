package com.accelatesting.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.accelatesting.pageObjects.FillingAddressPage;
import com.accelatesting.pageObjects.FillingPersonalDetailsFieldsPage;
import com.accelatesting.pageObjects.PaymentDetailsPage;
import com.accelatesting.pageObjects.SearchProducts;
import com.accelatesting.pageObjects.SelectProductsToBasket;

public class TC_VerifyPaymentDetails_008 extends BaseClass {

	@Test
	public void PaymentDetails() throws InterruptedException, IOException {
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

		clickPayButton.VerifyGuestButton();
		Thread.sleep(3000);

		FillingPersonalDetailsFieldsPage pField = new FillingPersonalDetailsFieldsPage(driver);
		pField.VerifyTitle();
		pField.VerifyFirstName();
		pField.VerifyLastName();

		FillingAddressPage faddress = new FillingAddressPage(driver);
		faddress.VerifyContinueButton();
		Thread.sleep(3000);
		faddress.VerifyPostCodeField();
		faddress.VerifySearchButton();
		Thread.sleep(3000);
		faddress.VerifyCountyField();
		Thread.sleep(1000);

		PaymentDetailsPage payment = new PaymentDetailsPage(driver);
		payment.VerifyCardHolderName();
		payment.VerifyCardNumber();
		payment.VerifyExpiryMonth();
		payment.VerifyExpiryYear();
		payment.VerifyCVVNumber();
		payment.VerifyPlaceOrderButton();
		Thread.sleep(4000);

		WebElement inValidValue = driver.findElement(By.xpath("//div[1]/span[@class='error ng-binding ng-scope']"));
		String inValidTCardText = inValidValue.getText();
		// System.out.println(inValidTCardText);
		if (inValidTCardText.equals(inValidValue)) {
			Assert.assertTrue(true);
			System.out.println("Invalid card details");
		} else {
			captureScreen(driver, "InValidCardDetailsPage");
			Assert.assertTrue(false);
			System.out.println("Nothing found");
		}

	}
}
