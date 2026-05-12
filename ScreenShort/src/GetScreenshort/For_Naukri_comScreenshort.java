package GetScreenshort;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class For_Naukri_comScreenshort {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();

		driver.get(" https://www.naukri.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Got it']")).click();

		TakesScreenshot Scrensort=  (TakesScreenshot) driver;
		File sourcefile = Scrensort.getScreenshotAs(OutputType.FILE);
		File fil = new File("C:\\Users\\Ashish\\OneDrive\\Desktop\\ram");
		boolean check=fil.mkdir();
		if(check) {
			System.out.println("Ba");
		}else {
			System.out.println("Naye Ba");
		}
		File sourcefile1 = new File("C:\\Users\\Ashish\\OneDrive\\Desktop\\ram\\sandeep.png");
		FileUtils.copyFile(sourcefile, sourcefile1);

		driver.findElement(By.xpath("//span[@title='Remote']")).click();
		Set<String> handleValues = driver.getWindowHandles();
		for(String handleVal:handleValues) {
			driver.switchTo().window(handleVal);
			if(driver.getCurrentUrl().contains("remote")) {
				break;
			}
		}
		Thread.sleep(2000);
		//driver.switchTo().window(remothen);

		TakesScreenshot screensort=  (TakesScreenshot) driver;
		File source = screensort.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\Ashish\\OneDrive\\Desktop\\ScreenShort\\vimal chaccha.png");
		FileUtils.copyFile(source, target);


		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(1000);

		WebElement register= driver.findElement(By.xpath("//a[text()='Register']"));

		screensort= register;
		source = screensort.getScreenshotAs(OutputType.FILE);
		target = new File("C:\\Users\\Ashish\\OneDrive\\Desktop\\ScreenShort\\jay chaccha.png");
		FileUtils.copyFile(source, target);

	}

}
