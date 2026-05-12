package Parentclass_Basetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Parent_class {
ChromeDriver driver;
	
	public void login() {
		driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

	}
	public void logout() throws InterruptedException {
		Actions actobj=	new Actions(driver);
		WebElement singout = driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/user')]"));
		actobj.moveToElement(singout).build().perform();
		Thread.sleep(2000);
		WebElement out_click = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		actobj.click(out_click).build().perform();
	}
}
