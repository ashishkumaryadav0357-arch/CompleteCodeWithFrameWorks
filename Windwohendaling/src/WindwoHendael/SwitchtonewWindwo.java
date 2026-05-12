package WindwoHendael;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchtonewWindwo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html\r\n");
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
	Set<String> newwindwo = driver.getWindowHandles();
	for(String hendalwind:newwindwo) {
		driver.switchTo().window(hendalwind);
		String newwindURL = driver.getCurrentUrl();
		if(newwindURL.contains("selenium")) {
			break;
		}
		
	}
	
	String title=driver.getTitle();
	if(title.equalsIgnoreCase("Selenium")) {
		System.out.println("Title is matched : "+title);
	}else {
		System.out.println("Title is not matched");
	}
	
	}
	
	

}
