package org.eva.vtiger.tesTcases;

import org.eva.vtiger.utils.WebUtils;
import org.eva.vtiger.webPage.ContactCreatePage;
import org.eva.vtiger.webPage.ContactDetailsPage;
import org.eva.vtiger.webPage.ContactsLandingPage;
import org.eva.vtiger.webPage.HomePage;
import org.eva.vtiger.webPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTestCases {

	public	WebUtils webUtil;
	public LoginPage loginPage;
	public HomePage homeobj;
	
	
@BeforeClass(groups = {"regression"})
	
	public void launching() {
		webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
	}


	@BeforeMethod(groups = {"regression"})
	public  void Login() {
		webUtil.get("http://localhost:8888/");
		loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		homeobj = new HomePage(webUtil);
		homeobj.validateHomepage("Home");
	}


	@AfterMethod(groups = {"regression"})
	public  void  Logout_Test02() {
		homeobj.clickOnLogoutModule();
		loginPage.loginPageValidation();

	}
	@AfterClass(groups = {"regression"})
	public void closeBrowser() {
		webUtil.Close();
	}

	
	@Test(priority = 1,groups = {"regression"})
	public  void  create_Contact() {

		homeobj.clickOnContact();
		ContactsLandingPage contactObj=new	ContactsLandingPage(webUtil);
		contactObj.clickOnCreateContactBtn();
		ContactCreatePage contactCeating=new ContactCreatePage(webUtil);
		contactCeating.selectCategory("Mr.");
		contactCeating.fillFirstName("Karan");
		contactCeating.fillLastName("ydvvvv");
		contactCeating.clickOnOrgBtn_SwitchOnNewWin();
		contactCeating.selectOrgName(2);
		contactCeating.switchOnMainWin();
		contactCeating.SelectLeadSourceModuel(3);
		contactCeating.clickOnSaveButton();
		ContactDetailsPage contsctDetailPage = new ContactDetailsPage(webUtil);
		contsctDetailPage.verifyContactCreated("ydvvvv");
	}
	@Test(priority = 2,groups = {"regression"})
	public  void Edit_Contact07() {

		homeobj.clickOnContact();
		ContactsLandingPage contactObj=new	ContactsLandingPage(webUtil);
		contactObj.clickOnCreateContactBtn();
		ContactCreatePage contactCeating=new ContactCreatePage(webUtil);
		contactCeating.selectCategory("Mr.");
		contactCeating.fillFirstName("Karan");
		contactCeating.fillLastName("ydvvvv");
		contactCeating.clickOnOrgBtn_SwitchOnNewWin();
		contactCeating.selectOrgName(2);
		contactCeating.switchOnMainWin();
		contactCeating.SelectLeadSourceModuel(3);
		contactCeating.clickOnSaveButton();
		ContactDetailsPage contsctDetailPage = new ContactDetailsPage(webUtil);
		contsctDetailPage.clickOnEditeBtn();
		contactCeating.fillTitleName("QA");
		contactCeating.fillDepartmentName("Tester");
		contactCeating.fillEmailName("Enixo@gmail.com");
		contactCeating.fillAssistantName("Bulbul");
		contactCeating.fillAssistantPhoneNo("8907654324");
		contactCeating.clickOn_EmailOpt_OutChechBox();
		contactCeating.clickOn_ReferenceChechBox();
		contactCeating.clickOn_Notify_OwnerChechBox();
		contactCeating.fillOfficePhoneNo("7788900005");
		contactCeating.fillMobileNo("9066874568");
		contactCeating.fillHomePhoneNo("8823809001");
		contactCeating.fillOtherPhoneNo("8700056782");
		contactCeating.fillFaxNo("56");
		contactCeating.fillBirthday("2002/03/12");
		contactCeating.clickReportsBtn_SwitchOnNewWin();
		contactCeating.selectReportsName(3);
		contactCeating.switchOnMainWin();
		contactCeating.fillSecondaryEmailName("enixo03@gmail.com");
		contactCeating.selectOnDoNotCal_CheckBox();
		contactCeating.clickOnSaveButton();
		contsctDetailPage.verifyContactCreated("ydvvvv");
	}
	
	@Test(priority = 3,groups = {"regression"})
	public void  Delete_Contact08() throws InterruptedException {
		homeobj.clickOnContact();
		ContactsLandingPage contactLandingObj=new	ContactsLandingPage(webUtil);
		int beforDltActSize = contactLandingObj.getAllContainsSize();
		contactLandingObj.clickOnCheckBox(1);
		contactLandingObj.clickOnDeleteButton();
		webUtil.alertAccept();
		webUtil.Threadsleep(5000);
		int afterDltExpSize = contactLandingObj.getAllContainsSize();
		Assert.assertNotEquals(beforDltActSize, afterDltExpSize);
	}

}
