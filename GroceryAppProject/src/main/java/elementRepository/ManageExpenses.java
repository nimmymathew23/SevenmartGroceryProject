package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageExpenses {

	WebDriver driver;
	GeneralUtilities generalUtilities;
	ExplicitWait explicitWait;
	Actions action;

	public ManageExpenses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generalUtilities = new GeneralUtilities();
		explicitWait = new ExplicitWait();
		action = new Actions(driver);
	}



	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']//p[text()='Manage Expense']")
	WebElement ListExpenses;

	@FindBy(xpath = "//li[2]//a[@class='nav-link']//i[@class='nav-icon fas fa-money-bill-alt']") 
	WebElement manageExpense;

	@FindBy(xpath = "//a[@class='nav-link']//p[text()='Create Merchant']") 
	WebElement createMerchant;

	@FindBy(xpath = "//h1[text()='List Expense']") 
	WebElement ListExpensePageHeading;

	@FindBy(xpath = "//h1[text()='Create Merchant']") 
	WebElement createMerchantPageHeading;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']") 
	WebElement newButton;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']") 
	WebElement searchButton;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-warning']") 
	WebElement resetButton;

	@FindBy(xpath = "//select[@id ='user_id']") 
	WebElement userIdField;

	@FindBy(xpath = "//input[@id='ex_date']") 
	WebElement dateField;

	@FindBy(xpath = "//select[@id='ex_type']") 
	WebElement expenseTypeField;

	@FindBy(xpath = "//input[@id='amount']") 
	WebElement amountField;

	@FindBy(xpath = "//button[@name='create']") 
	WebElement createBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	WebElement CreateSuccessAlert;

	@FindBy(xpath = "//input[@name='userfile']")
	WebElement chooseFileBtn;

	String filePath =System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\SampleFile.docx";

	public void loadManageExpense() {
		generalUtilities.buttonClick(manageExpense);
	}

	public void loadListExpenses() {
		generalUtilities.buttonClick(ListExpenses);
	}

	public void loadCreateExpense() {
		generalUtilities.buttonClick(createMerchant);
	}

	public String manageExpensesPageLoad() {
		return generalUtilities.getElementText(ListExpensePageHeading);
	}

	public String createMerchantPageLoad() {
		return generalUtilities.getElementText(ListExpensePageHeading);
	}

	public String getNewBtnFontColor() {
		return generalUtilities.getBackgroundColor(newButton);
	}

	public String getSearchBtnFontColor() {
		return generalUtilities.getBackgroundColor(searchButton);
	}

	public String getResetBtnFontColor() {
		return generalUtilities.getBackgroundColor(resetButton);
	}

	public String getNewBtnFontSize() {
		return generalUtilities.getFontSize(newButton);
	}

	public String getSearchBtnFontSize() {
		return generalUtilities.getFontSize(searchButton);
	}

	public String getResetBtnFontsize() {
		return generalUtilities.getFontSize(resetButton);
	}

	public void loadAddExpensePage() {
		generalUtilities.buttonClick(newButton);
	}

	public boolean verifyUserNameFieldPresence() {
		return generalUtilities.elementPresence(userIdField);
	}

	public boolean verifyDateFieldPresence() {
		return generalUtilities.elementPresence(dateField);
	}

	public boolean verifyExpenseTypeFieldPresence() {
		return generalUtilities.elementPresence(expenseTypeField);
	}

	public boolean verifyAmountFieldPresence() {
		return generalUtilities.elementPresence(amountField);
	}

	public void addUser(String user) {
		generalUtilities.selectDropDownValue(userIdField, user);
	}

	public void addDate(String date) {
		generalUtilities.inputText(dateField, date);
	}

	public void addAmount(String amt) {
		generalUtilities.inputText(amountField, amt);
	}

	public void addExpenseCategory(String expenseCtgryt) {
		generalUtilities.selectDropDownValue(expenseTypeField, expenseCtgryt);
	}

	public void AddDetails(String user, String expenseCtgry, String amt) {
		addUser(user);
		addExpenseCategory(expenseCtgry);
		addAmount(amt);

	}

	public void FileUpload() throws AWTException, InterruptedException {

		generalUtilities.performFileUpload(chooseFileBtn, driver, filePath);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,380)");
		explicitWait.presenceOfWebElementLocated(driver, "//button[@name='create']");

	}

	public void createExpenseRecord() {
		generalUtilities.buttonClick(createBtn);
	}

	public String successAlert() {
		return CreateSuccessAlert.getText();
	}

}
