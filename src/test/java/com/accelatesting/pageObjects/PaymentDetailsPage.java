package com.accelatesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDetailsPage {

	WebDriver ldriver;

	public PaymentDetailsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "cardholdername")
	@CacheLookup
	WebElement cardholderNameID;

	@FindBy(id = "cardnumber")
	@CacheLookup
	WebElement cardNumberID;

	@FindBy(id = "expirymonth")
	@CacheLookup
	WebElement expiryMonthID;

	@FindBy(id = "expiryyear")
	@CacheLookup
	WebElement expiryYearID;

	@FindBy(id = "cvvnumber")
	@CacheLookup
	WebElement cvvNumberID;

	@FindBy(id = "btnPlaceOrderButton")
	@CacheLookup
	WebElement placeOrderButtonID;

	public void VerifyCardHolderName() {
		cardholderNameID.sendKeys("John Kelly");
	}

	public void VerifyCardNumber() {
		cardNumberID.sendKeys("644474747488");
	}

	public void VerifyExpiryMonth() {
		expiryMonthID.click();
		expiryMonthID.sendKeys("2");
	}

	public void VerifyExpiryYear() {
		expiryYearID.click();
		expiryYearID.sendKeys("2022");
	}

	public void VerifyCVVNumber() {
		cvvNumberID.sendKeys("200");
	}

	public void VerifyPlaceOrderButton() {
		placeOrderButtonID.click();
	}

}
