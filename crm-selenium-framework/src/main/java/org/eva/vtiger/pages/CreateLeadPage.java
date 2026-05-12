package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class CreateLeadPage {

         private WebUtil webUtil;

	 	// Constructor
	 	public CreateLeadPage(WebUtil webUtil) {
	 		this.webUtil = webUtil;
	 		PageFactory.initElements(webUtil.getDriver(), this);
	 	}

	 	// WebElements

	 	@FindBy(xpath = "//input[@name='firstname']")
	 	private WebElement txtFirstName;

	 	@FindBy(xpath = "//input[@name='lastname']")
	 	private WebElement txtLastName;

	 	@FindBy(xpath = "//input[@name='company']")
	 	private WebElement txtCompanyName;

	 	@FindBy(xpath = "//input[@name='designation']")
	 	private WebElement txtTitle;

	 	@FindBy(xpath = "//input[@name='mobile']")
	 	private WebElement txtMobile;

	 	@FindBy(xpath = "//input[@name='email']")
	 	private WebElement txtEmail;

	 	@FindBy(xpath = "//textarea[@name='lane']")
	 	private WebElement txtStreet;

	 	@FindBy(xpath = "//input[@name='city']")
	 	private WebElement txtCity;

	 	@FindBy(xpath = "//input[@name='state']")
	 	private WebElement txtState;

	 	@FindBy(xpath = "//input[@name='country']")
	 	private WebElement txtCountry;

	 	@FindBy(xpath = "//textarea[@name='description']")
	 	private WebElement txtDescription;

	 	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	 	private WebElement btnSave;

	 	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	 	private WebElement btnCancel;

	 	// Methods

	 	public void enterFirstName(String value) {
	 		webUtil.sendKeys(txtFirstName, value);
	 	}

	 	public void enterLastName(String value) {
	 		webUtil.sendKeys(txtLastName, value);
	 	}

	 	public void enterCompanyName(String value) {
	 		webUtil.sendKeys(txtCompanyName, value);
	 	}

	 	public void enterTitle(String value) {
	 		webUtil.sendKeys(txtTitle, value);
	 	}

	 	public void enterMobile(String value) {
	 		webUtil.sendKeys(txtMobile, value);
	 	}

	 	public void enterEmail(String value) {
	 		webUtil.sendKeys(txtEmail, value);
	 	}

	 	public void enterStreet(String value) {
	 		webUtil.sendKeys(txtStreet, value);
	 	}

	 	public void enterCity(String value) {
	 		webUtil.sendKeys(txtCity, value);
	 	}

	 	public void enterState(String value) {
	 		webUtil.sendKeys(txtState, value);
	 	}

	 	public void enterCountry(String value) {
	 		webUtil.sendKeys(txtCountry, value);
	 	}

	 	public void enterDescription(String value) {
	 		webUtil.sendKeys(txtDescription, value);
	 	}

	 	public void clickSave() {
	 		webUtil.click(btnSave);
	 	}

	 	public void clickCancel() {
	 		webUtil.click(btnCancel);
	 	}

	 }

	
	

