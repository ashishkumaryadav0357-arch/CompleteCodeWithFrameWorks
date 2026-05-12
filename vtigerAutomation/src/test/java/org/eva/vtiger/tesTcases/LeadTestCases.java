package org.eva.vtiger.tesTcases;

import org.eva.vtiger.utils.WebUtils;
import org.eva.vtiger.webPage.HomePage;
import org.eva.vtiger.webPage.LeadDetailsPage;
import org.eva.vtiger.webPage.LeadLandingPage;
import org.eva.vtiger.webPage.LeadsCreatePage;
import org.eva.vtiger.webPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeadTestCases {

	public	WebUtils webUtil;
	public LoginPage loginPage;
	public HomePage homeobj ;

	
@BeforeClass(groups = {"smoke"})
	
	public void launching() {
		webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
	}


	@BeforeMethod(groups = {"smoke"})
	public  void Login() {
		webUtil.get("http://localhost:8888/");
		loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		homeobj = new HomePage(webUtil);
		homeobj.validateHomepage("Home");
	}


	@AfterMethod(groups = {"smoke"})
	public  void  Logout_Test02() {
		homeobj.clickOnLogoutModule();
		loginPage.loginPageValidation();

	}
	@AfterClass(groups = {"smoke"})
	public void closeBrowser() {
		webUtil.Close();
	}


	@Test(priority = 1,enabled = true,groups = {"smoke"})
	public  void Create_NewLead()  {
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.clickOnCreateleadModule();
		LeadsCreatePage	leadCreateobj = new LeadsCreatePage(webUtil);
		leadCreateobj.fillFirstName("Ashish");
		leadCreateobj.fillLastName("ydv G");
		leadCreateobj.fillCompanyName("Enixo Corporate Solutions");
		leadCreateobj.fillTitle("vtiger");
		leadCreateobj.selectLeadSource("Self Generated");
		leadCreateobj.clickOnSave();
		LeadDetailsPage leadDetail_Obj=new LeadDetailsPage(webUtil);
		leadDetail_Obj.validateLeadCreated("ydv G");
	}


	@Test(priority = 2,groups = {"smoke"})
	public  void Edit_Lead()  {
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj =new	LeadLandingPage(webUtil);
		leadLandingObj.clickOnCreateleadModule();
		LeadsCreatePage leadCreateobj = new LeadsCreatePage(webUtil);
		leadCreateobj.selectCategory("Ms.");
		leadCreateobj.fillFirstName("Aradhya");
		leadCreateobj.fillLastName("ydv");
		leadCreateobj.fillCompanyName("Enixo Corporate Solutions");
		leadCreateobj.selectLeadSource("Self Generated");
		leadCreateobj.clickOnSave();
		LeadDetailsPage leadDetail_Obj=new LeadDetailsPage(webUtil);
		leadDetail_Obj.clickOnEditBtn();
		leadCreateobj.fillTitle("Ak47");
		leadCreateobj.selectIndustry("Engineering");
		leadCreateobj.fillAnnualRevenue("55");
		leadCreateobj.fillNoOfEmployees("12");
		leadCreateobj.fillSecondaryEmail("aradhya@gmail.com");
		leadCreateobj.fillPhoneNo("8823493489");
		leadCreateobj.fillMobile("9846578374");
		leadCreateobj.fillFaxNo("44");
		leadCreateobj.fillEmailId("enixo@gmail.com");
		leadCreateobj.fillWebsite("www.enixoCorporateSolutions.com");
		leadCreateobj.selectLeadStatus("Qualified");
		leadCreateobj.selectRating("Acquired");
		leadCreateobj.fillStreet("Mondh");
		leadCreateobj.fillPostalCode("221401");
		leadCreateobj.fillCountry("US");
		leadCreateobj.fillPoBox("221401");
		leadCreateobj.fillCity("Bhadohi");
		leadCreateobj.fillState("Noida");
		leadCreateobj.fillDescription(" It New Lead ");
		leadCreateobj.clickOnSave();
		leadDetail_Obj.validateLeadCreated("ydv");


	}

	@Test(priority = 3,groups = {"smoke"})
	public  void  Delete_Lead() throws InterruptedException {
		homeobj.clickOnLead();
		LeadLandingPage leadLandibg_Obj=new	LeadLandingPage(webUtil);
		int beforDltActSize = leadLandibg_Obj.getAllLeadSize();
		leadLandibg_Obj.clickOnCheckBox(2);
		leadLandibg_Obj.clickOnDeleteButton();
		webUtil.alertAccept();
		webUtil.Threadsleep(5000);
		int afterDltExpSize = leadLandibg_Obj.getAllLeadSize();
		Assert.assertNotEquals(beforDltActSize, afterDltExpSize);
	
	}
	
}
