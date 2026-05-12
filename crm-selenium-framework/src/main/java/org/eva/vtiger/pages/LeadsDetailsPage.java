package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsDetailsPage {

	private WebUtil webUtil;

	// Constructor
	public LeadsDetailsPage(WebUtil webUtil) {

		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	// WebElements

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgAdministrator;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement lnkSignOut;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement lblLeadHeader;
	// Methods

	
	public void verifyLeadCreated(String expectedName) {
        webUtil.validateTextContains(lblLeadHeader, expectedName,"Verify Lead Created");
	}
	
	public void logoutFromApplication() {

		webUtil.mouseOver(imgAdministrator);
		webUtil.click(lnkSignOut);

	}

}
