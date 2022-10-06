package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.HomePageUI;
import PageUI.LoginPageUI;
import common.BasePage;

public class HomePageObject extends BasePage {
	WebDriver driver;

	// constructor
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickLogin() {
		waitForElementvisible(driver, HomePageUI.LOGIN_PAGE);
		clickToElement(driver, HomePageUI.LOGIN_PAGE);
	}
	public void clickSearchButton() {
		waitForElementvisible(driver, HomePageUI.CLICK_SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.CLICK_SEARCH_BUTTON);
	}
	public void input_SearchKeyword(String value) {
		waitForElementvisible(driver, HomePageUI.CLICK_SEARCH_SENDKEY);
		clickElementandsendKeys(driver, HomePageUI.CLICK_SEARCH_SENDKEY, value);

	}
	public void clickWishList() {
		waitForElementvisible(driver, HomePageUI.CLICK_WISHLIST);
		clickToElement(driver, HomePageUI.CLICK_WISHLIST);
	}
}
