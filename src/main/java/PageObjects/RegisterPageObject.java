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

	public boolean checkEmailWrongMessage(String value) {
		String wrongMessage = getTextOfElement(driver, RegisterPageUI.EMAIL_WRONG_MESSAGE);
		return wrongMessage.equals(value);
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
		return errorMessage.equals(value);
	}
	public boolean passleast(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASS_LEAST);
		return errorMessage.equals(value);
	}
	public boolean passNotMatch(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASS_NOTMATCH);
		return errorMessage.equals(value);
	}
	

	
}
