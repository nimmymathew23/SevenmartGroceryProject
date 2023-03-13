package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import constants.Constants;
import elementRepository.ExpenseCategory;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpenses;

public class HomePageTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ManageExpenses manageExpense;
	
	@Test(enabled = true)
	public void verifyHomePageURL() {
		loginPage= new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		String actualHomePageUrl=homePage.getHomePageURL();
		Assert.assertEquals(actualHomePageUrl, Constants.HOMEPAGEURL, "::Page URL is same as expected");	
	}
	
	
	
	
	@Test(enabled = true)
	public void verifyUserLogout() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		homePage.performLogout();
		String actualLogoutMsg = loginPage.getSignInText();
		String expectedLogoutMsg = Constants.EXPECTEDLOGOUTMESSAGE;
		Assert.assertEquals(actualLogoutMsg, expectedLogoutMsg, "Logout successful");
	}
	
	
	@Test(enabled = true)
	public void verifyHomePageTitle() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);	
		Assert.assertEquals(homePage.getHomePageTitle(), Constants.EXPECTEDHOMEPAGETITLE, "::Page Title is same as expected");	
	}
}

