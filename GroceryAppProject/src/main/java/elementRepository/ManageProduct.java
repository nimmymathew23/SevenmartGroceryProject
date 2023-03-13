package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageProduct {

	WebDriver driver;
	GeneralUtilities generalUtilities;
	ExplicitWait explicitWait;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generalUtilities = new GeneralUtilities();
		explicitWait = new ExplicitWait();
	}

	@FindBy(xpath = "//a[@class=' nav-link']//p[text()='Manage Product']")
	WebElement managePdt;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addNewPdtBtn;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchBtn;

	@FindBy(xpath = "//h4[@class='card-title']")
	WebElement searchPageTitle;

	@FindBy(xpath = "//div[@class='content-header']//h1[text()='List Products']")
	WebElement ManagePdtPageHeader;

	@FindBy(xpath = "//input[@name='unlimitw[]']")
	WebElement unLtfStockChckbox;

	@FindBy(xpath = "//input[@value='Veg' and @name='type']")
	WebElement RadioBtn_defaultPdtTyp;

	@FindBy(xpath = "//input[@name='price_type' and @id='purpose']")
	WebElement RadioBtn_defaultPriceTyp;

	@FindBy(xpath = "//a[@href ='https://groceryapp.uniqassosiates.com/admin/list-product' and  @type='button']")
	WebElement cancelBtn;

	public void loadManageProductPage() {
		generalUtilities.buttonClick(managePdt);

	}

	public boolean unLimitedStockCheckboxStatus() {
		return generalUtilities.isCheckboxEnabled(unLtfStockChckbox);
	}

	public boolean ProductTypeDefaultValue() {
		return generalUtilities.isRadioButtonEnabled(RadioBtn_defaultPdtTyp);
	}

	public boolean PriceTypeDefaultValue() {
		return generalUtilities.isRadioButtonEnabled(RadioBtn_defaultPriceTyp);
	}

	public void loadAddNewPdtPage() {
		generalUtilities.buttonClick(addNewPdtBtn);

	}

	public void loadSearchPage() {
		generalUtilities.buttonClick(searchBtn);

	}

	public String getSearchPageTitleText() {
		String text = generalUtilities.getElementText(searchPageTitle);
		return text;
	}

	public String getManageProductPageText() {
		String text = generalUtilities.getElementText(ManagePdtPageHeader);
		return text;
	}

	public String getManagePdtPageTitle() {
		String url = generalUtilities.getPageTitle(driver);
		return url;
	}

	public String getManagePdtPageURL() {
		String url = generalUtilities.getPageURL(driver);
		return url;
	}
}
