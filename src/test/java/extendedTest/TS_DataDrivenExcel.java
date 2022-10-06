package extendedTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePageObject;
import PageObjects.loginPageObject;
import Util.ExcelUtil;
import common.BaseTest;
public class TS_DataDrivenExcel extends BaseTest {
	WebDriver driver;
	loginPageObject loginPage;
	HomePageObject homePage;
	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(urlPage, browserName);
		loginPage = new loginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void LoginExcel() throws IOException {
		ExcelUtil.setExcelFile("Auto");
		for(int i=1;i<=ExcelUtil.getRowCountInSheet();i++) {
		
		String excelUserName = ExcelUtil.getCellData(i, 1);
	    String excelPassword = ExcelUtil.getCellData(i,2 );
	    System.out.println("Account using: " + excelUserName + "," + excelPassword);
	    loginPage.refeshCurrentPage(driver);
	    loginPage.inputTexbox(excelUserName, "Email");
	    loginPage.inputTexbox(excelPassword, "Password");
	    loginPage.clickTologinButton();
	    homePage = new HomePageObject(driver);
	   
//	    Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");

	    String homePageUrl = homePage.getPageUrl(driver);
	    if (homePageUrl.equals("https://demo.nopcommerce.com/")) {
	        ExcelUtil.setCellData("Pass", i, 3);
	    } else {
	        ExcelUtil.setCellData("Fail", i, 3);
	    }
		}
	}
	
}

