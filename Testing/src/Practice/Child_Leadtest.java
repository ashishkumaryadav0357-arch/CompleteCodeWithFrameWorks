package Practice;

import org.openqa.selenium.By;

public class Child_Leadtest extends Parent {
	
	public static void main(String[] args) throws InterruptedException {
		Child_Leadtest cl=new Child_Leadtest();

		cl.Lead();
	}
	public void Lead() throws InterruptedException {
		Child_Leadtest cl=new Child_Leadtest();
		cl.Login();
		Thread.sleep(2000);
		cl.driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();;
		cl.driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();;
        cl.driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ashish");
        cl.driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Yadav");
        cl.driver.findElement(By.xpath("//input[@name='company']")).sendKeys("RawBody");
        cl.driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9055637898");
        cl.driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Ashishydv@gmail.com");
        cl.driver.findElement(By.xpath("//input[@name='website']")).sendKeys("https://rawbody.com/");
cl.driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	}
	
}
