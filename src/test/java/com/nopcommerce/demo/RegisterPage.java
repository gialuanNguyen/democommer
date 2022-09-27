package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.RegisterPageObject;
import common.BaseTest;

public class RegisterPage extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	String firstName="luann";
	String lastName="luanng";
	String email="luan1@gmail.com";
	String password="123456";
	String cfpassword="123456";
	@BeforeClass
	public void beforeClass() {
		String urlPage = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(urlPage);
		registerPage = new RegisterPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	// @Test
	public void TC_01_RegisterWithEmptyData() {
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkFirstnameErrorMessage("First name is required."));
		Assert.assertTrue(registerPage.checkLastnameErrorMessage("Last name is required."));
		Assert.assertTrue(registerPage.checkEmailErrorMessage("Email is required."));
		Assert.assertTrue(registerPage.checkPasswordErrorMessage("Password is required."));
		Assert.assertTrue(registerPage.checkConfirmPasswordErrorMessage("Password is required."));
		sleepInSecond(3);
	}

	 @Test
	public void TC_02_invalidEmail() {
		registerPage.enterToTextBoxEmail("123456");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkEmailErrorMessage("Wrong email"));
		sleepInSecond(3);
	}

	 @Test
	public void TC_03_RegisComplete() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterToTextBoxFirstName(firstName);
		registerPage.enterToTextBoxLastName(lastName);
		registerPage.enterToTextBoxEmail(email);
		registerPage.enterToTextBoxPassword(password);
		registerPage.enterToTextBoxConfirmPassword(cfpassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.regisComplete("Your registration completed"));
		registerPage.clickToLogoutButton();
	}

	@Test
	public void TC_04_RegisComplete() {
		registerPage.clickToRegisterLink();
		registerPage.refeshCurrentPage(driver);
		registerPage.enterToTextBoxFirstName(firstName);
		registerPage.enterToTextBoxLastName(lastName);
		registerPage.enterToTextBoxEmail(email);
		registerPage.enterToTextBoxPassword(password);
		registerPage.enterToTextBoxConfirmPassword(cfpassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.emailExists("The specified email already exists"));
		

	}

	@Test
	public void TC_05_RegisterWithEmptyData() {
		registerPage.clickToRegisterLink();
		registerPage.enterToTextBoxPassword("1234");
		registerPage.enterToTextBoxConfirmPassword("123456");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.passMust("Password must meet the following rules:"));
		Assert.assertTrue(registerPage.passMust("must have at least 6 characters"));
	}
	@Test
	public void TC_06_RegisterWithEmptyData() {
		registerPage.clickToRegisterLink();
		registerPage.enterToTextBoxPassword("12345565");
		registerPage.enterToTextBoxConfirmPassword("123456");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.passNotMatch("The password and confirmation password do not match."));
		sleepInSecond(3);
	}
}
