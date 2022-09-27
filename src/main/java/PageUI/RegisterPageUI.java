package PageUI;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String PASS_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String CONFIRM_PASS_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	public static final String REGIS_COMPLETE = "//div[text()='Your registration completed']";
	public static final String EMAIL_EXISTS = "//li[text()='The specified email already exists']";
	public static final String PASS_MUST = "//p[text()='Password must meet the following rules: ']";
	public static final String PASS_LEAST = "//li[text()='must have at least 6 characters']";
	public static final String PASS_NOTMATCH = "//span[text()='The password and confirmation password do not match.']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String LOGOUT_BUTTON = "//a[@class='ico-logout']";
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
}
