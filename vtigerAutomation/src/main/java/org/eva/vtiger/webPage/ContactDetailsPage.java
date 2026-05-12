package org.eva.vtiger.webPage;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {
	WebUtils webUtil;

	public ContactDetailsPage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	@FindBy(xpath="//span[contains(text(),'-  Contact Information')]")
	private WebElement actualContactCreated;

	@FindBy(xpath="//input[@class='crmbutton small edit']")
	private WebElement editeButton;
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgAdministrator;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement lnkSignOut;

	
	//////////////\\\\\\\\\//////\\\\\/**<Actinos>**//////////////////////////
	
	
	public void verifyContactCreated(String expectedName) {
		webUtil.validateTextContains(actualContactCreated,expectedName, "Verify Contact Created");
	}
	public void clickOnEditeBtn() {
		webUtil.click(editeButton);
	}
	public void clickOnDeletedBtn() {
		webUtil.click(deleteButton);
	}


	public void logoutFromApplication() {
		webUtil.movetoElement(imgAdministrator);
		webUtil.click(lnkSignOut);
	}
}
