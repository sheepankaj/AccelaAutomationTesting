/**
 * 
 */
package com.accelatesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author mackbookpankaj
 *
 */
public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "logo")
	@CacheLookup
	WebElement websiteLogo;

	@FindBy(className = "currentprice currentpricenow")
	@CacheLookup
	WebElement productPriceClaasName;

	public static void TitleName(String urlTitle) {

		System.out.println("Homepage Logo is: " + urlTitle);
	}

}
