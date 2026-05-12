package Automation;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerTovalidatorbyRahul_sir {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		String pagesource = driver.getPageSource();
		String Actu=driver.getTitle(); 
		if(Actu.equalsIgnoreCase(driver.getTitle())) {
			System.out.println("page is verify");
		}else {
			System.out.println("page is not verify");
		}
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		driver.get("https://validator.w3.org/");
		driver.findElement(By.xpath("//a[@href='#validate_by_input']")).click();
		WebElement inputbox= driver.findElement(By.xpath("//textarea[@id='fragment']"));
		jse.executeScript("arguments[0].value = arguments[1];", inputbox,pagesource);
	}

}
