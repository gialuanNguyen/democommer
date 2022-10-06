package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.RegisterPageObject;
import PageObjects.loginPageObject;
import common.BasePage;
import common.BaseTest;
import common.GlobalContain;

public class TS_00_Precodition extends BaseTest{
	WebDriver driver;
	RegisterPageObject registerPage;
	String firstName = "luann";
	String lastName = "luanng";
	String email = GlobalContain.USER_NAME;
	String password = GlobalContain.PASSWORD;
	String cfpassword = GlobalContain.PASSWORD;
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(urlPage,browserName);
		registerPage = new RegisterPageObject(driver);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void creatAccount() {
		registerPage.enterToTextBox(firstName, "FirstName");
		registerPage.enterToTextBox(lastName, "LastName");
		registerPage.enterToTextBox(email, "Email");
		registerPage.enterToTextBox(password, "Password");
		registerPage.enterToTextBox(cfpassword, "ConfirmPassword");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.regisComplete("Your registration completed"));
	}
	
}
