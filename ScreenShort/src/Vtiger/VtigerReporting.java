package Vtiger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerReporting {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		Actions actobj=new Actions(driver);
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		Thread.sleep(25000);
		TakesScreenshot Screenshort= (TakesScreenshot) driver;
		File source= Screenshort.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\Ashish\\OneDrive\\Desktop\\ScreenShort\\page.png");
		FileUtils.copyFile(source, target);
		
		WebElement moreElement=driver.findElement(By.xpath("//a[text()='More']"));
		actobj.moveToElement(moreElement).build().perform();
		driver.findElement(By.xpath("//a[@name='Reports']")).click();
		
		Thread.sleep(3000);
		WebElement repotScreenshrot = driver.findElement(By.xpath("//td[text()='Contacts related to Opportunities']/ancestor::table[@class='reportsListTable']"));
		Thread.sleep(3000);
		Screenshort=repotScreenshrot;
		source=Screenshort.getScreenshotAs(OutputType.FILE);
	    target = new File("C:\\Users\\Ashish\\OneDrive\\Desktop\\ScreenShort\\problemreportp.png");
		FileUtils.copyFile(source, target);

	}

}
