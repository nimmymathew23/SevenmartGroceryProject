package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpenses;
import utilities.ExtentReport;



public class ManageExpensesTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ManageExpenses manageExpense;

	@Test(enabled = true)
	public void verifyManageExpensePageLoad() {
		loginPage = new LoginPage(driver);
		manageExpense = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpense.loadManageExpense();
		manageExpense.loadListExpenses();
		String actualpageheader = manageExpense.manageExpensesPageLoad();
		String expectedpageHeader = Constants.EXPECTEDPAGEHEADER;
		Assert.assertEquals(actualpageheader, expectedpageHeader, " Page is loaded");
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonFontSize() {
		loginPage = new LoginPage(driver);
		manageExpense = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpense.loadManageExpense();
		manageExpense.loadListExpenses();
		Assert.assertEquals(manageExpense.getNewBtnFontSize(), "16px", " font size is as expected");
		Assert.assertEquals(manageExpense.getSearchBtnFontSize(), "16px", " font size is as expected");
		Assert.assertEquals(manageExpense.getResetBtnFontsize(), "16px", " font size is as expected");
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonFontColor() {
		loginPage = new LoginPage(driver);
		manageExpense = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpense.loadManageExpense();
		manageExpense.loadListExpenses();
		Assert.assertEquals(manageExpense.getNewBtnFontColor(), "rgba(220, 53, 69, 1)", " New btn font color is as expected");
		Assert.assertEquals(manageExpense.getSearchBtnFontColor(), "rgba(0, 123, 255, 1)",
				" Search btn font color is as expected");
		Assert.assertEquals(manageExpense.getResetBtnFontColor(), "rgba(255, 193, 7, 1)", " Reset btn font color is as expected");

	}

	@Test(enabled = true)
	public void verifyAddExpenseFieldsPresence() {
		loginPage = new LoginPage(driver);
		homePage=new HomePage(driver);
		manageExpense = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpense.loadManageExpense();
		manageExpense.loadListExpenses();
		manageExpense.loadAddExpensePage();
		Assert.assertTrue(manageExpense.verifyUserNameFieldPresence(),"User Name fiels is Present");
		Assert.assertTrue(manageExpense.verifyExpenseTypeFieldPresence(),"ExpenseType field is Present");
		Assert.assertTrue(manageExpense.verifyDateFieldPresence(),"Date field is Present");
		Assert.assertTrue(manageExpense.verifyAmountFieldPresence(),"Amount Field is Present");
	}

	@Test(enabled = true)
	public void verifyAddNewExpenseRecord() throws AWTException, InterruptedException {
		loginPage = new LoginPage(driver);
		manageExpense = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpense.loadManageExpense();
		manageExpense.loadListExpenses();
		manageExpense.loadAddExpensePage();
		manageExpense.AddDetails("User(DB)", "Debit Bank", "500");
		manageExpense.FileUpload();
		manageExpense.createExpenseRecord();
		String actualExpenseRecordAlert = manageExpense.successAlert();
		String expectedExpenseRecordAlert = "×\n"
				+ "Alert!\n"
				+ "Expense Record Created Successfully";
		Assert.assertEquals(actualExpenseRecordAlert, expectedExpenseRecordAlert, "::Expense record created");
	}
}
