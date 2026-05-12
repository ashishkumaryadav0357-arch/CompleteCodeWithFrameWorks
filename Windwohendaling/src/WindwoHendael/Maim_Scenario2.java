package WindwoHendael;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Maim_Scenario2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		String actualtitle=driver.getTitle();
		if(actualtitle.equals("vtiger CRM 5 - Commercial Open Source CRM")) {
			System.out.println("Home page Title is visible >> Matched : ");
		}else {
			System.out.println("Home page title is not visible >> Mismatched");
		}
		
		Actions actobj=new Actions(driver);
		WebElement icon=driver.findElement(By.xpath("//img[@src='themes/softed/images/info.PNG']"));
		actobj.moveToElement(icon).build().perform();
		driver.findElement(By.linkText("Help")).click();
		
		 Set<String> switchwin = driver.getWindowHandles();
		 for(String helpwindwo:switchwin) {
			 driver.switchTo().window(helpwindwo);
			String curentUrl = driver.getCurrentUrl();
			 if(curentUrl.contains("wiki")) {
				 System.out.println("help page is open");
				break; 
			 }
			 }
		String acttitle= driver.getTitle();
		if(acttitle.equals("vtiger.com | 522: Connection timed out")) {
			System.out.println("Help page title verify >>Passed");
		}else {
			System.out.println("Help page title not verify >>Filed");
		}
driver.close();
	}

}
