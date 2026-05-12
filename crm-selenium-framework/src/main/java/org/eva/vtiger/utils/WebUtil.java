package org.eva.vtiger.utils;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebUtil {

	public   WebDriver driver;


	/**
	 * Opens the given URL in the browser.
	 * This method is used to navigate to application URL.
	 * @param url Application URL to open
	 */
	public  void openURL(String url) {
		driver.get(url);
	}

	/**
	 * Returns the current WebDriver instance.
	 * This method is used to get driver object in page classes
	 * for PageFactory initialization and element actions.
	 * @return WebDriver instance
	 */
	public   WebDriver getDriver() {
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
	public  void browserlaunch(String browsername) {
		if(browsername.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println("Invalid browser name-"+browsername);

		}
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to send text into input field.
	 * It takes xpath and text as input.
	 * First it finds the element using xpath.
	 * Then it clears old value and sends new text.
	 * Exception handling is used to avoid failure.
	 * If element is not interactable or stale, it retries.
	 *
	 * @param xpath xpath of the element
	 * @param text value to be entered
	 */
	public  void sendKeys(WebElement webElement,String data ) {
		webElement.clear();
		webElement.sendKeys(data);
		try{webElement.clear();
		webElement.sendKeys(data);
		System.out.println("text  "+data+"   sent value successfully");
		}catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable ,attempting javascrip sendkeys...."+e.getMessage());
			//jsSendKeys(webElement,data);
		}
		catch(StaleElementReferenceException e){
			System.out.println("stale element so re finding and retrying sendkeys....."+e.getMessage());
			waitForMillis(1000);
			webElement.sendKeys(data);//recursive retry
		}catch (Exception e) {
			System.out.println("unexpected exception during sendkeys:  "+e.getMessage());

		}

	}
	/**
	 * Gets the page title
	 * @return Page title
	 */
	public  String getPageTitle() {
		try {
			String title = driver.getTitle();
			System.out.println("Page title: " + title);
			return title;
		} catch (Exception e) {
			System.out.println("ERROR: Failed to get page title: " + e.getMessage());
			throw new RuntimeException("Failed to get page title", e);
		}
	}

	/**
	 * Gets the current URL
	 * @return Current URL
	 */
	public  String getCurrentUrl() {
		try {
			String url = driver.getCurrentUrl();
			System.out.println("Current URL: " + url);
			return url;
		} catch (Exception e) {
			System.out.println("ERROR: Failed to get current URL: " + e.getMessage());
			throw new RuntimeException("Failed to get current URL", e);
		}
	}
	/**
	 * Clicks on the provided WebElement with comprehensive exception handling.
	 * Includes retry mechanism and can use JavaScript click for certain exceptions
	 * like StaleElementReferenceException or ElementNotInteractableException.
	 *
	 * @param element The WebElement to be clicked
	 */
	public  void click(WebElement webElement) {
		try {
			webElement.click();
			System.out.println("element clicked successfully-");
		}catch (ElementClickInterceptedException e) {
			System.out.println("Element not interactable ,attempting javascript click..."+e.getMessage());
			waitForMillis(2000);
			jsclick(webElement);
		}catch(StaleElementReferenceException e)  {
			System.out.println("stale Element ,refinding and retrying click"+e.getMessage());
		}catch (Exception e) {
			System.out.println("unexpected exception during click---+"+e.getMessage());
		}
	}
	public void mouseOver(WebElement element) {
		try {
			Actions act = new Actions(getDriver());
			act.moveToElement(element).perform();
			System.out.println("Mouse over performed");
		} catch (Exception e) {
			System.out.println("Mouse over failed");
		}
	}
	public  String getText(WebElement webElement) {
		String text=null;
		try {
			text=webElement.getText();
			System.out.println("text fetched successfully:and text is --"+text);
		}catch (NoSuchElementException exception) {
			System.out.println("NoSuchElementException:element is not found may be locator is wrong or take time for page load or may be dynamic elemenet ");
			waitForMillis(1000);
			text=webElement.getText();
		}catch (StaleElementReferenceException e) {
			System.out.println("stale element :DOM updated or page refreshed locating element again ");
			try {
				waitForMillis(2000);
				text=webElement.getText();
			}catch(StaleElementReferenceException retrye) {
				System.out.println("stale element :DOM updated or page refreshed, retry failed due to stale element again ");
			}
		}catch(ElementNotInteractableException e) {
			System.out.println("ElementNotInteractableException: element is present in DOM but not interactable");

		}catch (TimeoutException e) {
			System.out.println("TimeoutException: operation timeoutwhile fetching Text ");

		}catch (Exception e) {
			System.out.println("unexpected exception while fetching text : "+e.getMessage());
		}
		return text;
	}



	public  boolean isEnabled(WebElement webElement) {
		boolean enable=false;
		try {
			enable=webElement.isEnabled();
			System.out.println("element is enable ");
		}catch(NoSuchElementException e) {
			System.out.println("NoSuchElementException: Element is not found on page when checking enable status: ");

		}catch(StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException: Element stale when check enable");
			waitForMillis(1000);
			isEnabled(webElement);//recursive retry
		}catch(Exception e) {
			System.out.println("Unexpected exception: while usinf isenabled");
		}
		return enable;
	}



	/*Check display element on page of desired webElement
	 * handles common exception like NoSuchElementException and StaleElementRefrenceException
	 * @param WebElement:The webElement to check visibility
	 * @return true if the element is display otherwise 
	 */


	public  boolean isDisplayed(WebElement webElement) {
		boolean display=false;//default false
		try {
			display=webElement.isDisplayed();
			System.out.println("Element is displayed");
		}catch(NoSuchElementException e) {
			System.out.println("NoSuchElementException: element not found when checking display status ");
		}catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException: stale element in displaying ,retrying");
			waitForMillis(1000);
			isDisplayed(webElement);//recursive retry
		}catch (Exception e) {
			System.out.println("Exception: failed to check display status-"+e.getMessage());
		}
		return display;
	}
	/**
	 * Checks if a specific option exists in the dropdown
	 * @param xpath XPath of the dropdown element
	 * @param optionText Text of the option to check
	 * @return true if option exists, false otherwise
	 */
	public  boolean isDropdownOptionPresent(WebElement webElement, String optionText) {
		try {
			List<String> options = getAllDropdownOptions(webElement);
			boolean exists = options.contains(optionText);
			System.out.println("Option '" + optionText + "' exists in dropdown: " + exists);
			return exists;
		} catch (Exception e) {
			System.out.println("ERROR: Failed to check dropdown option: " + e.getMessage());
			return false;
		}
	}


	/**
	 * Gets all available options from a dropdown
	 * @param xpath XPath of the dropdown element
	 * @return List of option texts
	 */
	public  List<String> getAllDropdownOptions(WebElement webElement) {
		try {
			Select dropdown = new Select(webElement);
			List<WebElement> options = dropdown.getOptions();
			List<String> optionTexts = options.stream()
					.map(WebElement::getText)
					.collect(java.util.stream.Collectors.toList());
			System.out.println("Found " + optionTexts.size() + " options in dropdown with XPath: ");
			return optionTexts;
		} catch (Exception e) {
			System.out.println("ERROR: Failed to get dropdown options: " + e.getMessage());
			throw new RuntimeException("Failed to get dropdown options: " +e);
		}
	}
	/**
	 * Performs a click on the provided WebElement using JavaScript.
	 * This can be used when normal Selenium click fails due to overlays, 
	 * ElementNotInteractableException, or other issues.
	 * 
	 * @param element The WebElement to be clicked via JavaScript
	 */
	public   void jsclick(WebElement we) {
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()",we);
			System.out.println("JavaScript click perform successfully on element ");
		}catch (StaleElementReferenceException e) {
			System.out.println("stale element : js click retrying.....");
			waitForMillis(1000);
			jsclick(we);//recursive retry
		}catch (Exception e) {
			System.out.println("Error : javaScript click failed:  "+e.getMessage());
			throw new RuntimeException("JavaScript click failed");
		}
	}






	/**
	 * Utility method to wait for milliseconds
	 * @param millis Milliseconds to wait
	 */
	private  void waitForMillis(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Wait interrupted: " + e.getMessage());
		}
	}

	public   void jsSendKeys(WebElement webElement, String text) {
		try {
			JavascriptExecutor jss=(JavascriptExecutor) driver;
			jss.executeScript("arguments[0].value=arguments[1]",webElement,text);
			System.out.println("javascript sendkeys performed successfully on elemnet ");
		}catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException: stale element retrying ...");
			waitForMillis(1000);
			jsSendKeys(webElement, text);
		}catch (Exception e) {
			System.out.println("ERROR: JavaScript sendKeys failed: " + e.getMessage());
			throw new RuntimeException("JavaScript sendKeys failed for XPath: ");
		}
	}	

	/**Retrieves the value of the specified attribute from the given webElement
	 *handles staleElementRefrenceException
	 *@param Webelement : The element to get the attribute from
	 *@param String : attribute name to fetch
	 *@return String: attribute value or null if not available
	 */

	public  String getAttribute(WebElement webElement,String attributename) {
		String value=null;
		try {
			value=webElement.getAttribute(attributename);
			System.out.println("retrieved attribute  "+attributename+":"+value);
			return value;
		}catch (StaleElementReferenceException e) {
			System.out.println("stale element: stale element in attribute ,retrying....");
			waitForMillis(1000);
			getAttribute(webElement, attributename);//recursive retry
		}catch(Exception e) {
			System.out.println("Error: Failed to getAttribute:    "+e.getMessage());
			throw new RuntimeException("failed to get Attribute");
		}
		return value;
	}
	/************* VALIDATION METHODS *************/
	/**
	 * This method checks whether current URL is equal to expected URL.
	 * 
	 * If actual URL equals expected URL → IF block → PASS
	 * If actual URL not equals expected URL → ELSE block → FAIL
	 *
	 * @param expectedUrl expected URL
	 * @param message validation message
	 */
	public void validateUrlEquals(String expectedUrl, String message) {
		String actualUrl = getCurrentUrl();
		String expectedBase = expectedUrl.replaceAll("record=\\d+", "");
		String actualBase   = actualUrl.replaceAll("record=\\d+", "");
		if (actualBase.equals(expectedBase)) {
			System.out.println("VALIDATION PASSED: " + message);
		} else {
			String errorMsg = message + " Expected URL: " + expectedUrl + " Actual URL: " + actualUrl;
			System.out.println("VALIDATION FAILED: " + errorMsg);
			throw new AssertionError(errorMsg);
		}
	}
	/**
	 * This method checks whether current URL contains expected text.
	 * 
	 * If actual URL contains expected text → IF block → PASS
	 * If actual URL does not contain expected text → ELSE block → FAIL
	 *
	 * @param expectedText expected text in URL
	 * @param message validation message
	 */
	public void validateUrlContains(String expectedText, String message) {
		String actualUrl = getCurrentUrl();
		if (actualUrl.contains(expectedText)) {
			System.out.println("VALIDATION PASSED: " + message);
		} else {
			String errorMsg = message + " Expected URL contains: " + expectedText + " Actual URL: " + actualUrl;
			System.out.println("VALIDATION FAILED: " + errorMsg);
			throw new AssertionError(errorMsg);
		}
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
	public void validateTitleContains(String expectedText, String message) {

		String actualTitle = getPageTitle();
		if (actualTitle.contains(expectedText)) {
			System.out.println("VALIDATION PASSED: " + message);
		} else {
			String errorMsg = message + " Expected Title contains: " + expectedText + " Actual Title: " + actualTitle;
			System.out.println("VALIDATION FAILED: " + errorMsg);
			throw new AssertionError(errorMsg);
		}
	}
	/**
	 * This method checks whether element text contains expected text.
	 * 
	 * If actual text contains expected text → IF block → PASS
	 * If actual text does not contain expected text → ELSE block → FAIL
	 *
	 * @param webElement element to check
	 * @param expectedText expected value
	 * @param message validation message
	 */
	public void validateTextContains(WebElement webElement,String expectedText,String message) {
		String actualText = getText(webElement);
		if (actualText.contains(expectedText)) {
			System.out.println("VALIDATION PASSED: " + message);
		} else {
			String errorMsg = message +  " Expected to contain: '" + expectedText +  "Actual: " + actualText ;
			System.out.println("VALIDATION FAILED: " + errorMsg);
			throw new AssertionError(errorMsg);
		}
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
	public void validateTextEquals(WebElement webElement, String expectedText, String message) {
		String actualText = getText(webElement);
		if (actualText.equals(expectedText)) {
			System.out.println("VALIDATION PASSED: " + message);
		} else {
			String errorMsg = message + " - Expected: '" + expectedText + "', Actual: '" + actualText + "'";
			System.out.println("VALIDATION FAILED: " + errorMsg);
			throw new AssertionError(errorMsg);
		}
	}
	/**
	 * This method checks whether the page title is equal to expected title.
	 * 
	 * If actual title equals expected title,
	 * code will go inside IF block and validation will PASS.
	 * 
	 * If actual title is not equal to expected title,
	 * code will go inside ELSE block and validation will FAIL.
	 * 
	 * @param expectedTitle expected page title
	 * @param message validation message
	 */


	public void validateTitleEquals(String expectedTitle, String message) {
		String actualTitle = getPageTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("VALIDATION PASSED: " + message);
		} else {
			String errorMsg = message +   " - Expected Title: '" + expectedTitle + "', Actual Title: '" + actualTitle + "'";
			System.out.println("VALIDATION FAILED: " + errorMsg);
			throw new AssertionError(errorMsg);
		}
	}


	/**
	 * This method checks whether attribute value is equal to expected value.
	 * 
	 * If actual value equals expected value → IF block → PASS
	 * If actual value not equals expected value → ELSE block → FAIL
	 *
	 * @param webElement element to check
	 * @param attributeName attribute name
	 * @param expectedValue expected value
	 * @param message validation message
	 */
	public void validateAttributeEquals(WebElement webElement, String attributeName, String expectedValue,  String message) {
		String actualValue = getAttribute(webElement, attributeName);
		if (actualValue.equals(expectedValue)) {
			System.out.println("VALIDATION PASSED: " + message);
		} else {
			String errorMsg = message + " - Attribute: " + attributeName +    ", Expected: '" + expectedValue + "', Actual: '" + actualValue + "'";
			System.out.println("VALIDATION FAILED: " + errorMsg);
			throw new AssertionError(errorMsg);
		}
	}

}



