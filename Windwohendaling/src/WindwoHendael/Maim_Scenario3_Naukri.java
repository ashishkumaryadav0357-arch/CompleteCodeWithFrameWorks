package WindwoHendael;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Maim_Scenario3_Naukri {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://www.naukri.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Got it']")).click();
		driver.findElement(By.xpath("//span[@title='Remote']")).click();

		Set<String> handleValues = driver.getWindowHandles();
		for(String handleVal:handleValues) {
			driver.switchTo().window(handleVal);
			if(driver.getCurrentUrl().contains("remote")) {
				break;
			}
		}
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}
}