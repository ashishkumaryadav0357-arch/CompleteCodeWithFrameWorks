package overriding;

import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChromBrowser implements WebDriver {

	public  void openBrowser() {
		System.out.println("Open Browser from ChromBrowser page");
	}

	public void getUrl() {
		System.out.println("Hit URL in ChromBrowser page");
		
	}

	public void getText() {
		System.out.println("Return element inner text in ChromBrowser page");
		
	}

	public void closeBrowser() {
		System.out.println("Close Browser from ChromBrowser page");
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void get(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public @Nullable String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}
}
