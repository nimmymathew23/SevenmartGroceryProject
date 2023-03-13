package testCases;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.BaseClass;
import constants.Constants;
import elementRepository.ExpenseCategory;
import elementRepository.HomePage;
import elementRepository.LoginPage;



public class ExpenseCategoryTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ExpenseCategory expenseCategory;

	@Test(enabled = true)
	public void verifyExpenseCategoryPageIsLoaded() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		String actualExpenseCategoryPageHading = expenseCategory.expenseCateogryPageHeading();
		String expectedExpenseCategoryPageHading= "Expense Category";
		Assert.assertEquals(actualExpenseCategoryPageHading, expectedExpenseCategoryPageHading, "Expense category page is loaded");

	}

	@Test(enabled = true)
	public void addNewExpenseCategory() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		expenseCategory.clickNewButton();
		expenseCategory.enterTitle("Grocery9991");
		Thread.sleep(1000);
		expenseCategory.createNewExpenseCategory();
		Thread.sleep(1000);
		String addedItemText = expenseCategory.addedItemCheck();
		Thread.sleep(1000);
		Assert.assertEquals("Grocery9991", addedItemText);
	}

	@Test(enabled = true)
	public void searchExpenseCategory() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		expenseCategory.clickSearchButton();
		expenseCategory.inputSearchItem("haha");
		expenseCategory.clickItemSearch();
		String actualSearchItem = expenseCategory.addedItemCheck();
		Assert.assertEquals(actualSearchItem, "haha", "::Search is working");
	}

	@Test(enabled = true)
	public void deleteExpenseCategory() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		expenseCategory.deleteItem("Apple1230");
		String actualAlertMessage = expenseCategory.successAlert();
		System.out.println(actualAlertMessage);
		String expectedAlertMessage = "×\n"
				+ "Alert!\n"
				+ "Expense Category Deleted Successfully";
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "::Item deleted");
	}

	@Test(enabled = true)
	public void EditExpenseCategory() {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		expenseCategory.clickEditIcon();
		expenseCategory.clearSearchField();
		expenseCategory.inputItemToUpdate("Apple1230"+LocalDateTime.now().getSecond());
		expenseCategory.clickUpdateItem();
		String actualUpdateAlert = expenseCategory.updateSuccessAlert();
		String expectedUpdateAlert ="×\n"
				+ "Alert!\n"
				+ "Category Updated Successfully";
		Assert.assertEquals(actualUpdateAlert, expectedUpdateAlert, "::Item not updated");	
	
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonColors() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();

		SoftAssert softAssertNew = new SoftAssert();
		softAssertNew.assertEquals(expenseCategory.getNewButtonColor(), "rgba(220, 53, 69, 1)",
				"::New Button color is as expexpenseCategoryted");

		SoftAssert softAssertSearch = new SoftAssert();
		softAssertSearch.assertEquals(expenseCategory.getSearchButtonColor(), "rgba(0, 123, 255, 1)",
				"::Search Button color is as expexpenseCategoryted");

		SoftAssert softassertReset = new SoftAssert();
		softassertReset.assertEquals(expenseCategory.getResetButtonColor(), "rgba(255, 193, 7, 1)",
				"Reset button color is as expexpenseCategoryted");

	}

}
