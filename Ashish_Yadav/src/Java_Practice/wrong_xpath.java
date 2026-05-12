package Java_Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class wrong_xpath {
	
public static void main(String[] args) {
	

	WebDriver driver=new ChromeDriver();

	driver.get("http://localhost:8888/");

	WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
	username.sendKeys("admin");
	WebElement password= driver.findElement(By.xpath("//input[@name='userpassword']"));
	password.sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();

}}
