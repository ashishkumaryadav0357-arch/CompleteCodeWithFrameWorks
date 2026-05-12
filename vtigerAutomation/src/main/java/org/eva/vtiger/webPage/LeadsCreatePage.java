package org.eva.vtiger.webPage;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsCreatePage {

	WebUtils webUtil;
	
	public LeadsCreatePage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}	

	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement category;

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath="//input[@name='company']")
	private WebElement companyName;

	@FindBy(xpath="//input[@name='designation']")
	private WebElement title;

	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadSource;

	@FindBy(xpath="//select[@name='industry']")
	private WebElement industry;

	@FindBy(xpath="//input[@name='annualrevenue']")
	private WebElement annualRevenue;

	@FindBy(xpath="//input[@name='noofemployees']")
	private WebElement noOfEmployees;

	@FindBy(xpath="//input[@name='secondaryemail']")
	private WebElement secondary_Email;

	@FindBy(xpath="//input[@name='phone']")
	private WebElement phone;

	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobile;

	@FindBy(xpath="//input[@name='fax']")
	private WebElement fax;

	@FindBy(xpath="//input[@name='email']")
	private WebElement email;

	@FindBy(xpath="//input[@name='website']")
	private WebElement website;

	@FindBy(xpath="//select[@name='leadstatus']")
	private WebElement leadStatus;

	@FindBy(xpath="//select[@name='rating']")
	private WebElement rating;

	@FindBy(xpath="//textarea[@name='lane']")
	private WebElement street	;

	@FindBy(xpath="//input[@id='code']")
	private WebElement postalCode;

	@FindBy(xpath="//input[@id='country']")
	private WebElement country;

	@FindBy(xpath="//input[@id='pobox']")
	private WebElement po_Box	;

	@FindBy(xpath="//input[@id='city']")
	private WebElement city;

	@FindBy(xpath="//input[@id='state']")
	private WebElement state;

	@FindBy(xpath="//textarea[@name='description']")
	private WebElement description;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButton;

	
	public void selectCategory(String categoryValue) {
		webUtil.selectByValue(category, categoryValue);
	}

	public void fillFirstName(String fname) {
		webUtil.sendkeys(firstName,fname);
	}
	public void fillLastName(String lname) {
		webUtil.sendkeys(lastName,lname);
	}
	public void fillCompanyName(String comName) {
		webUtil.sendkeys(companyName,comName);
	}
	public void fillTitle(String titleName) {
		webUtil.sendkeys(title,titleName);
	}
	public void selectLeadSource(String value) {
		webUtil.selectByValue(leadSource, value);
	}
	public void selectIndustry(String induetryNamValu) {
		webUtil.selectByValue(industry, induetryNamValu);
	}

	public void fillAnnualRevenue(String annual_Revenue) {
		webUtil.sendkeys(annualRevenue,annual_Revenue);
	}
	public void fillNoOfEmployees(String noofemployes) {
		webUtil.sendkeys(noOfEmployees,noofemployes);
	}
	public void fillSecondaryEmail(String secondaryemail) {
		webUtil.sendkeys(secondary_Email,secondaryemail);
	}
	public void fillPhoneNo(String phoneNo) {
		webUtil.sendkeys(phone,phoneNo);
	}
	public void fillMobile(String mobileNo) {
		webUtil.sendkeys(mobile,mobileNo);
	}
	public void fillFaxNo(String faxNo) {
		webUtil.sendkeys(fax,faxNo);
	}
	public void fillEmailId(String email_Id) {
		webUtil.sendkeys(email,email_Id);
	}
	public void fillWebsite(String websites) {
		webUtil.sendkeys(website,websites);
	}
	public void selectLeadStatus(String leadstatus) {
		webUtil.selectByValue(leadStatus,leadstatus);
	}

	public void selectRating(String ratingValue) {
		webUtil.selectByValue(rating,ratingValue);
	}

	public void fillStreet(String streetName) {
		webUtil.sendkeys(street,streetName);
	}
	public void fillPostalCode(String postal_Code) {
		webUtil.sendkeys(postalCode,postal_Code);
	}
	public void fillCountry(String countryName) {
		webUtil.sendkeys(country,countryName);
	}
	public void fillPoBox(String poBox) {
		webUtil.sendkeys(po_Box,poBox);
	}
	public void fillCity(String cityName) {
		webUtil.sendkeys(city,cityName);
	}
	public void fillState(String stateName) {
		webUtil.sendkeys(state,stateName);
	}
	public void fillDescription(String descriptionInfo) {
		webUtil.sendkeys(description,descriptionInfo);
	}
	public void clickOnSave() {
		webUtil.click(saveButton);
	}
	public void clickOnCancel() {
		webUtil.click(cancelButton);
	}
}
