package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.SearchUI;
import PageUI.WishLishUI;
import common.BasePage;

public class WishListObject extends BasePage{
	WebDriver driver;

	public WishListObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProduct(String textbox) {
		waitForElementvisible(driver, WishLishUI.CLICK_PRODUCT,textbox);
		clickToElement(driver, WishLishUI.CLICK_PRODUCT,textbox);
	}
	public void clickAddtoWishList() {
		waitForElementvisible(driver, WishLishUI.CLICK_ADD_WISHLIST);
		clickToElement(driver, WishLishUI.CLICK_ADD_WISHLIST);
	}
	public boolean checkAddToWishList(String value) {
		String errorMessage = getTextOfElement(driver, WishLishUI.CHECK_ADD_WISHLIST);
		return errorMessage.contains(value);
	}
	public void clickAddToCart() {
		waitForElementvisible(driver, WishLishUI.CLICK_ADD_TO_CART);
		clickToElement(driver, WishLishUI.CLICK_ADD_TO_CART);
	}
	public void clickAddToCartButton() {
		waitForElementvisible(driver, WishLishUI.CLICK_ADD_TO_CART_BUTTON);
		clickToElement(driver, WishLishUI.CLICK_ADD_TO_CART_BUTTON);
	}
	public void clickClose() {
		waitForElementvisible(driver, WishLishUI.CLICK_CLOSE);
		clickToElement(driver, WishLishUI.CLICK_CLOSE);
	}
	public boolean noProductWishList(String value) {
		String errorMessage = getTextOfElement(driver, WishLishUI.NO_PRODUCT_WISHLIST);
		return errorMessage.contains(value);
	}
	public boolean checkShopcart(String value) {
		String errorMessage = getTextOfElement(driver, WishLishUI.CHECK_SHOPCART);
		return errorMessage.contains(value);
	}
	
}
