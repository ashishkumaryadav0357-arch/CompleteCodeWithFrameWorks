package org.eva.vtiger.utils;

//import java.security.PublicKey;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class UtilityScenario extends WebUtils {//extends WebElementUtils WebDriverUtils

	//static WebDriver driver;

	//	public Utility(WebDriver driver) {
	//		driver=driver;
	//	}
		public static void main(String[] args) {
			Login_Test01();
		}

	public static void Login_Test01() {
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
		
		String Actu=driver.getTitle();
		if(Actu.contains("Home")) {
			System.out.println("page is verify");
		}else {
			System.out.println("page is not verify");
		}
	}
	public void  Logout_Test02() {

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

		WebElement Profile_icon= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));	
		jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", Profile_icon);
	driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		String exep="vtiger CRM 5 - Commercial Open Source CRM";
		String Actu=driver.getTitle(); 
		if(Actu.equalsIgnoreCase(exep)) {
			System.out.println(" User successfully logged in and dashboard displayed");
		}else {
			System.out.println(" User unsuccessfully logged in and dashboard is not displayed");
		}
	}


	public void Create_NewLead03() throws InterruptedException {

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

		WebElement lead_module=driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']"));
		lead_module.click();
		WebElement add_lead=driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		add_lead.click();

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("jayyy");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gupta");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Gravity Automation Pvt. Ltd");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		Navigation navi = driver.navigate();
		navi.back();
		Thread.sleep(2000);
		navi.back();
		String str="Gupta";
		WebElement actualValue= driver.findElement(By.xpath("//a[text()='Gupta']"));
		String text=actualValue.getText();
		if(text.equals(str)) {
			System.out.println("Shi ba");
		}else {
			System.out.println("Nahi shi ba");
		}
	}

	public void  Edit_Lead04() {

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

		WebElement lead_module=driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']"));
		lead_module.click();
		WebElement add_lead=driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		add_lead.click();

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("janvi");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sharma");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(" Automation Pvt. Ltd");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		driver.findElement(By.xpath("//input[@name='Edit']")).click();
		WebElement lead_name= driver.findElement(By.xpath("//input[@name='lastname']"));
		lead_name.clear();
		lead_name.sendKeys("dubey");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		WebElement update= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actu=update.getText();
		String exep="dubey janvi -  Lead Information";
		if(actu.equals(exep)) {
			System.out.println("Lead updated successfully");
		}else {
			System.out.println("Lead not updated unsuccessfully");
		}}
	public void  Delete_Lead05() throws InterruptedException {

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

		WebElement lead_module=driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']"));
		lead_module.click();
		WebElement add_lead=driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		add_lead.click();

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("paro");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Varma");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(" Automation Pvt. Ltd");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Navigation navi = driver.navigate();
		navi.back();
		navi.back();
		List<WebElement> All_lead = driver.findElements(By.xpath("//td[contains(text(),'LEA')]"));
		int Beforsize = All_lead.size();
		driver.findElement(By.xpath("//a[text()='paro']")).click();
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		Alert pop = driver.switchTo().alert();
		pop.accept();
		Thread.sleep(2500);
		List<WebElement> All_lead2 = driver.findElements(By.xpath("//td[contains(text(),'LEA')]"));
		int Aftersize = All_lead2.size();

		if(Beforsize!=Aftersize) {
			System.out.println("Contact deleted successfully");
		}else {
			System.out.println("Contact exists Failed");
		}

	}

	public void  Create_Contact06() {

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


		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Smriti");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("dubey");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		WebElement titel= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String Actu=titel.getText(); 
		String exe="dubey Smriti ";
		if(Actu.contains(exe)) {
			System.out.println("Contact created successfully");
		}else {
			System.out.println("Contact not created unsuccessfully");
		}
	}

	public void Edit_Contact07() {

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

		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Smriti");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("dubey");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
		WebElement contants_update=driver.findElement(By.xpath("//input[@name='firstname']"));
		contants_update.clear();
		contants_update.sendKeys("jaya");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		WebElement titel= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String Actu=titel.getText();
		String exe="dubey jaya";
		if(Actu.contains(exe)) {
			System.out.println(" Contact updated successfully");
		}else {
			System.out.println(" Contact not updated unsuccessfully");
		}
	}
	public void  Delete_Contact08() throws InterruptedException {


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

		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Anannya");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("panday");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Navigation page = driver.navigate();
		page.back();
		page.back();

		List<WebElement> allcontacts1 = driver.findElements(By.xpath("//input[@name='selected_id']"));
		int allsize_act=allcontacts1.size();
		driver.findElement(By.xpath("//a[text()='Anannya']/ancestor::tr[@id='row_25']//input")).click();
		driver.findElement( By.xpath("//input[@class='crmbutton small delete']")).click();
		Alert pop= driver.switchTo().alert();
		pop.accept();
		Thread.sleep(2000);
		List<WebElement>allcontacts = driver.findElements(By.xpath("//input[@name='selected_id']"));
		int allsize_exep=allcontacts.size();

		if(allsize_act!=allsize_exep) {
			System.out.println("Contact deleted successfully");
		}else {
			System.out.println("Contact exists Failed");
		}
	}
	public void Create_Organization09() {


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

		if(actsize!=exep_size) {
			System.out.println(" Organization deleted successfully");
		}else {
			System.out.println(" Organization not deleted Unsuccessfully");
		}
	}

	public void Create_Opportunity12() {

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

		driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("exep");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

		Set<String> allwin = driver.getWindowHandles();
		String switche="";
		for(String switchs:allwin) {
			driver.switchTo().window(switchs);
			if(driver.getCurrentUrl().contains("vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=")) {
				switche=driver.getWindowHandle();
				break;
			}}
		driver.switchTo().window(switche);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement titel= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actu= titel.getText();
		if(actu.contains(" exep -  ")) {
			System.out.println("Organization created successfully");
		}else {
			System.out.println("Organization not created unsuccessfully");

		}	}

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

//


