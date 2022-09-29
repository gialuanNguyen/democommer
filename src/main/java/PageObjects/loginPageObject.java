package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.LoginPageUI;
import PageUI.RegisterPageUI;
import common.BasePage;

public class loginPageObject extends BasePage{
	WebDriver driver;

	// constructor
	public loginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickTologinButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON );
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	public boolean enterEmail(String value) {
		String errorMessage = getTextOfElement(driver,LoginPageUI.ENTER_EMAIL );
		return errorMessage.equals(value);
	}
	public boolean wrongEmail(String value) {
		String errorMessage = getTextOfElement(driver,LoginPageUI.ENTER_WRONG );
		return errorMessage.equals(value);
	}
	public boolean loginUnsuccess(String value) {
		String errorMessage = getTextOfElement(driver,LoginPageUI.NO_CUSTOMER );
		return errorMessage.contains(value);
	}
	public void inputTexbox(String value , String textbox) {
		waitForElementvisible(driver, LoginPageUI.INPUT_TEXBOX,textbox);
		sendKeysToElement(driver, LoginPageUI.INPUT_TEXBOX, value,textbox);
	}
	public boolean homePage(String value) {
		String errorMessage = getTextOfElement(driver,LoginPageUI.HOME_PAGE );
		return errorMessage.contains(value);
	}
}
