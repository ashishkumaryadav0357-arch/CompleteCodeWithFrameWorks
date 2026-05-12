package Parentclass_Basetesting;

import org.openqa.selenium.By;

import Practice.Child_ContactTest;

public class ContactTest_Child extends Parent_class{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Child_ContactTest cli=	new Child_ContactTest();
		cli.contacts();
	}
	public void contacts() throws InterruptedException {
		login();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ashish");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("yadav");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9044523630");
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
logout();
	
	
	}
		
	

}
