package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebUtil webUtil;

	// Constructor
	public HomePage(WebUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	// WebElements

	@FindBy(xpath = "(//td[@class='tabUnSelected'])[2]")
	private WebElement lnkLeads;

	@FindBy(xpath = "(//td[@class='tabUnSelected'])[3]")
	private WebElement lnkMarketing;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgAdministrator;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement lnkSignOut;


	// Methods

	public void clickOnLeadsModule() {
		webUtil.click(lnkLeads);
	}

	public void clickOnMarketingModule() {
		webUtil.click(lnkMarketing);
	}

	public void verifyTitle(String expectedTitle) {
		webUtil.validateTitleEquals(expectedTitle, "Title of Home Page");
	}

}
	


