package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.RegisterPageUI;
import common.BasePage;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean checkFirstnameErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}

	public boolean checkLastnameErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}

	public boolean checkEmailErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}

	public boolean checkPasswordErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASS_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}

	public boolean checkConfirmPasswordErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.CONFIRM_PASS_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}
	public boolean regisComplete(String value) {
		String regiscomplete = getTextOfElement(driver, RegisterPageUI.REGIS_COMPLETE);
		return regiscomplete.equals(value);
	}
	public boolean emailExists(String value) {
		String emailExist = getTextOfElement(driver, RegisterPageUI.EMAIL_EXISTS);
		return emailExist.equals(value);
	}
	public boolean passMust(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASS_MUST);
		return errorMessage.contains(value);
	}
	public boolean passNotMatch(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASS_NOTMATCH);
		return errorMessage.equals(value);
	}
	public void enterToTextBoxEmail(String email) {
		waitForElementvisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterToTextBoxFirstName(String firstName) {
		waitForElementvisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}
	public void enterToTextBoxLastName(String lastName) {
		waitForElementvisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}
	public void enterToTextBoxPassword(String password) {
		waitForElementvisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	public void enterToTextBoxConfirmPassword(String confirmPassword) {
		waitForElementvisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	public void clickToLogoutButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
	}
	public void clickToRegisterLink() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_LINK);
		clickToElement(driver, RegisterPageUI.REGISTER_LINK);
	}

	
}
