package Vtiger;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerFeedback {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		Thread.sleep(2000);
		Actions actobj=new Actions(driver);
		WebElement icon=driver.findElement(By.xpath("//img[@src='themes/softed/images/info.PNG']"));
		actobj.moveToElement(icon).build().perform();
		driver.findElement(By.linkText("Feedback")).click();

		Set <String> windows=driver.getWindowHandles();
		for(String handle:windows) {
			driver.switchTo().window(handle);
			String url= driver.getCurrentUrl();
			if(url.contains("feedback")) {
				System.out.println("complet");
				break;

			}
		}

		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(" hello I'm Ashish_ydv");
		driver.close();
	}
}
