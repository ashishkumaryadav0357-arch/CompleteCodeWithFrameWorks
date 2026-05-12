package Parentclass_Basetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class OrgTest_Child extends Parent_class {

	public static void main(String[] args) throws InterruptedException {
		OrgTest_Child click=new OrgTest_Child();
		click.organizatoin();

	}
	public void organizatoin() throws InterruptedException {
		login();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("I T student");
		WebElement select_Industry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select dropdown = new Select(select_Industry);
		dropdown.selectByVisibleText("Education");
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		Thread.sleep(2000);
		logout();
	}
}
