package com.accelatesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProductsToBasket {

	WebDriver ldriver;

	public SelectProductsToBasket(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@id='productlist-results']/a[@class='col-xs-6 col-md-4 productlist-product'][1]/div[@class='productlist-details']/h3[@class='producttitle']")
	@CacheLookup
	WebElement threeCourseMeal;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/div/section/div[1]/div[1]/div[2]/div[2]/div[3]/form/div/button")
	@CacheLookup
	WebElement buyButton;

	@FindBy(xpath = "//*[@id=\"basket_contents\"]/div/form/div/div/div[2]/div[2]/div/textarea")
	@CacheLookup
	WebElement personalizedMessageField;

	@FindBy(xpath = "//*[@id=\"basket_contents\"]/div/form/div/div/div[2]/div[1]/div/div[3]/label")
	@CacheLookup
	WebElement EVoucherDeliveryMethod;

	@FindBy(xpath = "//*[@id=\"basket_payment_options\"]/a[1]/button")
	@CacheLookup
	WebElement paytoProceedButtonXpath;

	@FindBy(xpath = "//div[@class='step1_btns col-lg-offset-4']/button[@class='btn login_guest chk_btns']")
	@CacheLookup
	WebElement continueGuestButtonXpath;

	@FindBy(id = "account_email_field")
	@CacheLookup
	WebElement emailEnteringFieldID;

	public void SelectProduct() {
		threeCourseMeal.click();
	}

	public void ClickBuyButton() {
		buyButton.click();
	}

	public void WriteMessage(String wMessage) {

		personalizedMessageField.sendKeys(wMessage);
	}

	public void SelectDeliveryMethod() {
		EVoucherDeliveryMethod.click();
	}

	public void VerifyProccedToPayButton() {
		paytoProceedButtonXpath.click();
	}

	public void VerifyGuestButton() {
		continueGuestButtonXpath.click();
	}

	public void VerifyEmailField(String eField) {
		emailEnteringFieldID.sendKeys(eField);
	}

}
