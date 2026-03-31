package constant;

public class Constants {
	//excel file path for test data
	public static final String TEST_DATA_EXCEL_FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data.xlsx";
	//assertion messages for login test cases
	public static final String VALID_CREDENTIAL_ERROR = "Valid credentials error";
	public static final String INVALID_CREDENTIAL_ERROR = "Invalid credentials error";
	public static final String VALID_USERNAME_INVALID_PASSWORD_ERROR = "Valid username invalid password error";
	public static final String INVALID_USERNAME_VALID_PASSWORD_ERROR = "Invalid username valid password error";
	//assertion messages for admin user test cases
	public static final String ADMIN_USER_CREATION_ERROR = "Admin user creation error";
	public static final String ADMIN_USER_SEARCH_ERROR = "Admin user creation error";
	public static final String ADMIN_USER_RESET_ERROR = "Admin user reset button error";
	//assertion messages for manage news test cases
	public static final String NEWS_CREATION_ERROR = "Manage News creation error";
	public static final String NEWS_SEARCH_ERROR = "Manage News search error";
	public static final String NEWS_RESET_ERROR = "Manage News reset button error";
	//assertion message for homepage test case
	public static final String LOGOUT_ERROR = "Logout user error";
	//config file path
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
	
}
