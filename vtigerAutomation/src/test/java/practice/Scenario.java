package practice;

import org.eva.vtiger.utils.WebUtils;
import org.eva.vtiger.webPage.HomePage;
import org.eva.vtiger.webPage.LeadDetailsPage;
import org.eva.vtiger.webPage.LeadLandingPage;
import org.eva.vtiger.webPage.LeadsCreatePage;
import org.eva.vtiger.webPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Scenario {

	public WebUtils	webUtil;
	public	LoginPage	loginPage;
	public HomePage	homeobj;
	
	
	@BeforeClass(groups = {"smoke","regression"})
	public void launchingBrowser() {
		webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
	}
	@BeforeMethod(groups = {"smoke","regression"})
	public void login() {
		webUtil.get("http://localhost:8888/");
		loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
	}
	@AfterMethod(groups = {"smoke","regression"})
	public void singOut() {
		homeobj = new HomePage(webUtil);
		homeobj.clickOnLogoutModule();
		loginPage.loginPageValidation();
	}
public void closeBrowser() {
	webUtil.Close();
}

	//	@Test(priority = 1)
	public void TC_SMOKE_01_Verify_User_Login_With_Valid_Credentials() {
		homeobj = new HomePage(webUtil);
		homeobj.validateHomepage("Home");
	}

	//	@Test(priority = 0)
	public void TC_SMOKE_02_Verify_Create_Lead_With_Valid_Data() {
		WebUtils	webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
		webUtil.get("http://localhost:8888/");
		LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		HomePage	homeobj = new HomePage(webUtil);
		homeobj.validateHomepage("Home");
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.clickOnCreateleadModule();
		LeadsCreatePage	leadCreateobj = new LeadsCreatePage(webUtil);
		leadCreateobj.fillFirstName("vimal");
		leadCreateobj.fillLastName("Bind");
		leadCreateobj.fillCompanyName("Enixo Corporate Solutions");
		leadCreateobj.fillTitle("vtiger");
		leadCreateobj.selectLeadSource("Self Generated");
		leadCreateobj.clickOnSave();
		LeadDetailsPage leadDetail_Obj=new LeadDetailsPage(webUtil);
		leadDetail_Obj.validateLeadCreated("Bind");
	}
	//	@Test(priority = -1)
	public void TC_SMOKE_03_Verify_Leads_List_Page_Load_Successfully() {
		WebUtils	webUtil= new WebUtils();
		webUtil.launchBrowser("chrome"); 
		webUtil.get("http://localhost:8888/");
		LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		HomePage	homeobj = new HomePage(webUtil);
		homeobj.validateHomepage("Home");
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.validateLeadLandingPage();
	}
	//	@Test(priority = 4)
	public void TC_SMOKE_04_Verify_User_Logout_Functionality() {
		WebUtils	webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
		webUtil.get("http://localhost:8888/");
		LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		homeobj = new HomePage(webUtil);
		homeobj.validateHomepage("Home");
		homeobj.clickOnLogoutModule();
		loginPage.loginPageValidation();

	}
	//@Test
	public void Tc_REG_01_Verfy_Create_Lead_With_Invalid_Data() {
		WebUtils	webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
		webUtil.get("http://localhost:8888/");
		LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		HomePage	homeobj = new HomePage(webUtil);
		homeobj.validateHomepage("Home");
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.clickOnCreateleadModule();
		LeadsCreatePage	leadCreateobj = new LeadsCreatePage(webUtil);
		leadCreateobj.fillFirstName("vimal");
		leadCreateobj.fillLastName("Bind");
		leadCreateobj.fillCompanyName("Enixo Corporate Solutions");
		leadCreateobj.fillEmailId("abc@");
		leadCreateobj.clickOnSave();
		String popupText = webUtil.alertGetText();
		System.err.println(popupText);
	}

	//@Test
	public void Tc_REG_02_Verfy_Create_Lead_With_Missing_Mandatory_Filds() {
		WebUtils	webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
		webUtil.get("http://localhost:8888/");
		LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		HomePage	homeobj = new HomePage(webUtil);
		homeobj.validateHomepage("Home");
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.clickOnCreateleadModule();
		LeadsCreatePage	leadCreateobj = new LeadsCreatePage(webUtil);
		leadCreateobj.fillFirstName("vimal");
		leadCreateobj.fillLastName("");
		leadCreateobj.fillCompanyName("EVA");
		leadCreateobj.clickOnSave();
		String popupText = webUtil.alertGetText();
		System.err.println(popupText);

	}
	@Test
	public void Tc_REG_03_Verfy_Edit_Existing_Lead_Details() {
//		WebUtils	webUtil= new WebUtils();
//		webUtil.launchBrowser("chrome");
//		webUtil.get("http://localhost:8888/");
//		LoginPage	loginPage = new LoginPage(webUtil);
//		loginPage.validlogin("admin", "admin");
		homeobj = new HomePage(webUtil);
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.clickOnLeadRecordsLastName(3);
		LeadDetailsPage leadDetail_Obj=new LeadDetailsPage(webUtil);
		leadDetail_Obj.clickOnEditBtn();
		LeadsCreatePage	leadCreateobj = new LeadsCreatePage(webUtil);
		leadCreateobj.fillFirstName("Akansha");
		leadCreateobj.fillLastName("saroj");
		leadCreateobj.clickOnSave();
		leadDetail_Obj.validateLeadCreated("saroj Akansha");


	}
//	@Test
	public void Tc_REG_04_Verfy_Delete_Existing_Lead() {
		WebUtils	webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
		webUtil.get("http://localhost:8888/");
		LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		HomePage	homeobj = new HomePage(webUtil);
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.clickOnCheckBox(0);
		int beforLeadActSize = leadLandingObj.getAllLeadSize();
		leadLandingObj.clickOnDeleteButton();
		webUtil.alertAccept();
		int beforLeadExpeSize = leadLandingObj.getAllLeadSize();
		Assert.assertNotEquals(beforLeadActSize, beforLeadExpeSize);

	}
	public void Tc_REG_05_Verfy_Search_Lead_By_Name() {
		WebUtils	webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
		webUtil.get("http://localhost:8888/");
		LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		HomePage	homeobj = new HomePage(webUtil);
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.fillSearchBoxForSearching("ydv");
		leadLandingObj.selectCategoryForSearch("Last Name");
		leadLandingObj.searchBtn();
	}
	public void Tc_REG_06_Verfy_Filter_Leads_Status() {
		WebUtils	webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
		webUtil.get("http://localhost:8888/");
		LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");
		HomePage	homeobj = new HomePage(webUtil);
		homeobj.clickOnLead();
		LeadLandingPage	leadLandingObj=new	LeadLandingPage(webUtil);
		leadLandingObj.selectFilterStatus(0);

	}
}
