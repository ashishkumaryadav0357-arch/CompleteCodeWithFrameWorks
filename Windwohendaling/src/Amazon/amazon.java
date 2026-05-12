package Amazon;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class amazon {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver =new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(" new vivo phone");
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click(); 
		driver.findElement(By.xpath("//span[contains(text(),'V60 5G (Auspicious Gold, 8GB RAM, 256GB Storage) with No Cost EMI/Additional Exchange Offers')]")).click();
		
		Set<String> hendelwin=driver.getWindowHandles();
		for(String nextwin:hendelwin) {
			driver.switchTo().window(nextwin);
			
			if(driver.getCurrentUrl().contains("B0FHWNNV2P")) {
			System.out.println("hello found");
				break;
			}}


		WebElement details = driver.findElement(By.xpath("//a[text()='Details']"));
		details.click();
		
		hendelwin=driver.getWindowHandles();
		String	detailsVal="";
		for(String nextwin:hendelwin) {
			driver.switchTo().window(nextwin);
			String urlDetails=driver.getCurrentUrl();
			if(urlDetails.contains("customer")) {
				detailsVal=driver.getWindowHandle();
				break;
			}}

		driver.switchTo().window(detailsVal);
		driver.findElement(By.xpath("//a[text()=' Terms and Conditions']")).click();
		
		hendelwin=driver.getWindowHandles();
		String	detailsVal1="";
		for(String nextwin:hendelwin) {
			driver.switchTo().window(nextwin);
			String urlDetails=driver.getCurrentUrl();
			if(urlDetails.contains("202085130")) {
				detailsVal=driver.getWindowHandle();
				break;
			}}
		driver.switchTo().window(detailsVal1);
		String ActtermsWindow=driver.getCurrentUrl();
		String ExptermsWindow="https://www.amazon.in/gp/help/customer/display.html?nodeId=202085130";
		if(ActtermsWindow.contains(ExptermsWindow)) {
			System.out.println("Hello i am at terms_condition page");
		}else {
			System.out.println("Hello i am not at terms_condition page");

		}

		hendelwin=driver.getWindowHandles();
		for(String nextwin:hendelwin) {
			driver.switchTo().window(nextwin);
			String titel=driver.getCurrentUrl();
			if(titel.contains("B0FHWNNV2P")) {
				detailsVal=driver.getWindowHandle();
				break;
			}}
		driver.switchTo().window(detailsVal);
		WebElement addcart = driver.findElement(By.xpath("(//span[@id='submit.add-to-cart-announce']/preceding-sibling::input[@id='add-to-cart-button'])[2]"));
		addcart.click();

	}}
