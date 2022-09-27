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

	// @Test
	public void TC_02_invalidEmail() {
		registerPage.getElement(driver, "//input[@name='Email']").sendKeys("12345");
		sleepInSecond(3);
		registerPage.clickToRegisterButton();
		sleepInSecond(3);
		Assert.assertTrue(registerPage.checkEmailWrongMessage("Wrong email"));
		sleepInSecond(3);
	}

	// @Test
	public void TC_03_RegisComplete() {
		registerPage.clickToElement(driver, "//span[@class='male']");
		registerPage.getElement(driver, " //input[@name='FirstName']").sendKeys("luan");
		registerPage.getElement(driver, " //input[@name='LastName']").sendKeys("nguyen");
		registerPage.clickToElement(driver, "//select[@name='DateOfBirthDay']/option[9]");
		registerPage.clickToElement(driver, "//select[@name='DateOfBirthMonth']/option[11]");
		registerPage.clickToElement(driver, "//select[@name='DateOfBirthYear']/option[86]");
		registerPage.getElement(driver, " //input[@name='Email']").sendKeys("12345678@gmail.com");
		registerPage.getElement(driver, " //input[@id='Password']").sendKeys("123456");
		registerPage.getElement(driver, " //input[@id='ConfirmPassword']").sendKeys("123456");
		sleepInSecond(3);
		registerPage.clickToRegisterButton();
		sleepInSecond(3);
		Assert.assertTrue(registerPage.regisComplete("Your registration completed"));
		sleepInSecond(3);

	}

	// @Test
	public void TC_04_RegisComplete() {
		registerPage.clickToElement(driver, "//span[@class='male']");
		registerPage.getElement(driver, " //input[@name='FirstName']").sendKeys("ln");
		registerPage.getElement(driver, " //input[@name='LastName']").sendKeys("ngyen");
		registerPage.clickToElement(driver, "//select[@name='DateOfBirthDay']/option[9]");
		registerPage.clickToElement(driver, "//select[@name='DateOfBirthMonth']/option[11]");
		registerPage.clickToElement(driver, "//select[@name='DateOfBirthYear']/option[86]");
		registerPage.getElement(driver, " //input[@name='Email']").sendKeys("12345678@gmail.com");
		registerPage.getElement(driver, " //input[@id='Password']").sendKeys("123456");
		registerPage.getElement(driver, " //input[@id='ConfirmPassword']").sendKeys("123456");
		sleepInSecond(3);
		registerPage.clickToRegisterButton();
		sleepInSecond(3);
		Assert.assertTrue(registerPage.emailExists("The specified email already exists"));
		sleepInSecond(3);

	}

	//@Test
	public void TC_05_RegisterWithEmptyData() {
		registerPage.getElement(driver, " //input[@id='Password']").sendKeys("123");
		registerPage.getElement(driver, " //input[@id='ConfirmPassword']").sendKeys("123456");
		sleepInSecond(3);
		Assert.assertTrue(registerPage.passMust("Password must meet the following rules:"));
		Assert.assertTrue(registerPage.passleast("must have at least 6 characters"));
		sleepInSecond(3);
	}
	@Test
	public void TC_06_RegisterWithEmptyData() {
		registerPage.getElement(driver, " //input[@id='Password']").sendKeys("123456");
		registerPage.getElement(driver, " //input[@id='ConfirmPassword']").sendKeys("123451231367");
		registerPage.clickToRegisterButton();
		sleepInSecond(3);
		Assert.assertTrue(registerPage.passNotMatch("The password and confirmation password do not match."));
		sleepInSecond(3);
	}
}
