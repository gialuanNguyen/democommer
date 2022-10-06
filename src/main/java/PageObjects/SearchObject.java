package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.MyAccountUI;
import PageUI.SearchUI;
import common.BasePage;

public class SearchObject extends BasePage {
	WebDriver driver;

	public SearchObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickLogin() {
		waitForElementvisible(driver, MyAccountUI.CLICK_LOGIN);
		clickToElement(driver, MyAccountUI.CLICK_LOGIN);
	}

	public void clickSearch() {
		waitForElementClickable(driver, SearchUI.SEARCH_BUTTON);
		clickToElement(driver, SearchUI.SEARCH_BUTTON);

	}

	public void clickSearchButton() {
		waitForElementClickable(driver, SearchUI.CLICK_SEARCH_BUTTON);
		clickToElement(driver, SearchUI.CLICK_SEARCH_BUTTON);

	}

	public boolean SearchError(String value,String textbox) {
		String errorMessage = getTextOfElement(driver, SearchUI.SEARCH_ERROR,textbox);
		return errorMessage.contains(value);
	}
	public void input_SearchKeyword(String value) {
		waitForElementvisible(driver, SearchUI.SEARCH_KEYWORD);
		clickElementandsendKeys(driver, SearchUI.SEARCH_KEYWORD, value);

	}
	public boolean checkProducts(String value) {
		List<WebElement> ListOfProducts = getElements(driver, SearchUI.SEARCH_EQUAL);
		for(WebElement values : ListOfProducts) {
			values.getText().contains(value);
		}
		String errorMessage = getTextOfElement(driver, SearchUI.SEARCH_ERROR);
		return errorMessage.contains(value);
	
		
	}
	public void clickAdvancedSearch() {
		waitForElementClickable(driver, SearchUI.CLICK_ADVANCED_SEARCH);
		clickToElement(driver, SearchUI.CLICK_ADVANCED_SEARCH);

	}
	public void enterToDropdownCategori(String value) {
		selecDropdownByText(driver, SearchUI.SELECT_CATEGORY, value);
	}
	public void clickAutomatically() {
		waitForElementClickable(driver, SearchUI.CLICK_AUTOMATICALLY);
		clickToElement(driver, SearchUI.CLICK_AUTOMATICALLY);

	}
	public boolean SubCategory(String value) {
		String SubCategories = getTextOfElement(driver, SearchUI.CHECK_SUB_CATEGORY);
		return SubCategories.contains(value);
	}
	public boolean isSearchProductTitleDisplayedOnPageAsExpected(String value) {
        return isTitleDisplayedOnPage(driver, SearchUI.PRODUCT_TITLE, value);
    }
}
