package practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeAnnotations {

	@Test(priority = 2,groups = {"smoke"})
	public void Americatc1() {
		System.out.println("HelloAmerica");
	}
	
	@Test(priority = 1,groups = {"smoke"})
	public void India() {
		System.out.println("Namaste");
	}
	
	@BeforeMethod
	public void UP() {
		System.out.println("browserLaunch");
	}
	
	public void MP() {
		System.out.println("heyyyy");
	}
	
	@Test(priority = 2)
	public void japantc2() {
		System.out.println("HelloJapan");
	}
	
	@AfterMethod
	public void close() {
		System.out.println("browserclose");
	}
	
}
