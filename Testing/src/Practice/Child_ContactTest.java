package Practice;

import org.openqa.selenium.By;

public class Child_ContactTest extends Parent {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Child_ContactTest cli=	new Child_ContactTest();
		cli.contacts();
	}
	public void contacts() throws InterruptedException {
		Parent cli=new Child_ContactTest();
		cli.Login();
		Thread.sleep(2000);
		cli.driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		cli.driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		cli.driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ashish");
		cli.driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ydv");
		cli.driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9044523630");
		cli.driver.findElement(By.xpath("//input[@accesskey='S']")).click();

	
	
	}
}
