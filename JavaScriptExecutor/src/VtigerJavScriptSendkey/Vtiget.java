package VtigerJavScriptSendkey;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vtiget {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		JavascriptExecutor ss=(JavascriptExecutor) driver;		
		driver.get("http://localhost:8888/");
		WebElement uername = driver.findElement(By.xpath("//input[@name='user_name']"));
		ss.executeScript("arguments[0].value='admin'", uername);
		WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
		ss.executeScript("arguments[0].value='admin'", password);
		WebElement loginbutton = driver.findElement(By.xpath("//input[@id='submitButton']"));
		ss.executeScript("arguments[0].click()", loginbutton);

		WebElement administor=driver.findElement(By.xpath("//img[@src='themes/softed/images/info.PNG']"));
		ss.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", administor);
	}

}
