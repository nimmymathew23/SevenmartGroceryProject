package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import basePackage.DataProviderClass;
import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	
	@Test(enabled = true)
	public void verifySignInButtonText() {
		loginPage=new LoginPage(driver) ;
		homePage= new HomePage(driver);
		String actualSignInText = loginPage.getSignInText();
		String expectedSignInText = Constants.EXPECTEDLOGINBUTTONTEXT;
		Assert.assertEquals(actualSignInText, expectedSignInText, "Sign In text is same as expected");
	}

	@Test(enabled = true, priority = 1, groups = { "Critical" })
	public void verifyLoginForValidUser() throws IOException {
		
		loginPage = new LoginPage(driver);
		homePage= new HomePage(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		String actualText = homePage.getHomePageText();
		String expectedText = "Home";
		Assert.assertEquals(actualText, expectedText, "Successful Login");
	}
	
	@Test(enabled = true)
	public void verifySignInButtonColor() {
		loginPage = new LoginPage(driver);
		String actualSignInButtonColor = loginPage.getSignInButtonColor();
		String expectedSignInButtonColor = "rgba(52, 58, 64, 1)";
		Assert.assertEquals(actualSignInButtonColor, expectedSignInButtonColor, "Sign In button color is same as expected");
	}

	@Test(enabled = true)
	public void verifyLoginForInValidUser() throws IOException {
		loginPage = new LoginPage(driver);
		String user = ExcelRead.readStringData(1, 0);
		String pwd = ExcelRead.readStringData(1, 1);
		loginPage.performLogin(user, pwd);
		String actualAlertMessege = loginPage.getAlertMsg();
		System.out.println(actualAlertMessege);
		//String expectedAlertMessege = "�\n" + "Alert!\n" + "Invalid Username/Password";
		String expectedAlertMessege ="×\n" +"Alert!\n" +"Invalid Username/Password";
		
		
	
		Assert.assertEquals(actualAlertMessege, expectedAlertMessege, "Alert same as expected");
	}
	
	@Test
	public void verifyCheckBox() throws InterruptedException {
	loginPage = new LoginPage(driver);
	boolean actualCheckBoxCondition = loginPage.getRememberMe();
	boolean expectedCheckBoxCondition = false;
	Assert.assertEquals(actualCheckBoxCondition, expectedCheckBoxCondition, Constants.SELECTIONERROR);
	}
	
	@Test(enabled = true, dataProvider="loginData", dataProviderClass=DataProviderClass.class)
	public void verifyLoginForInValidUserwithExcelDataProvider(String userName, String password ) {
		loginPage = new LoginPage(driver);
		loginPage.performLogin(userName, password);
		String actualAlertMessege = loginPage.getAlertMsg();
		String expectedAlertMessege = "×\n" +"Alert!\n" +"Invalid Username/Password";
		Assert.assertEquals(actualAlertMessege, expectedAlertMessege, "Alert as expected");
	}
	
   /*@DataProvider(name="loginData")
	public Object[][] loginData() throws Exception {
		Object[][] arrayObject = ExcelRead.getTableArray(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelRead\\userData.xlsx","Sheet1");
		return arrayObject;
	}*/


}
