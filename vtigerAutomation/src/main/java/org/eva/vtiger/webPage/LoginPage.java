package org.eva.vtiger.webPage;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebUtils webUtil;      //WebUtils object declare

	public LoginPage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	
	
	
	@FindBy(xpath="//input[@name='user_name']")
	public WebElement username;

	@FindBy(xpath="//input[@name='user_password']")
	public WebElement userpassword;

	@FindBy(xpath="//input[@id='submitButton']")
	public WebElement loginbutton;


	public void validlogin(String namevalue,String passwordvalue) {
		webUtil.sendkeys(username, namevalue);
		webUtil.sendkeys(userpassword, passwordvalue);
		webUtil.click(loginbutton);

	}

	public void invalidlogin(String namevalue,String passwordvalue) {
		webUtil.sendkeys(username, namevalue);
		webUtil.sendkeys(userpassword, passwordvalue);
		webUtil.click(loginbutton);
	}
	public void loginPageValidation() {
		webUtil.validateUrlContains("Login&module", " User successfully logged in and dashboard displayed");
	}
}
