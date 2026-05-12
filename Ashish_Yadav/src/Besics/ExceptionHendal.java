package Besics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionHendal {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=	new ChromeDriver();
		driver.get("URL");
		try {
		WebElement userName=driver.findElement(By.xpath(""));
		userName.sendKeys("admin");
		}catch(StaleElementReferenceException e) {
			WebElement userName=driver.findElement(By.xpath(""));
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement user = wait.until(ExpectedConditions.visibilityOf(userName));
			user.sendKeys("admin");
			e.printStackTrace();
			throw e;
		}
	}

}
