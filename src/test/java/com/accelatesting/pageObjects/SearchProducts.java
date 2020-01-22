package com.accelatesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchProducts {

	WebDriver ldriver;

	public SearchProducts(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.ID, using = "search-field")
	@CacheLookup
	WebElement searchField;

	@FindBy(how = How.ID, using = "magnifier-search")
	@CacheLookup
	WebElement searchButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"productlist-results\"]/a[1]/div[2]/h3")
	@CacheLookup
	WebElement selectProduct;

	@FindBy(xpath = "//*[@id=\"theMenu\"]/ul/li[5]/a")
	@CacheLookup
	WebElement selectProductByMenu;

	public void SearchField(String sField) {
		searchField.sendKeys(sField);
	}

	public void SearchProductByMenu() {
		selectProductByMenu.click();

	}

	public void SearchButton() {
		searchButton.click();
	}
}
