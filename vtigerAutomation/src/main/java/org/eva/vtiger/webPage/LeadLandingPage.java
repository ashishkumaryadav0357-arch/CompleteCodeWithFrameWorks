package org.eva.vtiger.webPage;

import java.util.List;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LeadLandingPage {
	WebUtils webUtil;

	public LeadLandingPage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath="//a[@href='index.php?action=ListView&module=Leads&parenttab=Marketing']")
	private WebElement verifyLeadLandingPage;

	@FindBy(xpath="//table[@class='lvt small']")
	private WebElement LeadRecords;

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	public WebElement createLead;

	@FindBy(xpath="//input[@name='selected_id']")
	private List<WebElement> leadSize;

	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement selectCategory;

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchBox;

	@FindBy(xpath="//select[@id='viewname']")
	private WebElement selectFilterStatus;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchButton;

	@FindBy(xpath="//span[@vtfieldname='lastname']/ancestor::td[@onmouseover]/a[@title='Leads']")
	private List<WebElement> leadLastName;

	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement delete;

	@FindBy(xpath="//a[text()='edit']")
	private List<WebElement> leadEdit;



	public void validatedLeadRecords() {
		boolean allLeadRecords = webUtil.isDisplayed(LeadRecords);
		Assert.assertEquals(allLeadRecords, true);
	}

	public void validateLeadLandingPage() {
		webUtil.validateTextequals(verifyLeadLandingPage, "Leads", " Verifying Lead Landing Link Text");
	}

	public void clickOnCreateleadModule() {
		webUtil.click(createLead);
	}

	public int getAllLeadSize() {
		List<WebElement> leads = webUtil.findElements(leadSize);
		return leads.size();
	}
	
	public void clickOnLeadRecordsLastName(int clickOnlastName_ByIndex) {
		List<WebElement> allLastName = webUtil.findElements(leadLastName);
		WebElement checkBox = allLastName.get(clickOnlastName_ByIndex);
		checkBox.click();
	}

	public void selectCategoryForSearch(String selectCategoryOfSearch) {
		webUtil.selectByVisibleText(selectCategory, selectCategoryOfSearch);
	}

	public void fillSearchBoxForSearching(String searchAnyCategory) {
		webUtil.sendkeys(searchBox, searchAnyCategory);
	}
	public void searchBtn() {
		webUtil.click(searchButton);
	}	
	public void selectFilterStatus(int selectFilterByIndex) {
		webUtil.selectByIndex(selectFilterStatus, selectFilterByIndex);
	}

	public void clickOnCheckBox(int selectCheckBox) {
		List<WebElement> leads = webUtil.findElements(leadSize);
		WebElement checkBox = leads.get(selectCheckBox);
		checkBox.click();
	}
	public void clickOnDeleteButton() {
		webUtil.click(delete);
	}

	public void clickOnEditBtn(int selectForEditByIndex) {
		List<WebElement> edit = webUtil.findElements(leadEdit);
		WebElement select = edit.get(selectForEditByIndex);
		select.click();
	}
	
	public void verifyLeadsRecord(String a) {
		boolean verify=webUtil.isDisplayed(LeadRecords);
		Assert.assertEquals(verify, a);
	}

}
