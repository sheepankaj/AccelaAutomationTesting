package com.accelatesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillingPersonalDetailsFieldsPage {

	WebDriver ldriver;

	public FillingPersonalDetailsFieldsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "titlefield")
	@CacheLookup
	WebElement titleID;

	@FindBy(id = "firstnamefield")
	@CacheLookup
	WebElement firstNameID;

	@FindBy(id = "lastnamefield")
	@CacheLookup
	WebElement lastNameID;

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

	public void VerifyTitle() {
		titleID.click();
		titleID.sendKeys("Mr.");
	}

	public void VerifyFirstName() {
		firstNameID.sendKeys("John");
	}

	public void VerifyLastName() {
		lastNameID.sendKeys("Kelly");
	}

}
