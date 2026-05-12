package org.eva.vtiger.webPage;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadDetailsPage {

	WebUtils webUtil;

	public LeadDetailsPage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	@FindBy(xpath="//span[contains(text(),'-  Lead Information')]")
	private WebElement leadInfo;

	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement edit;

	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement delete;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgAdministrator;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement lnkSignOut;
	
	
	public void validateLeadCreated(String expected) {
		webUtil.validateTextContains(leadInfo, expected, " Verifying Lead Created ");
	}

	public void clickOnEditBtn() {
		webUtil.click(edit);
	}
	public void clickOnDeleteBtn() {
		webUtil.click(delete);	
	}
	
	public void clickOnLogoutFromApplication() {
		webUtil.movetoElement(imgAdministrator);
		webUtil.click(lnkSignOut);

	}

}

