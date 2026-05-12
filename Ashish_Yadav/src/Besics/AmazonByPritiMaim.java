package Besics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonByPritiMaim {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions max=new ChromeOptions();
		max.addArguments("--start-maximized");
		WebDriver driver=  new ChromeDriver(max);
		driver.get("https://www.amazon.in/");
		Thread.sleep(4000);
		WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("Iphone");
		WebElement searchBtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchBtn.click();

		WebElement productName = driver.findElement(By.xpath("//span[contains(text(),'iPhone 17 Pro 256 GB: 15.93 cm (6.3″)')]"));
		if(productName.getText().contains("iPhone 17 Pro 256")) {
			System.out.println(" Product Displayed ");
		}else{
			System.out.println("miss match product name");			
		}
		
		WebElement productPrice = driver.findElement(By.xpath("//span[text()='1,34,900']"));
		if(productPrice.getText().contains("1,34,900")) {
			System.out.println(" Product Price matched ");
		}else{
			System.out.println("miss match product Price");			
		}
		
		TakesScreenshot fullPage=(TakesScreenshot) driver;
		File src = fullPage.getScreenshotAs(OutputType.FILE);
		File tar=new File("C:\\Users\\Ashish\\OneDrive\\Desktop\\ScreenShort\\amazon.png"); 
		FileUtils.copyFile(src, tar);
		
		
	}

}
