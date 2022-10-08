package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePageObject;
import PageObjects.MyAccountObject;
import PageObjects.loginPageObject;
import common.BaseTest;
import com.nopcommerce.demo.loginPage;

public class MyAccount extends BaseTest {
	WebDriver driver;
	MyAccountObject myAccount;
	String Password2 = "123456";
	String Email = "1234567@gmail.com";
	String Password = "1234567";
	loginPageObject loginPage;
	HomePageObject homePage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/";
		driver = getBrowserDriver(urlPage, browserName);
		myAccount = new MyAccountObject(driver);
		loginPage = new loginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC01_textBoxToPrepare() {
		myAccount.clickLogin();
		loginPage.inputTexbox(Email, "Email");
		loginPage.inputTexbox(Password2, "Password");
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.checkPageUrl("https://demo.nopcommerce.com/"));
		myAccount.clickMyaccountButton();
		myAccount.inputGender();
		myAccount.input_prepare("123", "FirstName");
		myAccount.input_prepare("12", "LastName");
		myAccount.enterToDropdown("7", "DateOfBirthDay");
		myAccount.enterToDropdown("April", "DateOfBirthMonth");
		myAccount.enterToDropdown("1996", "DateOfBirthYear");
		myAccount.clickSaveButton();
		sleepInSecond(2);
		Assert.assertEquals(myAccount.getAttributeMyAccount("value", "FirstName"), "123");
		Assert.assertEquals(myAccount.getAttributeMyAccount("value", "LastName"), "12");
		sleepInSecond(2);
		myAccount.clickAddresses();
	}

	@Test
	public void TC02_Addresses() {
		myAccount.clickAddNew();
		myAccount.input_Addresses("luan", "FirstName");
		myAccount.input_Addresses("nguyen", "LastName");
		myAccount.input_Addresses("luan@gmail.com", "Email");
		myAccount.input_Addresses("tnhh 1 thanh vien", "Company");
		myAccount.enterToDropdownAddresses("Viet Nam");
		myAccount.input_Addresses("HCM", "City");
		myAccount.input_Addresses("854/47", "Address1");
		myAccount.input_Addresses("854/47/17", "Address2");
		myAccount.input_Addresses("000114", "ZipPostalCode");
		myAccount.input_Addresses("090457247", "PhoneNumber");
		myAccount.clickAddressesSaveButton();
		sleepInSecond(2);
		Assert.assertTrue(myAccount.checkAddresses("luan nguyen", "name"));
		Assert.assertTrue(myAccount.checkAddresses("Email: luan@gmail.com", "email"));
		Assert.assertTrue(myAccount.checkAddresses("Phone number: 090457247", "phone"));
		Assert.assertTrue(myAccount.checkAddresses("Fax number:", "fax"));
		Assert.assertTrue(myAccount.checkAddresses("tnhh 1 thanh vien", "company"));
		Assert.assertTrue(myAccount.checkAddresses("854/47", "address1"));
		Assert.assertTrue(myAccount.checkAddresses("854/47/17", "address2"));
		Assert.assertTrue(myAccount.checkAddresses("HCM, 000114", "city-state-zip"));
		Assert.assertTrue(myAccount.checkAddresses("Viet Nam", "country"));
		myAccount.clickChangePassword();
	}

	@Test
	public void TC03_changePassword() {
		myAccount.input_ChangePassword(Password2, "OldPassword");
		myAccount.input_ChangePassword(Password2, "NewPassword");
		myAccount.input_ChangePassword(Password2, "ConfirmNewPassword");
		myAccount.clickChangePasswordButton();
		Assert.assertTrue(myAccount.checkChangePasswordFail(
				"You entered the password that is the same as one of the last passwords you used. Please create a new password."));
		myAccount.input_ChangePassword(Password2, "OldPassword");
		myAccount.input_ChangePassword(Password, "NewPassword");
		myAccount.input_ChangePassword(Password, "ConfirmNewPassword");
		myAccount.clickChangePasswordButton();
		Assert.assertTrue(myAccount.checkChangePasswordSuccess("Password was changed"));
		myAccount.clickLogOut();
		Assert.assertEquals(loginPage.getPageUrl(driver), "https://demo.nopcommerce.com/cart");
		homePage.clickLogin();
		loginPage.inputTexbox(Email, "Email");
		loginPage.inputTexbox(Password2, "Password");
		loginPage.refeshCurrentPage(driver);
		loginPage.clickTologinButton();
		Assert.assertTrue(loginPage.loginUnsuccess("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.loginUnsuccess("The credentials provided are incorrect"));
		loginPage.inputTexbox(Email, "Email");
		loginPage.inputTexbox(Password, "Password");
	}

}
