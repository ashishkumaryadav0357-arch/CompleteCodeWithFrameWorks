package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Child_Org_test extends Parent {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Child_Org_test click=new Child_Org_test();
		click.organizatoin();

	}
	public void organizatoin() throws InterruptedException {
		Parent click=new Child_Org_test();
		click.Login();
		Thread.sleep(2000);;
		click.driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		click.driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		click.driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("I T");
		WebElement select_Industry = click.driver.findElement(By.xpath("//select[@name='industry']"));
		Select dropdown = new Select(select_Industry);
		dropdown.selectByVisibleText("Education");
		click.driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	}
}
