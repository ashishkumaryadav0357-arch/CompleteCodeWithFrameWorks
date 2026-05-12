package org.eva.vtiger.webPage;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationDetailsPage {

	
	WebUtils webUtil;

	public OrganizationDetailsPage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'-  Organization Information')]")
	private WebElement OrganizationInformation;
	
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
 	private WebElement editeBtn; 
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	
	
	
	public void validateOrganizationCreated(String expected) {
		webUtil.validateTextContains(OrganizationInformation, expected, " Verifying Organization Created ");
	}
	public void clickOnEditeBtn() {
		webUtil.click(editeBtn);
	}
	public void clickOnDeleteBtn() {
		webUtil.click(deleteBtn);	
	}
	
}
