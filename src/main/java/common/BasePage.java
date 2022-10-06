package common;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
private WebDriverWait explicitWait;
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	/////////////////////////////////////////////////
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public String getDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object[])params);
    }

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	public WebElement getElement(WebDriver driver, String locator, String... params) {
        return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
    }
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	
	public String getTextOfElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	public String getTextOfElements(WebDriver driver, String locator) {
		return getElements(driver, locator).toString();
	}
	public String getTextOfElement(WebDriver driver, String locator, String... params) {
        return getElement(driver, locator, params).getText();
    }
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	public void clickToElement(WebDriver driver, String locator,String...pamars) {
		getElement(driver, locator,pamars).click();
	}
	public void clickElementandsendKeys(WebDriver driver, String locator, String valueInput  ) {
		getElement(driver, locator).click();
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(valueInput);
	}
	public void clickElementandsendKeys(WebDriver driver, String locator, String valueInput , String...pamars ) {
		getElement(driver, locator,pamars).click();
		getElement(driver, locator,pamars).clear();
		getElement(driver, locator,pamars).sendKeys(valueInput);
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(valueInput);
	}
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput , String...pamars ) {
		getElement(driver, locator,pamars).clear();
		getElement(driver, locator,pamars).sendKeys(valueInput);
	}
	
	public void sendEnterToElement(WebDriver driver, String locator) {
		getElement(driver, locator).sendKeys(Keys.ENTER);
	}
	public void sendEnterToElement(WebDriver driver, String locator,String...pamars) {
		getElement(driver, locator,pamars).sendKeys(Keys.ENTER);
	}
	
	//////////////////////////////////////////////////
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalContain.TIME_OUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public void waitForElementvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalContain.TIME_OUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForElementvisible(WebDriver driver, String locator , String... pamars) {
		explicitWait = new WebDriverWait(driver, GlobalContain.TIME_OUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getDynamicLocator(locator, pamars))));
	}
	public void selecDropdownByText(WebDriver driver , String locator , String textItem) {
		Select select = new Select(getElement(driver, locator));
		select.selectByVisibleText(textItem);
	}
	public void selecDropdownByText(WebDriver driver , String locator , String textItem,String...pamas) {
		Select select = new Select(getElement(driver, locator , pamas));
		select.selectByVisibleText(textItem);
	}
	public String getAttributeValue(WebDriver driver , String locator , String value) {
		return getElement(driver, locator).getAttribute(value);
		
	}
	public String getAttributeValue(WebDriver driver , String locator , String value , String...pamas) {
		return getElement(driver, locator,pamas).getAttribute(value);
		
	}
	public boolean isTitleDisplayedOnPage(WebDriver driver, String locator, String value) {
        boolean result = true;
        List<WebElement> elementList = driver.findElements(By.xpath(locator));
        for(WebElement element:elementList) {
            String productTitle = element.getText();
            if(!StringUtils.containsIgnoreCase(productTitle, value)) {
                System.out.println("Break at Value = " + productTitle);
                result = false;
                break;
            }
        }
        return result;
    }
}
