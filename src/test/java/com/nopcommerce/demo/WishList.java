package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePageObject;
import PageObjects.MyAccountObject;
import PageObjects.WishListObject;
import PageObjects.loginPageObject;
import common.BaseTest;

public class WishList extends BaseTest{
	WebDriver driver;
	WishListObject WishList;
	loginPageObject loginPage;
	String Password2 = "123456";
	String Email = "123456@gmail.com";
	HomePageObject homePage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/";
		driver = getBrowserDriver(urlPage, browserName);
		WishList = new WishListObject(driver);
		loginPage = new loginPageObject(driver);
		homePage = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void TC01_AddToWishLish() {
		homePage.clickLogin();
		loginPage.inputTexbox(Email, "Email");
		loginPage.inputTexbox(Password2, "Password");
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.checkPageUrl("https://demo.nopcommerce.com/"));
		homePage.input_SearchKeyword("lenovo");
		homePage.clickSearchButton();
		WishList.clickProduct("Lenovo IdeaCentre 600 All-in-One PC");
		WishList.clickAddtoWishList();
		Assert.assertTrue(WishList.checkAddToWishList("The product has been added to your "));
		WishList.clickClose();	
		sleepInSecond(3);
	}
	@Test
	public void TC02_AddToCart() {
		homePage.clickWishList();
		WishList.clickAddToCart();
		WishList.clickAddToCartButton();
		Assert.assertTrue(WishList.checkShopcart("Lenovo IdeaCentre 600 All-in-One PC"));
		homePage.clickWishList();
		Assert.assertTrue(WishList.noProductWishList("The wishlist is empty!"));
		
	}
}
