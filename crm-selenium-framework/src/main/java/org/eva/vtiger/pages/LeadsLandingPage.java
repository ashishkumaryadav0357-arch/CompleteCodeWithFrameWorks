package org.eva.vtiger.pages;
import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsLandingPage {

	private WebUtil webUtil;

	// Constructor
	public LeadsLandingPage(WebUtil webUtil) {

		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	// WebElements

	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement btnCreateLead;

	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement lblLeadsTitle;


	// Methods

	public void clickOnCreateLeadButton() {

		webUtil.click(btnCreateLead);

	}

	public void verifyLeadsLandingPageTitle() {

		webUtil.validateTitleEquals("Leads", "Title of Leads Landing Page");

	}

}
