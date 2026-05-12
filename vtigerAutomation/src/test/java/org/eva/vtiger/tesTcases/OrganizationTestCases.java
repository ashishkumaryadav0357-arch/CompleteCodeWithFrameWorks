package org.eva.vtiger.tesTcases;

import org.eva.vtiger.utils.WebUtils;
import org.eva.vtiger.webPage.HomePage;
import org.eva.vtiger.webPage.LoginPage;
import org.eva.vtiger.webPage.OrganizationCreatePage;
import org.eva.vtiger.webPage.OrganizationDetailsPage;
import org.eva.vtiger.webPage.OrganizationLandingPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrganizationTestCases {


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
	public  void  Logout() {
		homeobj.clickOnLogoutModule();
		loginPage.loginPageValidation();

	}
	@AfterClass(groups = {"smoke"})
	public void closeBrowser() {
		webUtil.Close();
	}
	@Test(priority = 1,groups = {"smoke"})
	public void createOrganizations() throws InterruptedException {
		homeobj.clickOnOrganization();
		OrganizationLandingPage orgLandingPage=new OrganizationLandingPage(webUtil);
		orgLandingPage.clickOnCreateOrganization();
		OrganizationCreatePage	orgPageObj=new OrganizationCreatePage(webUtil);
		orgPageObj.validateOrganizationPage();
		orgPageObj.fillOrganizationsName("Harischand");
		orgPageObj.fillWebsiteName("www.agile.com");
		orgPageObj.fillTickerSymbolName("surDash");
		orgPageObj.clickOnMemberOfBtn_SwitchOnNewWin();
		orgPageObj.selectMemberOfName(2);
		orgPageObj.switchOnMainWin();
		orgPageObj.fillEmployeesNo("23");
		orgPageObj.fillEmailId("ay9053@gmail.com");
		orgPageObj.clickOnSaveBtn();
		OrganizationDetailsPage orgDetailsPage=new OrganizationDetailsPage(webUtil);
		orgDetailsPage.validateOrganizationCreated("Harischand");

	}
	@Test(priority = 2,groups = {"smoke"})
	public void editeOrganizations() throws InterruptedException {
		homeobj.clickOnOrganization();
		OrganizationLandingPage orgLandingPage=new OrganizationLandingPage(webUtil);
		orgLandingPage.clickOnCreateOrganization();
		OrganizationCreatePage	orgPageObj=new OrganizationCreatePage(webUtil);
		orgPageObj.validateOrganizationPage();
		orgPageObj.fillOrganizationsName("Hari");
		orgPageObj.fillWebsiteName("www.agile.com");
		orgPageObj.fillTickerSymbolName("surDash");
		orgPageObj.clickOnMemberOfBtn_SwitchOnNewWin();
		orgPageObj.selectMemberOfName(2);
		orgPageObj.switchOnMainWin();
		orgPageObj.fillEmployeesNo("23");
		orgPageObj.fillEmailId("ay9053@gmail.com");
		orgPageObj.clickOnSaveBtn();
		OrganizationDetailsPage orgDetailsPage=new OrganizationDetailsPage(webUtil);
		orgDetailsPage.clickOnEditeBtn();
		orgPageObj.fillEmailId("grooming012@gmail.com");
		orgPageObj.fillphoneNo("7489086478");
		orgPageObj.fillOwnershipName("maxuuu");
		orgPageObj.clickOnSaveBtn();
		orgDetailsPage.validateOrganizationCreated("Hari");

	}
		@Test(priority = 3,groups = {"smoke"})
	public void deleteOrganizations() throws InterruptedException {
		homeobj.clickOnOrganization();
		OrganizationLandingPage orgLandingPage=new OrganizationLandingPage(webUtil);
		int beforDltActSize = orgLandingPage.getAllOrganizationSize();
		orgLandingPage.clickOnCheckBox(1);
		orgLandingPage.clickOnDeleteBtn();
		webUtil.alertAccept();
		webUtil.Threadsleep(7000);
		int afterDltExpSize = orgLandingPage.getAllOrganizationSize();
		Assert.assertNotEquals(beforDltActSize, afterDltExpSize);
	}

}
