package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {

	WebDriver driver;
	GeneralUtilities generalUtilities;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		
		PageFactory.initElements(driver, this);
		generalUtilities = new GeneralUtilities();
	}

	@FindBy(xpath = "//a[text()='Home']") 
	WebElement homepage;
	
	@FindBy(xpath = "//li[@class='nav-item dropdown']") 
	WebElement UserDropdown;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") // with page factory
	WebElement logoutButton;
	
	
	@FindBy(xpath = "//li[@class='nav-item']//i[@class='fas fa-bars']") // with page factory
	WebElement navBarIcon;
	


	public String getHomePageText() {
		String text = generalUtilities.getElementText(homepage);
		return text;
	}
	
	public String getHomePageURL() {
		String url= generalUtilities.getPageURL(driver);
		return url;
	}
	
	public String getHomePageTitle() {
		String url= generalUtilities.getPageTitle(driver);
		return url;
	}
	
	public void performLogout() {
		generalUtilities.buttonClick(UserDropdown);
		generalUtilities.buttonClick(logoutButton);	
	}

	
}
