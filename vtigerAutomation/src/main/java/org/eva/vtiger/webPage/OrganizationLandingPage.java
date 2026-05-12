package org.eva.vtiger.webPage;

import java.util.List;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationLandingPage {

	WebUtils webUtil;

	public OrganizationLandingPage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganization;

	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;

	@FindBy(xpath="//input[@name='selected_id']")
	private List<WebElement> organizationSize;


	public void clickOnCreateOrganization() {
		webUtil.click(createOrganization);
	}

	public void clickOnDeleteBtn() {
		webUtil.click(deleteBtn);
	}

	public int getAllOrganizationSize() {
		List<WebElement> leads = webUtil.findElements(organizationSize);
		return leads.size();
	}
	public void clickOnCheckBox(int selectCheckBox) {
		List<WebElement> organization = webUtil.findElements(organizationSize);
		WebElement checkBox = organization.get(selectCheckBox);
		checkBox.click();
	}

}