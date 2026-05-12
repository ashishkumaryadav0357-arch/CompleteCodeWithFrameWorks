package org.eva.vtiger.pages;
import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebUtil webUtil;

	public LoginPage(WebUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

@FindBy(xpath= "//input[@name='user_name']")
private WebElement txtUserName;

@FindBy(xpath = "//input[@name='user_password']")
private WebElement txtPassword;

@FindBy(xpath = "//input[@id='submitButton']")
private WebElement btnLogin;

public void validLogin(String username, String password) {
	webUtil.sendKeys(txtUserName, username);
	webUtil.sendKeys(txtPassword, password);
	webUtil.click(btnLogin);

}
public void inValidLogin(String username, String password) {
	webUtil.sendKeys(txtUserName, username);
	webUtil.sendKeys(txtPassword, password);
	webUtil.click(btnLogin);

}

}
