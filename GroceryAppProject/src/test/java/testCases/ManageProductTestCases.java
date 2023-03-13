package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;

public class ManageProductTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ManageProduct manageProduct;

	@Test(enabled = true)
	public void verifyManageProductTitle() {
		loginPage = new LoginPage(driver);
		manageProduct = new ManageProduct(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageProduct.loadManageProductPage();
		Assert.assertEquals(manageProduct.getManagePdtPageTitle(), Constants.MANAGEPDTPAGETITLE,
				"::Page Title is as expected");
	}
	
	@Test(enabled = true)
	public void verifyManageProductURL() {
		loginPage = new LoginPage(driver);
		manageProduct = new ManageProduct(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageProduct.loadManageProductPage();
		Assert.assertEquals(manageProduct.getManagePdtPageURL(), Constants.MANAGEPDTPAGEURL,
				"::Page URL is as expected");

	}

	@Test(enabled = true)
	public void verifyManageProductPageisLoaded() {
		loginPage = new LoginPage(driver);
		manageProduct = new ManageProduct(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageProduct.loadManageProductPage();
		Assert.assertEquals(manageProduct.getManageProductPageText(), Constants.MANAGEPDTPAGEHEADER, ":: Page is loaded");
	}
	

	@Test(enabled = true)
	public void verifyAddNewProductPageDefaultCheckboxValuesSelected() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageProduct = new ManageProduct(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageProduct.loadManageProductPage();
		manageProduct.loadAddNewPdtPage();
		Assert.assertTrue(manageProduct.unLimitedStockCheckboxStatus(), " Checkbox is selected by default");
	}
	
	@Test(enabled = true)
	public void verifyAddNewProductPageDefaultRadioButtonValues() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageProduct = new ManageProduct(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageProduct.loadManageProductPage();
		manageProduct.loadAddNewPdtPage();
		Assert.assertTrue(manageProduct.ProductTypeDefaultValue(), ":: Radio button  Veg selected by default");
		Assert.assertTrue(manageProduct.PriceTypeDefaultValue(), "::Radio button Weight selected by default");
	}

	@Test(enabled = true)
	public void verifyProductSearchPageLoad() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageProduct = new ManageProduct(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageProduct.loadManageProductPage();
		manageProduct.loadSearchPage();
		Assert.assertEquals(manageProduct.getSearchPageTitleText(), Constants.MANAGEPDTPAGESEARCHBOXTITLE,
				"Product search page is opened");

	}
	
}
