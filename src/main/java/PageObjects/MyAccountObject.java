package PageObjects;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;

import PageUI.LoginPageUI;
import PageUI.MyAccountUI;
import common.BasePage;

public class MyAccountObject extends BasePage {
	WebDriver driver;

	public MyAccountObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLogin() {
		waitForElementvisible(driver, MyAccountUI.CLICK_LOGIN);
		clickToElement(driver, MyAccountUI.CLICK_LOGIN);
	}

	public void clickMyaccountButton() {
		waitForElementvisible(driver, MyAccountUI.MYACCOUT_BUTTON);
		clickToElement(driver, MyAccountUI.MYACCOUT_BUTTON);
	}

	public void input_prepare(String value, String textbox) {
		waitForElementvisible(driver, MyAccountUI.INPUT_PREPARE, textbox);
		clickElementandsendKeys(driver, MyAccountUI.INPUT_PREPARE, value, textbox);

	}
	public String getValue(String value ,String textbox) {
		return getAttributeValue(driver, MyAccountUI.INPUT_PREPARE , value,textbox);
	}

	public void enterToDropdown(String value, String textbox) {
		selecDropdownByText(driver, MyAccountUI.SELECT_DROPDOWN, value, textbox);
	}

	public void clickSaveButton() {
		waitForElementvisible(driver, MyAccountUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountUI.SAVE_BUTTON);
	}

	public void inputGender() {
		waitForElementvisible(driver, MyAccountUI.INPUT_GENDER);
		clickToElement(driver, MyAccountUI.INPUT_GENDER);
	}

	public boolean checkInformation(String value, String textbox) {
		String errorMessage = getTextOfElement(driver, MyAccountUI.INPUT_PREPARE, textbox);
		return errorMessage.equals(value);
	}

	public void clickInformation(String textbox) {
		waitForElementvisible(driver, MyAccountUI.INPUT_PREPARE, textbox);
		clickToElement(driver, MyAccountUI.INPUT_GENDER, textbox);
	}

	public void clickInformation2(String textbox) {
		waitForElementvisible(driver, MyAccountUI.SELECT_DROPDOWN, textbox);
		clickToElement(driver, MyAccountUI.SELECT_DROPDOWN, textbox);
	}

	public void clickAddresses() {
		waitForElementvisible(driver, MyAccountUI.ADDRESSES_BUTTON);
		clickToElement(driver, MyAccountUI.ADDRESSES_BUTTON);
	}

	public void clickAddNew() {
		waitForElementvisible(driver, MyAccountUI.ADDNEW_BUTTON);
		clickToElement(driver, MyAccountUI.ADDNEW_BUTTON);
	}

	public void input_Addresses(String value, String textbox) {
		waitForElementvisible(driver, MyAccountUI.INPUT_ADDRESSES, textbox);
		clickElementandsendKeys(driver, MyAccountUI.INPUT_ADDRESSES, value, textbox);

	}

	public void enterToDropdownAddresses(String value) {
		selecDropdownByText(driver, MyAccountUI.SELECT_COUNTRY, value);
	}

	public boolean checkAddresses(String value, String textbox) {
		String errorMessage = getTextOfElement(driver, MyAccountUI.CHECK_ADDRESSES, textbox);
		return errorMessage.equals(value);
	}

	public void clickAddressesSaveButton() {
		waitForElementvisible(driver, MyAccountUI.ADDRESSES_SAVE_BUTTON);
		clickToElement(driver, MyAccountUI.ADDRESSES_SAVE_BUTTON);
	}

	public void deleteAddressesSaveButton() {
		waitForElementvisible(driver, MyAccountUI.DELETE_COUNTRY);
		clickToElement(driver, MyAccountUI.DELETE_COUNTRY);
	}

	public void clickChangePassword() {
		waitForElementvisible(driver, MyAccountUI.CHANGE_PASSWORD);
		clickToElement(driver, MyAccountUI.CHANGE_PASSWORD);
	}
	public void input_ChangePassword(String value, String textbox) {
		waitForElementvisible(driver, MyAccountUI.INPUT_CHANGE_PASSWORD, textbox);
		clickElementandsendKeys(driver, MyAccountUI.INPUT_CHANGE_PASSWORD, value, textbox);

	}
	public void clickChangePasswordButton() {
		waitForElementvisible(driver, MyAccountUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountUI.CHANGE_PASSWORD_BUTTON);
	}
	public boolean checkChangePasswordFail(String value) {
		String errorMessage = getTextOfElement(driver, MyAccountUI.CHANGE_PASSWORD_FAIL);
		return errorMessage.contains(value);
	}
	public boolean checkChangePasswordSuccess(String value) {
		String errorMessage = getTextOfElement(driver, MyAccountUI.CHANGE_PASSWORD_SUCCESS);
		return errorMessage.contains(value);
	}
	
}
