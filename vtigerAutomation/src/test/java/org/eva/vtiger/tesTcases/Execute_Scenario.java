package org.eva.vtiger.tesTcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Set;


import org.eva.vtiger.utils.WebUtils;
import org.eva.vtiger.webPage.ContactCreatePage;
import org.eva.vtiger.webPage.ContactDetailsPage;
import org.eva.vtiger.webPage.ContactsLandingPage;
import org.eva.vtiger.webPage.HomePage;
import org.eva.vtiger.webPage.LeadDetailsPage;
import org.eva.vtiger.webPage.LeadLandingPage;
import org.eva.vtiger.webPage.LeadsCreatePage;
import org.eva.vtiger.webPage.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Execute_Scenario{
	public	WebUtils webUtil;
	public LoginPage loginPage;
	public HomePage homeobj ;


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


	@Test(enabled = true,groups = {"smoke"})
	public  void Create_NewLead03()  {
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


	@Test(groups = {"smoke"})
	public  void Edit_Lead04()  {
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

	@Test(groups = {"smoke"})
	public  void  Delete_Lead05() throws InterruptedException {

		homeobj.clickOnLead();
		LeadLandingPage leadLandibg_Obj=new	LeadLandingPage(webUtil);
		int beforDeleteSize = leadLandibg_Obj.getAllLeadSize();
		leadLandibg_Obj.clickOnCheckBox(2);
		leadLandibg_Obj.clickOnDeleteButton();
		webUtil.alertAccept();
		webUtil.Threadsleep(5000);
		int afterDeleteSize = leadLandibg_Obj.getAllLeadSize();
		if(beforDeleteSize!=afterDeleteSize) {
			System.out.println("Lead deleted successfully");
		}else {
			System.out.println("Lead exists Failed");
		}

	}
	@Test(groups = {"regression"})
	public  void  Create_Contact06() {

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
	@Test(groups = {"smoke"})
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
	@Test(groups = {"smoke"})
	public void  Delete_Contact08() throws InterruptedException {

		homeobj.clickOnContact();
		ContactsLandingPage contactLandingObj=new	ContactsLandingPage(webUtil);
		int beforDeleteSize = contactLandingObj.getAllContainsSize();
		contactLandingObj.clickOnCheckBox(1);
		contactLandingObj.clickOnDeleteButton();
		webUtil.alertAccept();
		webUtil.Threadsleep(5000);
		int afterDeleteSize = contactLandingObj.getAllContainsSize();
		if(beforDeleteSize!=afterDeleteSize) {
			System.out.println("Contacts deleted successfully");
		}else {
			System.out.println("Lead exists Failed");
		}

	}


	public void Create_Organization09() {
		WebUtils webUtil= new WebUtils();
		webUtil.launchBrowser("chrome");
		webUtil.get("http://localhost:8888/");
		LoginPage loginPage = new LoginPage(webUtil);
		loginPage.validlogin("admin", "admin");	
		HomePage homeobj = new HomePage(webUtil);
		homeobj.clickOnOrganization();


		WebDriver driver=	new ChromeDriver();


		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("IIT Team");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.Gravity.com");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement titel= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actu= titel.getText();
		if(actu.contains(" IIT Team - ")) {
			System.out.println("Organization created successfully");
		}else {
			System.out.println("Organization not created unsuccessfully");

		}
	}

	public void  Edit_Organization10() {


		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.sendKeys("admin");
		WebElement password= driver.findElement(By.xpath("//input[@name='user_password']"));
		password.sendKeys("admin");
		WebElement loggin= driver.findElement(By.xpath("//input[@id='submitButton']"));
		loggin.click();

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("IT Industry.");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.Gravity.com");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("IT Team Industry");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement titel= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actu= titel.getText();
		if(actu.contains(" IT Team Industry - ")) {
			System.out.println("Organization updated successfully");
		}else {
			System.out.println("Organization not updated Unsuccessfully");

		}	
	}

	public void  Delete_Organization11() throws InterruptedException {

		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.sendKeys("admin");
		WebElement password= driver.findElement(By.xpath("//input[@name='user_password']"));
		password.sendKeys("admin");
		WebElement loggin= driver.findElement(By.xpath("//input[@id='submitButton']"));
		loggin.click();

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();

		List<WebElement> allcontacts1 = driver.findElements(By.xpath("//input[@name='selected_id']"));
		int actsize=allcontacts1.size();

		driver.findElement(By.xpath("//a[text()='I T student']/ancestor::tr[@id='row_7']//input")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Alert pop = driver.switchTo().alert();
		pop.accept();
		Thread.sleep(2000);
		List<WebElement> allcontacts = driver.findElements(By.xpath("//input[@name='selected_id']"));
		int exep_size=allcontacts.size();

		Assert.assertEquals(actsize, exep_size);
		
//		if(actsize!=exep_size) {
//			System.out.println(" Organization deleted successfully");
//		}else {
//			System.out.println(" Organization not deleted Unsuccessfully");
//		}
	}

	//	public static void Create_Opportunity12() {
	//
	//		ChromeOptions opt = WebUtils.maximized();
	//		WebUtils.driver=new ChromeDriver(opt);
	//		WebUtils.get("http://localhost:8888/");
	//		WebUtils.Sendkeys("//input[@name='user_name']", "admin");
	//		WebUtils.Sendkeys("//input[@name='user_password']", "admin");
	//		WebUtils.click("//input[@id='submitButton']");
	//
	//		WebUtils.click("//a[@href='index.php?module=Potentials&action=index']");
	//		WebUtils.click("//img[@src='themes/softed/images/btnL3Add.gif']");
	//		WebUtils.Sendkeys("//input[@name='potentialname']","Gravity");
	//		WebUtils.click("//img[@src='themes/softed/images/select.gif']");
	//
	//		WebUtils.switchToWindowByURL("vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=");
	//
	//		WebUtils.click("//a[@id='1']");
	//		WebUtils.switchToWindowByURL("Potentials&action=EditView&return_action=DetailView&parenttab=Sales");
	//		WebUtils.click("//input[@class='crmbutton small save']");
	//		String Expected=" Gravity ";
	//		WebUtils.validateTextContains(Expected, "//span[@class='dvHeaderText']", " New Organization creat ");

	//		Set<String> allwin = driver.getWindowHandles();
	//		String switche="";
	//		for(String switchs:allwin) {
	//			driver.switchTo().window(switchs);
	//			if(driver.getCurrentUrl().contains("vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=")) {
	//				switche=driver.getWindowHandle();
	//				break;
	//			}}
	//		driver.switchTo().window(switche);
	//		driver.findElement(By.xpath("//a[@id='1']")).click();
	//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//
	//		WebElement titel= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	//		String actu= titel.getText();
	//		if(actu.contains(" exep -  ")) {
	//			System.out.println("Organization created successfully");
	//		}else {
	//			System.out.println("Organization not created unsuccessfully");
	//
	//		}	
	//}

	public void Convert_LeadtoOpportunity13() {

	}





	public void Create_Campaign14() {

		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);
		JavascriptExecutor jse= (JavascriptExecutor)driver;		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.sendKeys("admin");
		WebElement password= driver.findElement(By.xpath("//input[@name='user_password']"));
		password.sendKeys("admin");
		WebElement loggin= driver.findElement(By.xpath("//input[@id='submitButton']"));
		loggin.click();
		WebElement more= driver.findElement(By.xpath("//a[text()='More']"));
		jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", more);
		WebElement Campaign = driver.findElement(By.xpath("//a[@href='index.php?module=Campaigns&action=index']"));
		jse.executeScript("arguments[0].click()", Campaign);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("gravity automation");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement titel= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String til= titel.getText();
		if(til.contains("gravity automation")) {
			System.out.println("Campaign created successfully");
		}else { 

			System.out.println("Campaign not created Unsuccessfully");
		}
	}

	public void  Generate_Report15() throws InterruptedException {

		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);
		JavascriptExecutor jse= (JavascriptExecutor)driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.sendKeys("admin");
		WebElement password= driver.findElement(By.xpath("//input[@name='user_password']"));
		password.sendKeys("admin");
		WebElement loggin= driver.findElement(By.xpath("//input[@id='submitButton']"));
		loggin.click();
		WebElement more= driver.findElement(By.xpath("//a[text()='More']"));
		jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", more);
		WebElement Report = driver.findElement(By.xpath("//a[@href='index.php?module=Reports&action=index']"));
		jse.executeScript("arguments[0].click()", Report);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/reportsCreate.gif']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Set<String> switche = driver.getWindowHandles();
		String sw="";
		for(String witc:switche) {
			driver.switchTo().window(witc);
			if(driver.getCurrentUrl().contains("NewReport0&folder=0&reportmodule=Assets")) {
				sw=driver.getWindowHandle();
				break;
			}}
		driver.switchTo().window(sw);
		driver.findElement(By.xpath("//input[@name='reportname']")).sendKeys("element is not display");
		driver.findElement(By.xpath("//input[@id='next']")).click();

		driver.findElement(By.xpath("//input[@name='secondarymodule_HelpDesk']")).click();
		driver.findElement(By.xpath("//input[@name='secondarymodule_Documents']")).click();
		driver.findElement(By.xpath("//input[@id='next']")).click();
		WebElement click = driver.findElement(By.xpath("//input[@id='next']"));
		jse.executeScript("arguments[0].click()", click);
		driver.findElement(By.xpath("//optgroup[@label='Assets Asset Information']//option[@value='vtiger_crmentity:crmid:Assets_ID:crmid:I']")).click();
		driver.findElement(By.xpath("//input[@name='add']")).click();
		driver.findElement(By.xpath("//optgroup[@label='Assets Asset Information']//option[@value='vtiger_assets:product:Assets_Product_Name:product:V']")).click();
		driver.findElement(By.xpath("//input[@name='add']")).click();
		Thread.sleep(2000);
		WebElement clicknext = driver.findElement(By.xpath("//input[@id='next']"));
		jse.executeScript("arguments[0].click()", clicknext);
		driver.findElement(By.xpath("//input[@name='cb:vtiger_troubletickets:hours:Hours_SUM:2']")).click();
		driver.findElement(By.xpath("//input[@name='cb:vtiger_troubletickets:days:Days_AVG:3']")).click();
		driver.findElement(By.xpath("//input[@name='cb:vtiger_notes:filesize:File Size_MIN:4']")).click();
		driver.findElement(By.xpath("//input[@name='cb:vtiger_notes:filedownloadcount:Download Count_MAX:5']")).click();
		Thread.sleep(2300);
		WebElement next = driver.findElement(By.xpath("//input[@id='next']"));
		jse.executeScript("arguments[0].click()", next);

		WebElement select = driver.findElement(By.xpath("//select[@id='fcol0']"));
		select.click();
		Select seobj=new Select(select);
		seobj.selectByIndex(2);
		Thread.sleep(1000);
		WebElement selectbox = driver.findElement(By.xpath("//select[@id='fop0']"));
		selectbox.click();
		Select drop=new Select(selectbox);
		drop.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fval0']")).sendKeys("both are equal");
		Thread.sleep(2300);
		WebElement nextd = driver.findElement(By.xpath("//input[@id='next']"));
		jse.executeScript("arguments[0].click()", nextd);

		WebElement nextempty = driver.findElement(By.xpath("//input[@id='next']"));
		jse.executeScript("arguments[0].click()", nextempty);
		WebElement nextfilan = driver.findElement(By.xpath("//input[@id='next']"));
		jse.executeScript("arguments[0].click()", nextfilan);
	}

	public void Change_Password16() throws InterruptedException {

		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin1");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		WebElement administor =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", administor);
		driver.findElement(By.xpath("//a[@id='_my_preferences_']")).click();
		driver.findElement(By.xpath("//input[@title='Change Password [Alt+P]']")).click();

		Set<String> windows = driver.getWindowHandles();
		String swit="";
		for(String switche:windows) {
			driver.switchTo().window(switche);
			if(driver.getCurrentUrl().contains("ChangePassword&form")) {
				swit=driver.getWindowHandle();
				break;
			}}
		driver.switchTo().window(swit);
		driver.findElement(By.xpath("//input[@name='new_password']")).sendKeys("admin1");
		driver.findElement(By.xpath("//input[@name='confirm_new_password']")).sendKeys("admin1");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(4000);
		windows = driver.getWindowHandles();
		String main="";
		for(String switche:windows) {
			driver.switchTo().window(switche);
			if(driver.getCurrentUrl().contains("action=DetailView&module=Users&record=1")) {
				main=driver.getWindowHandle();
				break;
			}}
		driver.switchTo().window(main);
		WebElement administor1 =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", administor1);
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		WebElement password=driver.findElement(By.xpath("//input[@name='user_password']"));
		password.sendKeys("admin1");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();


		if(driver.getCurrentUrl().contains("index&module=Home")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}

	}
	public void Assign_LeadtoUser_17() {

		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin1");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();

	}

	public void  Add_Product_18() {

		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin1");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("Parle G");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement titel= driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		String inertext=titel.getText();
		if(inertext.contains("Parle G")) {
			System.out.println("Product added successfully");
		}else {
			System.out.println("Product is not added Unsuccessfully");
		}
	}

	public void  Create_Invoice19() throws InterruptedException {

		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);
		JavascriptExecutor jse= (JavascriptExecutor)driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.sendKeys("admin");
		WebElement password= driver.findElement(By.xpath("//input[@name='user_password']"));
		password.sendKeys("admin");
		WebElement loggin= driver.findElement(By.xpath("//input[@id='submitButton']"));
		loggin.click();
		WebElement more= driver.findElement(By.xpath("//a[text()='More']"));
		jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", more);
		WebElement Invoice = driver.findElement(By.xpath("//a[@href='index.php?module=Invoice&action=index']"));
		jse.executeScript("arguments[0].click()", Invoice);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Fast speed");
		driver.findElement(By.xpath("//input[@id='single_accountid']/ancestor::td[@class='dvtCellInfo']//img")).click();
		Set<String> AddOrganization = driver.getWindowHandles();

		for(String swit:AddOrganization) {
			driver.switchTo().window(swit);
			if(driver.getCurrentUrl().contains("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=")) {
				break;
			}
		}

		driver.findElement(By.xpath("//a[text()='Automation Pvt. Ltd']")).click();
		Alert pop = driver.switchTo().alert();
		pop.accept();

		AddOrganization = driver.getWindowHandles();
		for(String swit:AddOrganization) {
			driver.switchTo().window(swit);
			if(driver.getCurrentUrl().contains("Invoice&action=EditView&return_action=DetailView&parenttab=Sales")) {
				break;
			}
		}
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("Bhadohi");
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("Mirza Pur");

		driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
		Thread.sleep(2000);
		AddOrganization = driver.getWindowHandles();
		for(String swit:AddOrganization) {
			driver.switchTo().window(swit);
			if(driver.getCurrentUrl().contains("&select=enable&form=HelpDeskEditView&popuptype=inventory_prod&curr_row=1&return_module=Invoice&currencyid=1")) {
				break;
			}
		}
		Thread.sleep(2500);
		driver.findElement(By.xpath("//a[@id='popup_product_50']")).click();

		AddOrganization = driver.getWindowHandles();
		for(String swit:AddOrganization) {
			driver.switchTo().window(swit);
			if(driver.getCurrentUrl().contains("Invoice&action=EditView&return_action=DetailView&parenttab=Sales")) {
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys("30");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement titel= driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		String inertext=titel.getText();
		if(inertext.contains("Fast speed")) {
			System.out.println(" Invoice created successfully");
		}else {
			System.out.println(" Invoice is not created Unsuccessfully");
		}

	}
	public void  Search_Record20() throws InterruptedException {

		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=	new ChromeDriver(max);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.sendKeys("admin");
		WebElement password= driver.findElement(By.xpath("//input[@name='user_password']"));
		password.sendKeys("admin");
		WebElement loggin= driver.findElement(By.xpath("//input[@id='submitButton']"));
		loggin.click();

	}}



