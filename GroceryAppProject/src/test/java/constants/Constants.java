package constants;

public class Constants {
	
	public static final String CONFIG_FILE_PATH=System.getProperty("user.dir") + "//src//main//resources//config.properties";
			
	public static final String USERNAME = "admin"; // using constant values as public static final so that we dont have
													// to hardcode
	public static final String PASSWORD = "admin";
	
	public static final String HOMEPAGEURL = "https://groceryapp.uniqassosiates.com/admin";
	
	public static final String EXPECTEDPAGEHEADER = "List Expense";
	
	public static final String CREATEMERCHANTPAGEHEADER = "List Expense";
	
	public static final String EXPECTEDLOGOUTMESSAGE = "Sign In";
	
	public static final String EXPECTEDLOGINBUTTONTEXT = "Sign In";
	
	public static final String EXPECTEDHOMEPAGETITLE = "Dashboard | 7rmart supermarket";
	
	public static final String MANAGEPDTPAGEHEADER = "List Products";
	
	public static final String MANAGEPDTPAGETITLE	 = "List Products | 7rmart supermarket";
	
	public static final String MANAGEPDTPAGESEARCHBOXTITLE = "Search List Products";
	
	public static final String ADMINUSERPAGEURL = "https://groceryapp.uniqassosiates.com/admin/list-admin";
	
	public static final String ADMINUSERPAGETITLE = "Admin Users | 7rmart supermarket";
	
	public static final String MANAGEPDTPAGEURL = "https://groceryapp.uniqassosiates.com/admin/list-product";
	
	public static final String SELECTIONERROR = "Not Selected" ;
}
