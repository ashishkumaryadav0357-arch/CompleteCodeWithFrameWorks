package org.eva.vtiger.utils;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebUtils {


	private WebDriver driver;

	/////////////////////////////////////////////////--<WebDriver>--///////////////////////////////////////

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
	 * This method is used to launch the specified browser 
	 * and open the given URL.
	 *
	 * @param URL is the web address to be opened
	 * @param Lunch_Browser is the name of the browser (Chrome, Firefox, IE, Edge)
	 * @throws IllegalArgumentException if the browser name is invalid
	 */
	public  void getHitUrl(String browserName,String URL) {
		switch(browserName) {
		case"Chrome":
			driver=new ChromeDriver();
			driver.get(URL);
			break;
		case"Firefox":
			driver=new FirefoxDriver();
			driver.get(URL);
			break;
		case"InternetExplorar":
			driver=new InternetExplorerDriver();
			driver.get(URL);
			break;
		case"EdgeBrowser":
			driver=new EdgeDriver();
			driver.get(URL);
			break;
		default:
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
	}

	/**
	 * This method is used to open the specified URL in the browser.
	 *
	 * @param URL is the web address to be opened in the browser
	 * @throws Exception if any unexpected error occurs while loading the URL
	 */
	public  void get(String URL) {
		try {
			driver.get(URL);
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

	/** Clear the text from a specific input field 
	 *  @param xpath the xPath locater of the element to be cleared
	 *  @throws Exception if any unexpected error come
	 * */

	public  void clear(WebElement webElement) {
		try {
			webElement.clear();
		}catch(NoSuchElementException e){
			expWaitvisibilityOf(30, webElement);
			webElement.clear();
		}catch(StaleElementReferenceException e){
			webElement.clear();
		}catch(Exception e){
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
	 * This method is used to get the tag name of an element 
	 * using the given XPath.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @return the tag name of the element
	 * @throws Exception if any unexpected error come
	 */
	public  String getTagName(WebElement webElement) {
		try {
			String	tagnam = webElement.getTagName();
			return tagnam;
		}catch(NoSuchElementException e) {

			expWaitvisibilityOf(30, webElement);
			String	tagnam=webElement.getTagName();
			return tagnam;
		}catch(StaleElementReferenceException e){
			String	tagnam = webElement.getTagName();
			return tagnam;
		}catch(Exception e) {
			System.out.println("Unexpected error..");
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
		}
	}




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

	/**
	 * Is_Selected method used to check the checkBox or radio button is checked or not  
	 *  @param  xpath is used to locate specific element on the Web_page
	 * @return Is_Selected method return the value of boolean type
	 * @throws Exception if any unexpected error come
	 * */
	public  boolean isSelected(WebElement webElement) {
		try {
			System.out.println("Checking element selected status...");
			boolean Select = webElement.isSelected();
			return Select;
		}catch(NoSuchElementException e) {
			boolean	Select = webElement.isSelected();			
			return Select;
		}catch(StaleElementReferenceException e) {
			boolean	Select = webElement.isSelected();
			return Select;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}	}

	/**
	 * GetAttribute method used to return the written value of input field  
	 *@param Webelement : The element to get the attribute from
	 * @return  getAttribute return the object of String class  
	 * @throws Exception if any unexpected error come
	 * */
	public  String getAttribute(WebElement webElement,String attributename) {
		try {
			System.out.println("Getting attribute value...");
			String value = webElement.getAttribute(attributename);
			System.out.println("Attribute retrieved successfully"+attributename+" : "+value);
			return value;
		}catch(NoSuchElementException e) {
			System.out.println("No such element in attribute ,retrying....");
			expWaitvisibilityOf(30, webElement);
			String	value =webElement.getAttribute(attributename);
			return value;
		}catch(StaleElementReferenceException e) {
			System.out.println("stale element: stale element in attribute ,retrying....");
			String	value = webElement.getAttribute(attributename);
			return value;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to get the location of an element using the given XPath.
	 * 
	 * @param xpath is used to locate the specific element on the web page
	 * @return Point object representing the X and Y coordinates of the element
	 * @throws Exception if any unexpected error come
	 */
	public  Point getLocation(WebElement webElement) {
		try {
			System.out.println("Getting element location...");
			Point location = webElement.getLocation();
			return location;
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(30, webElement);
			Point location = webElement.getLocation();
			return location;
		}catch(StaleElementReferenceException e) {
			Point location = webElement.getLocation();
			return location;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}		
	}
	/**
	 * This method is used to get the height of an element 
	 * using the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found immediately, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @return height of the element in pixels
	 * @throws Exception if any unexpected error occurs
	 */
	public  int getSizeHeight(WebElement webElement) {
		try {
			Dimension sizeHeight = webElement.getSize();
			System.out.println("Getting element height...");
			int height = sizeHeight.getHeight();
			return height;
		} catch (NoSuchElementException e) {
			expWaitvisibilityOf(30, webElement);
			int height = webElement.getSize().getHeight();
			return height;
		} catch (StaleElementReferenceException e) {
			int	height = webElement.getSize().getHeight();
			return height;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	/**
	 * This method is used to get the width of an element 
	 * using the given XPath.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @return the width of the element; returns -1 if the element is not found
	 * @throws Exception if any unexpected error occurs
	 */
	public  int getSizeWidth(WebElement webElement) {
		try {
			Dimension sizeWidth = webElement.getSize();
			System.out.println("Getting element width...");
			int width = sizeWidth.getWidth();
			return width;
		} catch (NoSuchElementException e) {
			expWaitvisibilityOf(30, webElement);
			int width = webElement.getSize().getWidth();
			return width;
		} catch (StaleElementReferenceException e) {
			int	width = webElement.getSize().getWidth();
			return width;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public  WebElement findElement(WebElement weElement) {
		try {
			return weElement;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}	}

	public  List<WebElement> findElements(List<WebElement> weElements) {
		try {
			return weElements;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}






	//	public  List<WebElement> findElements(String xpath) {
	//		try {List<WebElement> weElement = driver.findElements(By.xpath(xpath));
	//		return weElement;
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//			throw e;
	//		}}

	/**
	 * This method is used to close the current browser window.
	 * @throws Exception if any unexpected error come while closing the browser
	 */
	public  void Close() {
		try {driver.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}

	/**
	 * This method is used to quit the browser and close all the browser windows opened by the WebDriver .
	 * @throws Exception if any unexpected error come while Quit the all browser
	 * */
	public  void quit() {
		try {driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}

	/**
	 * This method is used to get the page source of the current web page.
	 * @return String - returns the complete HTML source code of the current page
	 * @throws Exception if any error happens while getting the page source	
	 */
	public  String getPageSource() {
		try {String pagesource = driver.getPageSource();
		return pagesource;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}

	/**
	 * This method is used to create ChromeOptions for launching the Chrome browser
	 * in maximized mode.
	 * @return ChromeOptions object with "--start-maximized" argument
	 */
	public  ChromeOptions maximized() {
		try {ChromeOptions option=new ChromeOptions();
		option.addArguments("--start-maximized");
		return option;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}

	/**
	 * This method is used to navigate the browser to the previous page
	 * @throws Exception if navigation fails or browser error occurs
	 */
	public  void backPage() {
		try {
			driver.navigate().back();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}

	public  void forwardPag() {
		try {
			driver.navigate().forward();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}



	////////////////////////////////////////--<Window handle>--/////////////////////////////////

	public  void getWindoHandle() {
		try {
			String handleValue=driver.getWindowHandle();
			driver.switchTo().window(handleValue);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
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

	public  void window() {
		try {
			String handVal=driver.getWindowHandle();
			driver.switchTo().window(handVal);	
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	////////////////////////////////////////////--<POPUP Hendle>--//////////////////////////////////////////
	/**
	 * This method is used to accept the alert popup.
	 *
	 * @throws Exception if alert is not present or any error occurs
	 */
	public  void alertAccept() {
		try {
			driver.switchTo().alert().accept();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to Dismiss the alert popup.
	 *
	 * @throws Exception if alert is not present or any error occurs
	 */
	public  void alertDismiss() {
		try {
			driver.switchTo().alert().dismiss();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to get the text from the alert popup.
	 *
	 * @return the text message displayed in the alert
	 * @throws Exception if alert is not present or any error occurs
	 */
	public  String alertGetText() {
		try {
			String val=driver.switchTo().alert().getText();
			return val;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to enter text into the alert popup.
	 *
	 * @param value the text to be entered in the alert input field
	 * @throws Exception if alert is not present or any error occurs
	 */
	public  void aler_Sendkeyt(String value) {
		try {
			driver.switchTo().alert().sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	//////////////////////////////--<Iframe>--/////////////////////////////////////
	/**
	 * This method is used to switch the driver to a frame using its index.
	 *
	 * @param index the index number of the frame on the web page
	 * @throws Exception if frame is not found or switching fails
	 */
	public  void FrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to switch the driver to a frame using the frame name .
	 *
	 * @param frameName the name  of the frame on the web page
	 * @throws Exception if the frame is not found or switching fails
	 */
	public  void FrameByName(String frameName) {
		try {
			driver.switchTo().frame(frameName);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to switch the driver to a frame using the frame id.
	 *
	 * @param frameID the  id of the frame on the web page
	 * @throws Exception if the frame is not found or switching fails
	 */
	public  void FrameById(String frameId) {
		try {
			driver.switchTo().frame(frameId);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public  void FrameByWebElement(WebElement webElement) {
		try {
			driver.switchTo().frame(webElement);	
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public  void ToSwitchOnMainPage() {
		try {
			driver.switchTo().defaultContent();		
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public  void ToSwitchOnParent() {
		try {
			driver.switchTo().parentFrame();		
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/////////////////////////////////////////--<Actions>--/////////////////////////////////////////////////

	/**
	 *  movetoElement  element using given XPath.
	 *
	 * This method performs hover action on the element.
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If element not found, it waits and tries again.
	 *
	 * @param xpath is used to locate specific element on the Web_page
	 * @throws Exception  if unexpected error occurs
	 */

	public  void movetoElement(WebElement weElement) {
		Actions actobj=new Actions(getDriver());
		try {
			actobj.moveToElement(weElement).build().perform();
			System.out.println("Mouse over performed");
		}catch(NoSuchElementException e) {
			WebUtils utilobj=new WebUtils();
			utilobj.expWaitvisibilityOf(180, weElement);
			actobj.moveToElement(weElement).build().perform();

		}catch(StaleElementReferenceException e) {
			actobj.moveToElement(weElement).build().perform();	

		}catch(ElementNotInteractableException e) {
			WebUtils utilobj=new WebUtils();
			utilobj.jse_movetoElement(weElement);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to perform right-click (context click) 
	 * on an element using the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @throws Exception if any unexpected error occurs
	 */

	public  void contextClick(WebElement weElement) {
		Actions actobj=new Actions(driver);
		try {
			actobj.contextClick(weElement).build().perform();	

		}catch(NoSuchElementException e) {
			WebUtils utilobj=new WebUtils();
			utilobj.expWaitvisibilityOf(180, weElement);
			actobj.contextClick(weElement).build().perform();
		}catch(StaleElementReferenceException e) {
			actobj.contextClick(weElement).build().perform();		
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to perform double-click action 
	 * on an element using the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @throws Exception if any unexpected error occurs
	 */

	public  void DoubleClick(WebElement weElement) {
		Actions actobj=new Actions(driver);
		try {
			actobj.doubleClick(weElement).build().perform();

		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(180, weElement);
			actobj.doubleClick(weElement).build().perform();
		}catch(StaleElementReferenceException e) {
			actobj.doubleClick(weElement).build().perform();		
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	/**
	 * This method is used to perform drag and drop action 
	 * from source element to target element using given XPaths.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the elements are not found, it waits and tries again.
	 *
	 * @param xpath   is used to locate the source element
	 * @param xpath1  is used to locate the target element
	 * @throws Exception if any unexpected error occurs
	 */

	public  void Drang_Drop(WebElement webElement_Source,WebElement webElement_Target) {
		Actions actobj=new Actions(driver);
		try {
			actobj.dragAndDrop(webElement_Source,webElement_Target).build().perform();
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(180, webElement_Source);
			expWaitvisibilityOf(60, webElement_Target);
			actobj.dragAndDrop(webElement_Source,webElement_Target).build().perform();
		}catch(StaleElementReferenceException e) {
			actobj.dragAndDrop(webElement_Source,webElement_Target).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to scroll to an element 
	 * using the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @throws Exception if any unexpected error occurs
	 */

	public  void scrollToElement(WebElement	weElement) {
		Actions actobj=new Actions(driver);
		try {
			actobj.scrollToElement(weElement).build().perform();
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(180, weElement);
			actobj.scrollToElement(weElement).build().perform();
		}catch(StaleElementReferenceException e) {
			actobj.scrollToElement(weElement).build().perform();
		}catch(ElementNotInteractableException e) {
			jse_scrollToElement(weElement);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to scroll the page by amount the given X_codinet and Y_codinet  values.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If any issue occurs, it waits and tries again.
	 *
	 * @param deltaX horizontal scroll amount
	 * @param deltaY vertical scroll amount
	 * @throws Exception if any unexpected error occurs
	 */

	public  void scrollByAmount(int deltaX,int deltaY) {
		Actions actobj=new Actions(driver);
		try {
			actobj.scrollByAmount(deltaX,deltaY).build().perform();;
		}catch(NoSuchElementException e) {
			ImplicitlyWait(60);
			actobj.scrollByAmount(deltaX,deltaY).build().perform();;
		}catch(StaleElementReferenceException e) {
			actobj.scrollByAmount(deltaX,deltaY).build().perform();;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to perform click and hold  on an element using the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @throws Exception if any unexpected error occurs
	 */

	public  void click_hold(WebElement weElement) {
		Actions actobj=new Actions(driver);
		try {
			actobj.clickAndHold(weElement).build().perform();

		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(180, weElement);
			actobj.clickAndHold(weElement).build().perform();;
		}catch(StaleElementReferenceException e) {
			actobj.clickAndHold(weElement).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	///////////////////////////////////---<Select Class>---//////////////////////////////////////

	/**
	 * This method is used to get the first selected option  from a DropDown using the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param Xpath is used to locate the DropDown element on the web page
	 * @throws Exception if any unexpected error occurs
	 */

	public  WebElement getFirstSelectedOption(WebElement webElement) {
		try {
			Select selectobj=new Select(webElement);
			WebElement webFirstSelected=selectobj.getFirstSelectedOption();	
			return webFirstSelected;
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(60, webElement);
			Select selectobj=new Select(webElement);
			WebElement webFirstSelected=selectobj.getFirstSelectedOption();
			return webFirstSelected;
		}catch(StaleElementReferenceException e) {
			Select selectobj=new Select(webElement);
			selectobj.getFirstSelectedOption();			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return webElement;
	}
	/**
	 * This method is used to select a DropDown option by visible text using the given XPath !
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param Xpath is used to locate the DropDown element on the web page
	 * @param visibltext is the visible text to be selected from the DropDown
	 * @throws Exception if any unexpected error occurs
	 */

	public  void selectByVisibleText(WebElement webElement,String visibletext) {
		try{
			Select selectobj=new Select(webElement);
			selectobj.selectByVisibleText(visibletext);
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(60, webElement);
			Select selectobj=new Select(webElement);
			selectobj.selectByVisibleText(visibletext);
		}catch(StaleElementReferenceException e) {
			Select selectobj=new Select(webElement);
			selectobj.selectByVisibleText(visibletext);	
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This method is used to select a DropDown option by index using the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param Xpath is used to locate the DropDown element on the web page
	 * @param text is the index number of the option to be selected
	 * @throws Exception if any unexpected error occurs
	 */
	public  void selectByIndex(WebElement select_ByIndex,int index) {
		try {
			Select selectobj=new Select(select_ByIndex);
			selectobj.selectByIndex(index);
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(60, select_ByIndex);
			Select selectobj=new Select(select_ByIndex);
			selectobj.selectByIndex(index);
		}catch(StaleElementReferenceException e) {
			Select selectobj=new Select(select_ByIndex);
			selectobj.selectByIndex(index);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}}
	/**
	 * This method is used to select a DropDown option by value using the given XPath!
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param Xpath is used to locate the DropDown element on the web page
	 * @param value is the value attribute of the option to be selected
	 * @throws Exception if any unexpected error occurs
	 */
	public  void selectByValue(WebElement select_ByValue,String value) {
		try {
			Select selectobj=new Select(select_ByValue);
			selectobj.selectByValue(value);
		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(60, select_ByValue);
			Select selectobj=new Select(select_ByValue);
			selectobj.selectByValue(value);
		}catch(StaleElementReferenceException e) {
			Select selectobj=new Select(select_ByValue);
			selectobj.selectByValue(value);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	///////////////////////////////--<JavaScriptExecute>--///////////////////////////////////////

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
	/**
	 * This method is used to perform mouse hover  
	 * on  element using JavaScriptExecutor with the given XPath.
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @throws Exception if any unexpected error occurs
	 */
	public  void jse_movetoElement(WebElement weElement) {
		//JavascriptExecutor jse=(JavascriptExecutor) driver;
		try {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", weElement);
		}catch(NoSuchElementException e) {
			WebUtils webUtisObj=new WebUtils();
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			webUtisObj.expWaitvisibilityOf(60, weElement);
			jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", weElement);
		}catch(StaleElementReferenceException e) {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover',{bubbles:true}))", weElement);			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;

		}
	}
	/**
	 * This method is used to scroll to an element using JavaScriptExecutor with the given XPath 
	 *
	 * It handles NoSuchElementException and StaleElementReferenceException.
	 * If the element is not found, it waits and tries again.
	 *
	 * @param xpath is used to locate the specific element on the web page
	 * @throws Exception if any unexpected error occurs
	 */
	public  void jse_scrollToElement(WebElement weElement) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		try {
			jse.executeScript("arguments[0].scrollIntoView(true);", weElement);
		}catch(NoSuchElementException e) {
			WebUtils webUtisObj=new WebUtils();
			webUtisObj.expWaitvisibilityOf(60, weElement);
			jse.executeScript("arguments[0].scrollIntoView(true);", weElement);
		}catch(StaleElementReferenceException e) {
			jse.executeScript("arguments[0].scrollIntoView(true);", weElement);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	//////////////////////////////--<ScreenShort>--///////////////////////////////////////
	public  void Screenshort_Full(String path) throws IOException {

		TakesScreenshot screeshort=(TakesScreenshot) driver;
		File Src=screeshort.getScreenshotAs(OutputType.FILE);
		File target=new File(path);
		FileUtils.copyFile(Src, target);

	}

	public  void Screenshort_particuler(WebElement elementScreenshot,String path) throws IOException {
		try{
			TakesScreenshot takescreenshot=elementScreenshot;
			File Src=takescreenshot.getScreenshotAs(OutputType.FILE);
			File target=new File(path);
			FileUtils.copyFile(Src, target);

		}catch(NoSuchElementException e) {
			expWaitvisibilityOf(60, elementScreenshot);
			TakesScreenshot takescreenshot=elementScreenshot;
			File Src=takescreenshot.getScreenshotAs(OutputType.FILE);
			File target=new File(path);
			FileUtils.copyFile(Src, target);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	///////////////////////////////////////////////////--<Wait>--///////////////////////////////
	///Explicitly wait::


	//	public  WebElement expWaitElementToBeClickable(int time,String xpath) {
	//		try {
	//			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
	//			WebElement we_wait= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	//			return we_wait;
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//			throw e;
	//		}
	//	}
	//
	//	public  WebElement expWaitElementLocated(int time,String xpath) {
	//		try {
	//			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
	//			WebElement we_wait=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	//			return we_wait;
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//			throw e;
	//		}
	//	}
	public  WebElement expWaitvisibilityOf(int time,WebElement webElement) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
			WebElement we_wait=wait.until(ExpectedConditions.visibilityOf(webElement));
			return we_wait;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public  WebElement expWaitpresenceOfElementLocated(int time,String xpath) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
			WebElement we_wait=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			return we_wait;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	///Implicitly wait

	public  void ImplicitlyWait(int SecDuration) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SecDuration));
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/// Thread.sleep
	public  void Threadsleep(int miliTime) throws InterruptedException {
		try {
			Thread.sleep(miliTime);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}  


	//////////////////////////////////--<Validation>--/////////////////////////////////////////////

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
		Assert.assertEquals(actualValue, expectedValue,message);


	}


	/**
	 * This method used to  validates the page with the help of title by equal method  to the expected title .
	 *
	 * @param expectedTitle the expected page title
	 * @param message the validation message to display
	 * @throws AssertionError if the actual title does not match the expected title
	 */
	public  void validateTitleEquals(String expectedTitle, String message) {
		String actualTitle = getTitle();
		Assert.assertEquals(actualTitle, expectedTitle,message);

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
	public  void validateTitleContains(String ExpectedTitle,String message) {
		String ActualTitle=getTitle();
		Assert.assertTrue(ActualTitle.contains(ExpectedTitle),message);
	}

	///--< Validate by getCurent URL>	

	/**
	 * This method checks whether current URL is equal to expected URL.
	 * 
	 * If actual URL equals expected URL → IF block → PASS
	 * If actual URL not equals expected URL → ELSE block → FAIL
	 *
	 * @param expectedUrl expected URL
	 * @param message validation message
	 */
	public  void validateUrlequals(String expectedUrl,String message) {
		String actualUrl = getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,message);
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
	public  void validateUrlContains(String ExpectedUrl,String message) {
		String ActualUrl=getCurrentUrl();
		Assert.assertTrue(ActualUrl.contains(ExpectedUrl),message);
	}

	///--< Validate by getText>

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
	public  void validateTextequals(WebElement webElementActual,String expectedText,String message) {
		String actualText=getText(webElementActual);
		Assert.assertEquals(actualText, expectedText,message);
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
	public  void validateTextContains(WebElement webElementActual,String expectedText,String message) {
		String actualText=getText(webElementActual);
		Assert.assertTrue(actualText.contains(expectedText),message);
	}
	///--< Validate by isEnable>

	public  void validateIsEnable(WebElement webElement,String massage) {
		boolean isEnable=isEnabled(webElement);
		Assert.assertEquals(isEnable, true);
	}
	///--< Validate by isDisplayed >

	public  void validateIsDisplayed(WebElement webElement,String massage) {
		boolean isEnable=isDisplayed(webElement);
		Assert.assertEquals(isEnable,true);
	}
	///--< Validate by isSelected >

	public  void validateIsSelected(WebElement webElement,String massage) {
		boolean isEnable=isSelected(webElement);
		Assert.assertEquals(isEnable, true);
	}


}


