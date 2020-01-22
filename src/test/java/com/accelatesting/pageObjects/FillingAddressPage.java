package com.accelatesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillingAddressPage {

	WebDriver ldriver;

	public FillingAddressPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id=\"guest_personal_details\"]/div[2]/button")
	@CacheLookup
	WebElement continuebuttonXpath;

	@FindBy(id = "billingPostcode")
	@CacheLookup
	WebElement postCodeID;

	@FindBy(xpath = "//*[@id=\"postCodeSearchBilling\"]/div/div[2]/div[2]/button")
	@CacheLookup
	WebElement searchButtonXpath;

	@FindBy(xpath = "//*[@id=\"new_card_selectaddress\"]/ul/li[2]/div/div/div/div/div[5]/div/input")
	@CacheLookup
	WebElement countyFieldXpath;

	public void VerifyContinueButton() {
		continuebuttonXpath.click();
	}

	public void VerifyPostCodeField() {
		postCodeID.sendKeys("WC2N 5DU");
	}

	public void VerifySearchButton() {
		searchButtonXpath.click();
	}

	public void VerifyCountyField() {
		countyFieldXpath.sendKeys("Greater London");
	}

}
