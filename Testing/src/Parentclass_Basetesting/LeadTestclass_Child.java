package Parentclass_Basetesting;

import org.openqa.selenium.By;


public class LeadTestclass_Child extends Parent_class {

	public static void main(String[] args) throws InterruptedException {
		LeadTestclass_Child cll=new LeadTestclass_Child();
		cll.Lead();

	}
	public void Lead() throws InterruptedException {
		login();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();;
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();;
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ashish");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Yadav");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("RawBody");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9055637898");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Ashishydv@gmail.com");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("https://rawbody.com/");
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		Thread.sleep(2000);
		logout();
	}
}
