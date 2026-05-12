package org.eva.vtiger.webPage;

import java.util.List;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCreatePage {
	WebUtils webUtil;

	public ContactCreatePage(WebUtils webUtil){
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement category;

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath="//input[@name='account_name']/ancestor::td[@class='dvtCellInfo']//img[@src='themes/softed/images/select.gif']")
	private WebElement addOrganizationName;

	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private List<WebElement> allOrganizationName;

	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadsource;

	@FindBy(xpath="//input[@id='title']")
	private WebElement title;

	@FindBy(xpath="//input[@id='department']")
	private WebElement departmentName;

	@FindBy(xpath="//input[@id='email']")
	private WebElement emailName;
	
	@FindBy(xpath="//input[@id='assistant']")
	private WebElement assistant;
	
	@FindBy(xpath="//input[@id='assistantphone']")
	private WebElement assistantPhoneNo;
	
	@FindBy(xpath="//input[@name='emailoptout']")
	private WebElement emailOpt_Out;
	
	@FindBy(xpath="//input[@name='reference']")
	private WebElement reference;
	
	@FindBy(xpath="//input[@name='notify_owner']")
	private WebElement notify_Owner;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement officePhoneNo;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobileNo;
	
	@FindBy(xpath="//input[@name='homephone']")
	private WebElement homePhoneNo;
	
	@FindBy(xpath="//input[@name='otherphone']")
	private WebElement otherPhoneNo;
	
	@FindBy(xpath="//input[@name='fax']")
	private WebElement faxNo;
	
	@FindBy(xpath="//input[@name='birthday']")
	private WebElement birthday;
	
	@FindBy(xpath="//input[@name='contact_name']/ancestor::td[@class='dvtCellInfo']//img")
	private WebElement addReportsTo;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private List<WebElement> allReports;
	
	@FindBy(xpath="//input[@name='secondaryemail']")
	private WebElement secondaryEmailName;
	
	@FindBy(xpath="//input[@name='donotcall']")
	private WebElement selectOnDoNotCal_CheckBox;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveButton;

	@FindBy(xpath="//input[@class='crmbutton small cancel']")
	private WebElement cancleButton;
	
	///////////////////////////////////////////Actions////////////////////////
	public void selectCategory(String categoryValue) {
		webUtil.selectByValue(category, categoryValue);
	}
	public void fillFirstName(String fname) {
		webUtil.sendkeys(firstName,fname);
	}
	public void fillLastName(String lname) {
		webUtil.sendkeys(lastName,lname);
	}

	public void clickOnOrgBtn_SwitchOnNewWin() {
		webUtil.click(addOrganizationName);
		webUtil.switchToWindowByURL("index.php?module=Accounts&action=Popup&popuptype");
	}

	public void selectOrgName(int selectOrganization_ByIndex) {
		List<WebElement> organizationName = webUtil.findElements(allOrganizationName);
		WebElement clickingOrganization = organizationName.get(selectOrganization_ByIndex);
		clickingOrganization.click();
	}
	public void switchOnMainWin() {
		webUtil.switchToWindowByURL("index.php?module=Contacts&action");
	}

	public void SelectLeadSourceModuel(int selectLeadsourceByIndex) {
		webUtil.selectByIndex(leadsource, selectLeadsourceByIndex);
	}

	public void fillTitleName(String fillTitleName) {
		webUtil.sendkeys(title, fillTitleName);
	}

	public void fillDepartmentName(String fillDepartmentName) {
		webUtil.sendkeys(departmentName, fillDepartmentName);
	}
	public void fillEmailName(String fillEmail) {
		webUtil.sendkeys(emailName, fillEmail);
	}

	public void fillAssistantName(String fillAssistant) {
		webUtil.sendkeys(assistant, fillAssistant);
	}
	
	public void fillAssistantPhoneNo(String fillAssistantNo) {
		webUtil.sendkeys(assistantPhoneNo, fillAssistantNo);
	}
	
	public void clickOn_EmailOpt_OutChechBox() {
		webUtil.click(emailOpt_Out);
	}
	
	public void clickOn_ReferenceChechBox() {
		webUtil.click(reference);
	}
	
	public void clickOn_Notify_OwnerChechBox() {
		webUtil.click(notify_Owner);
	}
	
	public void fillOfficePhoneNo(String fillOfficePhoneNo) {
		webUtil.sendkeys(officePhoneNo, fillOfficePhoneNo);
	}
	
	public void fillMobileNo(String fillMobileNo) {
		webUtil.sendkeys(mobileNo, fillMobileNo);
	}
	
	public void fillHomePhoneNo(String fillHomePhoneNo) {
		webUtil.sendkeys(homePhoneNo, fillHomePhoneNo);
	}
	
	public void fillOtherPhoneNo(String fillOtherPhoneNo) {
		webUtil.sendkeys(otherPhoneNo, fillOtherPhoneNo);
	}
	
	public void fillFaxNo(String fillFaxNo) {
		webUtil.sendkeys(faxNo, fillFaxNo);
	}
	
	public void fillBirthday(String birthday_yy_mm_dd) {
		webUtil.sendkeys(birthday, birthday_yy_mm_dd);
	}
	
	public void clickReportsBtn_SwitchOnNewWin() {
		webUtil.click(addReportsTo);
		webUtil.switchToWindowByURL("Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView&recordid=");
	}
	public void selectReportsName(int selectReports_ByIndex) {
		List<WebElement> allReportsName =webUtil.findElements(allReports);
		WebElement selectByIndex=allReportsName.get(selectReports_ByIndex);
		selectByIndex.click();
	}
	public void fillSecondaryEmailName(String fillSecondaryEmail) {
		webUtil.sendkeys(secondaryEmailName,fillSecondaryEmail);
	}
	public void selectOnDoNotCal_CheckBox() {
		webUtil.click(selectOnDoNotCal_CheckBox);
	}
	public void clickOnSaveButton() {
		webUtil.click(saveButton);
	}
	public void clickOnCancleButton( ) {
		webUtil.click(cancleButton);
	}
	
}