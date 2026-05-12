package org.eva.vtiger.webPage;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebUtils webUtil;
	
	public HomePage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}	

	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement actualHomeText;

	@FindBy(xpath="//a[@href='index.php?module=Calendar&action=index']")
	private WebElement calendar;

	@FindBy(xpath="//a[@href='index.php?module=Leads&action=index']")
	private WebElement lead;

	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organization;

	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contact;

	@FindBy(xpath="//a[@href='index.php?module=Potentials&action=index']")
	private WebElement opportunity;

	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement products;

	@FindBy(xpath="//a[@href='index.php?module=Documents&action=index']")
	private WebElement Documents;

	@FindBy(xpath="//a[@href='index.php?module=Emails&action=index']")
	private WebElement email;

	@FindBy(xpath="//a[@href='index.php?module=HelpDesk&action=index']")
	private WebElement troubleTickets;

	@FindBy(xpath="//a[@href='index.php?module=Dashboard&action=index']")
	private WebElement dashboard;

	@FindBy(xpath="//a[@href='javascript:;'")
	private WebElement more;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement  administrator;

	@FindBy(xpath="//a[@id='_my_preferences_']")
	private WebElement myPreferences;
	
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//img[@src='themes/softed/images/info.PNG']")
	private WebElement iIcon;
	
	@FindBy(xpath="//a[@href='http://wiki.vtiger.com/index.php/Main_Page']")
	private WebElement help;
	
	@FindBy(xpath="//a[@onclick='vtiger_feedback();']")
	private WebElement feedback;
	
	@FindBy(xpath="//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement setting;
	
	@FindBy(xpath="//a[@href='index.php?module=Settings&action=index&parenttab=']")
	private WebElement crm_Setting;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement feedBackDisc;
	
	public void validateHomepage(String expected) {
		webUtil.validateTextequals(actualHomeText,expected," page is verify ");
	}
	
	
	public void clickOnCalendar() {
		webUtil.click(calendar);
	}

	public void clickOnLead() {
		webUtil.click(lead);
	}

	public void clickOnOrganization() {
		webUtil.click(organization);
		
	}

	public void clickOnContact() {
		webUtil.click(contact);
	}

	public void clickOnOpportunity() {
		webUtil.click(opportunity);
	}

	public void clickOnProducts() {
		webUtil.click(products);
	}

	public void clickOnEmail() {
		webUtil.click(email);
	}

	public void clickOnTroubleTickets() {
		webUtil.click(troubleTickets);
	}

	public void clickOnDashboard() {
		webUtil.click(dashboard);
	}

	public void clickOnMoreModule() {
		webUtil.click(more);
	}
	
	public void clickOnMy_PreferencesModule() {
		webUtil.movetoElement(administrator);
		webUtil.click(myPreferences);
	}
	
	public void clickOnLogoutModule() {
		webUtil.movetoElement(administrator);
		webUtil.click(logout);
	}
	
	public void clickOnHelpModule() {
		webUtil.movetoElement(iIcon);
		webUtil.click(help);
	}
	
	public void clickOnFeedbackModule() {
		webUtil.movetoElement(iIcon);
		webUtil.click(feedback);
	}
	
	public void  fillDisc_switchWin(String feedBackDis) {
		webUtil.switchToWindowByURL("/crm/feedback.php?uid=");
		webUtil.sendkeys(feedBackDisc, feedBackDis);
	}
	public void  clickOnCRM_SettingModule() {
		webUtil.movetoElement(setting);
		webUtil.click(crm_Setting);
	}
}
