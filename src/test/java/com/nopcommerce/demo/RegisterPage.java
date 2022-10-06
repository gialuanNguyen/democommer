package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import PageObjects.RegisterPageObject;
import Util.DataHelper;
import common.BaseTest;

public class RegisterPage extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	String firstName = "luann";
	String lastName = "luanng";
	String email = "luan111111@gmail.com";
	String password = "123456";
	String cfpassword = "123456";
	DataHelper data;
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(urlPage,browserName);
		registerPage = new RegisterPageObject(driver);
		data =DataHelper.getData();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_RegisterWithEmptyData() {
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkErrorMessage("FirstName", "First name is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("LastName", "Last name is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("Email", "Email is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("Password", "Password is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("ConfirmPassword", "Password is required."));

	}

	@Test
	public void TC_02_invalidEmail() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterToTextBox("123456", "Email");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkErrorMessage("Email", "Wrong email"));
		sleepInSecond(3);

	}

	@Test
	public void TC_03_RegisComplete() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterToTextBox(firstName, "FirstName");
		registerPage.enterToTextBox(lastName, "LastName");
		registerPage.enterToTextBox(email, "Email");
		registerPage.enterToTextBox(password, "Password");
		registerPage.enterToTextBox(cfpassword, "ConfirmPassword");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.regisComplete("Your registration completed"));
		registerPage.clickToLogoutButton();
	}

	@Test
	public void TC_04_RegisComplete() {
		registerPage.clickToRegisterLink();
		registerPage.refeshCurrentPage(driver);
		registerPage.enterToTextBox(firstName, "FirstName");
		registerPage.enterToTextBox(lastName, "LastName");
		registerPage.enterToTextBox(email, "Email");
		registerPage.enterToTextBox(password, "Password");
		registerPage.enterToTextBox(cfpassword, "ConfirmPassword");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.emailExists("The specified email already exists"));

	}

	@Test
	public void TC_05_RegisterWithEmptyData() {
		registerPage.clickToRegisterLink();
		registerPage.enterToTextBox("1234", "Password");
		registerPage.enterToTextBox("123456", "ConfirmPassword");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.passMust("Password must meet the following rules:"));
		Assert.assertTrue(registerPage.passMust("must have at least 6 characters"));
	}

	@Test
	public void TC_06_RegisterWithEmptyData() {
		registerPage.clickToRegisterLink();
		registerPage.enterToTextBox("12345565", "Password");
		registerPage.enterToTextBox("123456", "ConfirmPassword");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.passNotMatch("The password and confirmation password do not match."));
		sleepInSecond(3);
	}
}
