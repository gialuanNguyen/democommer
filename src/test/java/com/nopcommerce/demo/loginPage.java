package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.RegisterPageObject;
import PageObjects.loginPageObject;
import common.BaseTest;

public class loginPage extends BaseTest{
	WebDriver driver;
	loginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		String urlPage = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(urlPage);
		loginPage = new loginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	//@Test
	public void TC_01_login() {
		loginPage.clickTologinButton();
		sleepInSecond(2);
		Assert.assertTrue(loginPage.enterEmail("Please enter your email"));
		sleepInSecond(2);
	}
	//@Test
	public void TC_02_wrongEmail() {
		loginPage.getElement(driver, "//input[@id='Email']").sendKeys("12456");
		sleepInSecond(2);
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.wrongEmail("Wrong email"));
		sleepInSecond(2);
	}
	@Test
	public void TC_03_loginunsuccessfull() {
		loginPage.getElement(driver, "//input[@id='Email']").sendKeys("1246@gmail.com");
		loginPage.getElement(driver, "//input[@id='Password']").sendKeys("12312");
		sleepInSecond(2);
		loginPage.clickTologinButton();
		sleepInSecond(2);
		Assert.assertTrue(loginPage.loginUnsuccess("Login was unsuccessful. Please correct the errors and try again."));
		sleepInSecond(2);
		Assert.assertTrue(loginPage.noCustomer(" No customer account found"));
	}
}
