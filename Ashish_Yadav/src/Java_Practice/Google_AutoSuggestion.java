package Java_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_AutoSuggestion {
  
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")).sendKeys("selenium");
		Thread.sleep(1000);
		List<WebElement> search= driver.findElements(By.xpath("//div[@class='wM6W7d']"));
		for(int i=0;i<search.size();i++) {
			
		WebElement re=search.get(i);
		String text=re.getText();
		System.out.println(text);
		//re.click();
		}
	}
}
