package com.nopcommerce.demo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.MyAccountObject;
import PageObjects.SearchObject;
import PageObjects.loginPageObject;
import common.BaseTest;

public class SearchPage extends BaseTest{
	WebDriver driver;
	SearchObject searchPage;
	String Password2 = "123456";
	String Email = "12345678@gmail.com";
	loginPageObject loginPage;
	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/";
		driver = getBrowserDriver(urlPage, browserName);
		searchPage = new SearchObject(driver);
		loginPage = new loginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void TC01_ErrorMessage() {
		searchPage.clickLogin();
		loginPage.inputTexbox(Email, "Email");
		loginPage.inputTexbox(Password2, "Password");
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.checkPageUrl("https://demo.nopcommerce.com/"));
		searchPage.clickSearch();
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.SearchError("Search term minimum length is 3 characters","warning"));
	}
	@Test
	public void TC02_NoProduct() {
		searchPage.input_SearchKeyword("Macbook Pro 2040");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.SearchError("No products were found that matched your criteria.","no-result"));
	}
	@Test
	public void TC03_Product() {
		searchPage.input_SearchKeyword("Lenovo");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isSearchProductTitleDisplayedOnPageAsExpected("Lenovo"));
	}
	@Test
	public void TC04_ParentCategori() {
		searchPage.input_SearchKeyword("Apple Macbook Pro");
		searchPage.clickAdvancedSearch();
		searchPage.enterToDropdownCategori("Computers");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.SearchError("No products were found that matched your criteria.","no-result"));
	}
	@Test
	public void TC05_SubCategori() {
//		searchPage.refeshCurrentPage(driver);
//		searchPage.input_SearchKeyword("Apple Macbook Pro");
//		searchPage.clickAdvancedSearch();
//		searchPage.enterToDropdownCategori("Computers");
		searchPage.clickAutomatically();
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.SubCategory("Apple MacBook Pro 13-inch"));
	}
}
