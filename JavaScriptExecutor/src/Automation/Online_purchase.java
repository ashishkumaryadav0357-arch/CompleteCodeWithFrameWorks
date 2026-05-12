package Automation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Online_purchase {

	public static void main(String[] args) throws IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--start-maximized");
		
		WebDriver driver=new ChromeDriver(option);
		JavascriptExecutor jsc= (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://www.amazon.in/");

		WebElement searchbox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		jsc.executeScript("arguments[0].value='vivo'", searchbox);
		WebElement searchpoint=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));	
		jsc.executeScript("arguments[0].click()",searchpoint);

		WebElement click=driver.findElement(By.xpath("//span[text()='T4x (Pronto Purple, 6GB + 128GB)']"));
		jsc.executeScript("arguments[0].click()", click);
		
		 Set<String> switchs = driver.getWindowHandles();
		 String first="";
		for(String hendal:switchs) {
			driver.switchTo().window(hendal);
			if(driver.getCurrentUrl().contains("1770647916")) {
				first=driver.getWindowHandle();
				break;
			}
			}
	    driver.switchTo().window(first);
	WebElement addtocart= driver.findElement(By.xpath("//div[@id='a-accordion-auto-6']/descendant::input[@id='add-to-cart-button']"));
	jsc.executeScript("arguments[0].click()", addtocart);
	
	WebElement Gotocart=driver.findElement(By.xpath("//a[@href='/cart?ref_=sw_gtc']"));
	TakesScreenshot element=Gotocart;
	File src=element.getScreenshotAs(OutputType.FILE);
	File target=new File("C:\\Users\\Ashish\\OneDrive\\Desktop\\ScreenShort\\gotocart.png");
	FileUtils.copyFile(src, target);
	jsc.executeScript("arguments[0].click()", Gotocart);
	
	WebElement proceed_tobuy=driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
	jsc.executeAsyncScript("arguments[0].click()", proceed_tobuy);
	
	
	
	}

}
