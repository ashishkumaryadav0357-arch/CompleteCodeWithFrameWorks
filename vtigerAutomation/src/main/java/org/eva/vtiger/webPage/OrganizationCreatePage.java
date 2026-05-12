package org.eva.vtiger.webPage;

import java.util.List;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {

	WebUtils webUtil;

	public OrganizationCreatePage(WebUtils webUtil){
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	@FindBy(xpath="//td[@class='moduleName']//a[text()='Organizations']")
	private WebElement verify;

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement firstname;

	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteName;

	@FindBy(xpath="//input[@name='tickersymbol']")
	private WebElement tickerSymbol;

	@FindBy(xpath="//input[@name='account_name']/ancestor::td[@class='dvtCellInfo']//img")
	private WebElement memberOf;

	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private List<WebElement>  allMemberOfNam;

	@FindBy(xpath="//input[@name='employees']")
	private WebElement employeesNo;

	@FindBy(xpath="//input[@name='email2']")
	private WebElement emailId;

	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneNo;

	@FindBy(xpath="//input[@name='ownership']")
	private WebElement ownership;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancleBtn;

	/************<Actions (performs)>*****************/

	public void validateOrganizationPage() {
		webUtil.validateTextequals(verify, "Organizations", "verifying Organizations page");
	}

	public void fillOrganizationsName(String enterName) {
		webUtil.sendkeys(firstname, enterName);
	}

	public void fillWebsiteName(String enterWebsiteName) {
		webUtil.sendkeys(websiteName, enterWebsiteName);
	}

	public void fillTickerSymbolName(String entertickersymbol) {
		webUtil.sendkeys(tickerSymbol,entertickersymbol);
	}

	public void clickOnMemberOfBtn_SwitchOnNewWin() {
		webUtil.click(memberOf);
		webUtil.switchToWindowByURL("specific_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
	}
	public void selectMemberOfName(int selectMemberOfName_ByIndex) throws InterruptedException {
		List<WebElement> organizationName = webUtil.findElements(allMemberOfNam);
		WebElement clickingOrganization = organizationName.get(selectMemberOfName_ByIndex);
		clickingOrganization.click();
		webUtil.Threadsleep(2000);
		webUtil.alertAccept();
	}
	public void switchOnMainWin() {
		webUtil.switchToWindowByURL("Accounts&action=EditView&return_action=DetailView&parenttab=Marketing");
	}

	public void fillEmployeesNo(String enteremployeesNo) {
		webUtil.sendkeys(employeesNo,enteremployeesNo);
	}

	public void fillEmailId(String enterEmailId) {
		webUtil.sendkeys(emailId,enterEmailId);
	}

	public void fillphoneNo(String enterPhoneNo) {
		webUtil.sendkeys(phoneNo,enterPhoneNo);
	}

	public void fillOwnershipName(String enterOwnership) {
		webUtil.sendkeys(ownership,enterOwnership);
	}

	public void clickOnSaveBtn() {
		webUtil.click(saveBtn);
	}
	public void clickOnCancleBtn() {
		webUtil.click(cancleBtn);
	}







}
