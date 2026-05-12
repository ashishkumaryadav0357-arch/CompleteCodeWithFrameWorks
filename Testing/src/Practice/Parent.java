package Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Parent {
	 ChromeDriver driver;
public  void Login() {
	
	ChromeOptions wee=new ChromeOptions();
	wee.addArguments("--start-maximized");
	driver=new ChromeDriver(wee);
	
	driver.get("http://localhost:8888");
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	
}
}
