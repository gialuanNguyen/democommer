package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.RegisterPageUI;
import PageUI.SearchUI;
import PageUI.ShopCartUI;
import PageUI.WishLishUI;
import common.BasePage;

public class ShopCartObject extends BasePage {
	WebDriver driver;

	public ShopCartObject(WebDriver driver) {
		this.driver = driver;
	}

	public void input_Qty(String value ) {
		waitForElementvisible(driver, ShopCartUI.QTY_INPUT);
		clickElementandsendKeys(driver, ShopCartUI.QTY_INPUT,value);

	}

	public void clickUpdateShopcartButton() {
		waitForElementvisible(driver, ShopCartUI.UPDATE_SHOPCART_BUTTON);
		clickToElement(driver, ShopCartUI.UPDATE_SHOPCART_BUTTON);
	}
	public String getAttributeQty(String value) {
		return getAttributeValue(driver, ShopCartUI.QTY_INPUT, value);
	}
	public void clickRemoveShopcartButton() {
		waitForElementvisible(driver, ShopCartUI.REMOVE_SHOPCART_BUTTON);
		clickToElement(driver, ShopCartUI.REMOVE_SHOPCART_BUTTON);
	}
	public boolean checkRemove( String value) {
        String errorMessage = getTextOfElement(driver, ShopCartUI.CHECK_REMOVE);
        return errorMessage.equals(value);
    }
}
