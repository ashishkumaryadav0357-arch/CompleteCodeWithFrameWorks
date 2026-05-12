package org.ash.amazon.utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {

private WebDriver driver;
	
	
	/**
	 * Returns the current WebDriver instance.
	 * This method is used to get driver object in page classes
	 * for PageFactory initialization and element actions.
	 * @return WebDriver instance
	 */
	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * This method is used to launch the browser.
	 * It accepts browser name as input and opens the browser.
	 * Supports Chrome, Firefox and Edge browser.
	 * If wrong browser name is given, it shows message.
	 * After opening browser, window will be maximized.
	 *
	 * @param browsername name of the browser to launch
	 */
	public  void launchBrowser(String browesrname) {
		if(browesrname.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browesrname.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browesrname.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println("Invalid Argument >>>"+browesrname);
		}
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to open the specified URL in the browser.
	 *
	 * @param URL is the web address to be opened in the browser
	 * @throws Exception if any unexpected error occurs while loading the URL
	 */
	public  void hitURL(String URL) {
		try {
			driver.get(URL);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * This method is used to get the current URL of the web page.
	 * @return String - returns the current URL of the page
	 * @throws Exception if any error come while retrieving the URL
	 */
	public  String getCurrentUrl() {
		try {
			String gencurentUrl=driver.getCurrentUrl();
			System.out.println("Current URL: " + gencurentUrl);
			return gencurentUrl;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * This method is used to get the title of the current web page.
	 * 
	 * @return String - returns the title of the current page
	 * @throws Exception if any error come while fetching the title
	 */
	public  String getTitle() {
		try {
			String title=driver.getTitle();
			System.out.println("Page title: " + title);
			return title;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	/** SendKeys is used to enter data into an input field
	 * @param xpath is used to locate specific element on the Web_page 
	 * @param value the text to enter into the input box
	 *  @throws Exception if any unexpected error come
	 */
	public  void sendkeys(WebElement weElement,String sendvalu) {
		try {weElement.clear();
		weElement.sendKeys(sendvalu);
		System.out.println("text  "+sendvalu+"   sent value successfully");
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(30,weElement );
			weElement.sendKeys(sendvalu);
		}catch(StaleElementReferenceException e) {
			System.out.println("stale element so re finding and retrying sendkeys....."+e.getMessage());
			weElement.sendKeys(sendvalu);
		}catch(ElementNotInteractableException e) {
			System.out.println("Element not interactable ,attempting javascrip sendkeys...."+e.getMessage());
			jse_Sendkeys(weElement, sendvalu);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}	}

	/**
	 * Clicks on the given WebElement
	 * @param webElement the WebElement to be clicked
	 * @throws Exception if any unexpected error come
	 * */
	public  void click(WebElement weElement) {
		try {
			weElement.click();
			System.out.println("element clicked successfully-");
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(180, weElement);
			weElement.click();
		}catch(ElementNotInteractableException e) {
			System.out.println("Element not interactable ,attempting javascript click..."+e.getMessage());
			jse_click(weElement);
		}catch(StaleElementReferenceException e){
			System.out.println("stale Element ,refinding and retrying click"+e.getMessage());
			weElement.click();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * It's use for  return the visible Text from the WebElelement 
	 * 
	 * @param  xpath is used to locate specific element on the Web_page
	 * @return It is return the object of String class
	 *  @throws Exception if any unexpected error come
	 * */
	public   String getText(WebElement webElement) {
		try {
			String text = webElement.getText();
			System.out.println("text fetched successfully:and text is --"+text);
			return text;
		}catch(NoSuchElementException e) {
			System.out.println("NoSuchElementException:element is not found may be locator is wrong or take time for page load or may be dynamic elemenet ");
			expWaitvisibilityOf(30,webElement);
			String text = webElement.getText();
			return text;
		}catch(StaleElementReferenceException e) {
			System.out.println("stale element :DOM updated or page refreshed locating element again ");
			String text = webElement.getText();
			return text;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * It return true if element is visible ,otherwise false
	 *  @param  xpath is used to locate specific element on the Web_page
	 * @return Is_displayed method return the value of boolean type 
	 * @throws Exception if any unexpected error come
	 * */
	public  boolean isDisplayed(WebElement webElement) {
		try {
			boolean display=webElement.isDisplayed();
			System.out.println("Element is displayed");
			return display;
		}catch(NoSuchElementException e) {
			System.out.println("NoSuchElementException: element not found when checking display status ");
			expWaitvisibilityOf(30, webElement);
			boolean	display = webElement.isDisplayed();			
			return display;
		}catch(StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException: stale element in displaying ,retrying");
			boolean	display = webElement.isDisplayed();
			return display;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}
	
	/**
	 * Is_Enable method used to check the element is enable or not  
	 *  @param  xpath is used to locate specific element on the Web_page
	 * @return Is_Enabled method return the value of boolean type
	 * @throws Exception if any unexpected error come
	 * */
	public  boolean isEnabled(WebElement webElement) {
		try {
			System.out.println("Checking element enabled status...");
			boolean Enabel = webElement.isEnabled();
			return Enabel;
		}catch(NoSuchElementException e) {
			System.out.println("NoSuchElementException: Element is not found on page when checking enable status: ");
			expWaitvisibilityOf(30, webElement);
			boolean	Enabel = webElement.isEnabled();			
			return Enabel;
		}catch(StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException: Element stale when check enable");
			boolean	Enabel = webElement.isEnabled();
			return Enabel;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}
	
	public  WebElement expWaitvisibilityOf(int time,WebElement webElement) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
			WebElement we_wait=wait.until(ExpectedConditions.visibilityOf(webElement));
			return we_wait;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}	}
	
	/***JavaScriptExcutor***/
	
	/**
	 * This method is used to perform click  on hidden element where webElement and Action class method 
	 * not working that we using JavaScriptExecutor with the given XPath
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @throws Exception if any unexpected error occurs
	 */
	public  void jse_click(WebElement weElement) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		try {		
			jse.executeScript("arguments[0].click();", weElement);
			System.out.println("JavaScript click perform successfully on element ");
		}catch(NoSuchElementException e) {
			System.out.println("no such element : js click retrying.....");
			expWaitvisibilityOf(60, weElement);
			jse.executeScript("arguments[0].click();", weElement);
		}catch(StaleElementReferenceException e) {
			System.out.println("stale element : js click retrying.....");
			jse.executeScript("arguments[0].click();", weElement);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}


	}
	/**
	 * This method is used to enter text into an element 
	 * using JavaScriptExecutor with the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @param value is the text to be entered into the element
	 * @throws Exception if any unexpected error occurs
	 */
	public  void jse_Sendkeys(WebElement weElement,String value) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		try {
			jse.executeScript("arguments[0].value = arguments[1];",weElement, value);
			System.out.println("javascript sendkeys performed successfully on elemnet ");
		}catch(NoSuchElementException e) {
			System.out.println("StaleElementReferenceException: stale element retrying ...");
			expWaitvisibilityOf(60, weElement);
			jse.executeScript("arguments[0].value = arguments[1];",weElement, value);
		}catch(StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException: stale element retrying ...");
			jse.executeScript("arguments[0].value = arguments[1];",weElement, value);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/***<\ Switch Window />***/
	
	/**
	 * This method switches the driver to the window whose URL contains the given value.
	 *
	 * @param currentWindowURL part of the URL used to identify the target window
	 * @throws Exception if switching to the window fails
	 */
	public  void switchToWindowByURL(String expectedWindowURL) {
		try {
			Set<String> handleValue =driver.getWindowHandles();
			for(String handle:handleValue) {
				driver.switchTo().window(handle);
				if(driver.getCurrentUrl().contains(expectedWindowURL)) {
					break;
				}}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method switches the driver to the window whose title
	 * contains the specified text.
	 *
	 * @param title part of the title used to identify the window
	 * @throws Exception if window switching fails
	 */
	public  void switchToWindowByTitle(String expectedTitle) {
		try {
			Set<String> handleValue =driver.getWindowHandles();
			for(String handle:handleValue) {
				driver.switchTo().window(handle);
				if(driver.getTitle().contains(expectedTitle)) {
					break;
				}}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/***<Validation>***/
	 
	/**
	 * This method checks whether current URL contains expected text.
	 * 
	 * If actual URL contains expected text → IF block → PASS
	 * If actual URL does not contain expected text → ELSE block → FAIL
	 *
	 * @param expectedText expected text in URL
	 * @param message validation message
	 */
	public  void validateUrlContains(String ExpectedUrl,String massage) {
		String ActualUrl=driver.getCurrentUrl();
		if(!ActualUrl.contains(ExpectedUrl)) {
			String errormassage=massage+" --Expected Url : "+ExpectedUrl+" --Actual Url : "+ActualUrl;
			System.out.println("Validation Failed "+errormassage);
			throw new AssertionError(errormassage);
		}
		System.out.println("Validation Passed "+massage);
	}
	
	/**
	 * This method checks whether element text is equal to expected text.
	 * 
	 * If text is equal → IF block → PASS
	 * If text is not equal → ELSE block → FAIL
	 *
	 * @param webElement element to get text
	 * @param expectedText expected text
	 * @param message validation message
	 */
	public  void validateTextequals(String expectedText,WebElement webElementActual,String message) {
		String actualText=getText(webElementActual);
		if(!actualText.equals(expectedText)) {
			String errormassage=message+" --Expected Text : "+expectedText+" --Actual Text : "+actualText;
			System.out.println("Validation Failed "+errormassage);
			throw new AssertionError(errormassage);
		}
		System.out.println("Validation Passed "+message);
	}
	
	/**
	 * This method checks whether page title contains expected text.
	 * 
	 * If actual title contains expected text → IF block → PASS
	 * If actual title does not contain expected text → ELSE block → FAIL
	 *
	 * @param expectedText expected text in title
	 * @param message validation message
	 */
	public  void validateTitleContains(String ExpectedTitle,String massage) {
		String ActualTitle=getTitle();
		if(ActualTitle.contains(ExpectedTitle)) {
			System.out.println("Validation passed '"+massage);
		}else {
			String errormassage=massage+" --Expected Title  ' "+ExpectedTitle+" Actual Title  ' "+ActualTitle;
			System.out.println("Validation failed "+massage);
			throw new AssertionError(errormassage);
		}	
	}
}
