package youtub;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Searching_song {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	ChromeDriver driver=	new ChromeDriver();
	driver.get("https://www.youtube.com/");
	
	driver.findElement(By.xpath("//div[@class='ytSearchboxComponentInputContainer']/div/form[@class]/input")).sendKeys("Not Guilty ");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	WebElement click = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ytSearchboxComponentSearchButton']")));
	click.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	WebElement click_onVideo = driver.findElement(By.xpath("//img[@src='https://i.ytimg.com/vi/E7ergOnpO1Q/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLCaZG9ZssHoW6XGdiUV4TvZAwcR6w']"));
	click_onVideo.click();
	
	}

}
