package org.eva.vtiger.webPage;

import java.util.List;

import org.eva.vtiger.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsLandingPage {
	WebUtils webUtil;

	public ContactsLandingPage(WebUtils webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);

	}

	@FindBy(xpath="//img[contains(@title,'Create Contact')]")
	private WebElement creatContains;

	@FindBy(xpath="//input[@name='selected_id']")
	private List<WebElement> allCresteContactSize;

	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deleteButton;

	public void clickOnCreateContactBtn() {
		webUtil.click(creatContains);
	}

	public int getAllContainsSize() {
		List<WebElement> Contact =webUtil.findElements(allCresteContactSize);
	
		return Contact.size();
	}

	public void clickOnCheckBox(int selectCheckBox) {
		List<WebElement> Contact =webUtil.findElements(allCresteContactSize);
		WebElement checkBoxs = Contact.get(selectCheckBox);
		checkBoxs.click();
		 
	}

	public void clickOnDeleteButton() {
		webUtil.click(deleteButton);
	}
}
