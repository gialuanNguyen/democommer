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
	String Email = "123456@gmail.com";
	String Password = " 1234123123";
	String Email2= "1234455@gmail.com";
	String Password2 ="123456";
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
	@Test
	public void TC_01_login() {
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.enterEmail("Please enter your email"));
		sleepInSecond(2);
	}
	@Test
	public void TC_02_wrongEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputTexbox("123456", "Email");
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.wrongEmail("Wrong email"));
	}
	@Test
	public void TC_03_loginunsuccessfull() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputTexbox(Email2, "Email");
		loginPage.inputTexbox(Password, "Password");
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.loginUnsuccess("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.loginUnsuccess("No customer account found"));
	}
	@Test
	public void TC_04_loginNopassword() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputTexbox(Email, "Email");
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.loginUnsuccess("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.loginUnsuccess("The credentials provided are incorrect"));
	}
	@Test
	public void TC_05_loginpasswordError() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputTexbox(Email, "Email");
		loginPage.inputTexbox(Password, "Password");
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.loginUnsuccess("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.loginUnsuccess("The credentials provided are incorrect"));
	}
	@Test
	public void TC_06_loginSuccess() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputTexbox(Email, "Email");
		loginPage.inputTexbox(Password2, "Password");
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.homePage("Welcome to our store"));
		;
	}
}
