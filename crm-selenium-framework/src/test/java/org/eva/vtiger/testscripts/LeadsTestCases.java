package org.eva.vtiger.testscripts;

import org.eva.vtiger.pages.CreateLeadPage;
import org.eva.vtiger.pages.HomePage;
import org.eva.vtiger.pages.LeadsDetailsPage;
import org.eva.vtiger.pages.LeadsLandingPage;
import org.eva.vtiger.pages.LoginPage;
import org.eva.vtiger.utils.WebUtil;

public class LeadsTestCases {

	public static void main(String[] args) {
		LeadsTestCases leadsTestCases=new LeadsTestCases();
		leadsTestCases.TC002_Leads_CreateLead_MendetoryInfo();

	}
	
	public void TC001_Leads_CreateLead_EndToEndFlow(){
		WebUtil webutil=new WebUtil();
		webutil.browserlaunch("chrome");
		webutil.openURL("http://localhost:8888/");
		LoginPage loginPage=new LoginPage(webutil);
		loginPage.validLogin("admin", "admin");
		HomePage homePage=new HomePage(webutil);
		homePage.clickOnLeadsModule();
		LeadsLandingPage leadsLandingPage=new LeadsLandingPage(webutil);
		leadsLandingPage.clickOnCreateLeadButton();
		CreateLeadPage createLeadPage=new CreateLeadPage(webutil);
		createLeadPage.enterFirstName("Johny");
		createLeadPage.enterLastName("Sirod");
		createLeadPage.enterCompanyName("EVA");
		createLeadPage.enterMobile("9354386708");
		createLeadPage.enterEmail("ab@gamil.com");
		createLeadPage.enterStreet("maxway");
		createLeadPage.enterCity("Kwass");
		createLeadPage.enterState("MP");
		createLeadPage.enterCountry("UK");
		createLeadPage.clickSave();
		LeadsDetailsPage leadsDetailsPage=new LeadsDetailsPage(webutil);
		leadsDetailsPage.verifyLeadCreated("Sirod Johny");
		leadsDetailsPage.logoutFromApplication();
		
	}
			
	public void TC002_Leads_CreateLead_MendetoryInfo(){
		
		WebUtil webutil=new WebUtil();
		webutil.browserlaunch("chrome");
		webutil.openURL("http://localhost:8888/");
		LoginPage loginPage_Obj = new LoginPage(webutil);
		loginPage_Obj.validLogin("admin","admin");
		HomePage homePage_Obj = new HomePage(webutil);
		homePage_Obj.clickOnLeadsModule();
		LeadsLandingPage leadsLandingPage = new LeadsLandingPage(webutil);
		leadsLandingPage.clickOnCreateLeadButton();
		CreateLeadPage createLeadPage = new CreateLeadPage(webutil);
		createLeadPage.enterFirstName("raju");
		createLeadPage.enterLastName("sharma");
		createLeadPage.enterCompanyName("enixo");
		createLeadPage.clickSave();
		LeadsDetailsPage leadsDetailsPage = new LeadsDetailsPage(webutil);
		leadsDetailsPage.verifyLeadCreated("sharma");

		
		
	}
	
	
	public void TC04_Leads_EditLead_UpdateDetails() {
		WebUtil webutil=new WebUtil();
		webutil.browserlaunch("chrome");
		webutil.openURL("http://localhost:8888/");
		LoginPage loginPage_Obj = new LoginPage(webutil);
		loginPage_Obj.validLogin("admin","admin");
		HomePage homePage_Obj = new HomePage(webutil);
		homePage_Obj.clickOnLeadsModule();
		LeadsLandingPage leadsLandingPage = new LeadsLandingPage(webutil);
		leadsLandingPage.clickOnCreateLeadButton();
		CreateLeadPage createLeadPage = new CreateLeadPage(webutil);
		createLeadPage.enterFirstName("raju");
		createLeadPage.enterLastName("sharma");
		createLeadPage.enterCompanyName("enixo");
		createLeadPage.clickSave();
//		LeadsDetailsPage leadsDetailsPage = new LeadsDetailsPage(webutil);
		

//		WebUtil webutil=new WebUtil();
//		webutil.browserlaunch("ch");
//		webutil.openURL("http://localhost:8888/");
//		webutil.sendkeys("//input[@name='user_name']","admin" );
//		webutil.sendkeys("//input[@name='user_password']", "admin");
//		webutil.click("//input[@id='submitButton']");
//		webutil.click("(//td[@class='tabUnSelected'])[2]");
//		webutil.click("//img[@title='Create Lead...']");
//		webutil.sendkeys("//input[@name='firstname']", "John");
//		webutil.sendkeys("//input[@name='lastname']","Sirod" );
//		webutil.sendkeys("//input[@name='company']", "EVA");
//		webutil.click("(//input[@title='Save [Alt+S]'])[2]");
	}
	
//	public void TC05_Leads_DeleteLead_ExistingLead() {
//		WebUtil webutil=new WebUtil();
//		webutil.browserlaunch("ch");
//		webutil.openURL("http://localhost:8888/");
//		webutil.sendkeys("//input[@name='user_name']","admin" );
//		webutil.sendkeys("//input[@name='user_password']", "admin");
//		webutil.click("//input[@id='submitButton']");
//		webutil.click("(//td[@class='tabUnSelected'])[2]");
//		webutil.click("//img[@title='Create Lead...']");
//		webutil.sendkeys("//input[@name='firstname']", "John");
//		webutil.sendkeys("//input[@name='lastname']","Sirod" );
//		webutil.sendkeys("//input[@name='company']", "EVA");
//		webutil.click("(//input[@title='Save [Alt+S]'])[2]");
//		//deleteLead
//		
//	}
//	public void TC13_Leads_ConvertLead_Success() {
//		WebUtil webutil=new WebUtil();
//		webutil.browserlaunch("ch");
//		webutil.openURL("http://localhost:8888/");
//		webutil.sendkeys("//input[@name='user_name']","admin" );
//		webutil.sendkeys("//input[@name='user_password']", "admin");
//		webutil.click("//input[@id='submitButton']");
//		webutil.click("(//td[@class='tabUnSelected'])[2]");
//		webutil.click("//img[@title='Create Lead...']");
//		webutil.sendkeys("//input[@name='firstname']", "John");
//		webutil.sendkeys("//input[@name='lastname']","Sirod" );
//		webutil.sendkeys("//input[@name='company']", "EVA");
//		webutil.click("(//input[@title='Save [Alt+S]'])[2]");
//		//convertLead
//	}

}
