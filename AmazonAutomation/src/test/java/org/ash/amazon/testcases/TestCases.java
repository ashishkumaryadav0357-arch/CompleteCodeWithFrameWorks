package org.ash.amazon.testcases;

import org.ash.amazon.utils.WebUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {

	
	
	public void endToEnd() {
		WebUtils webUtils=new WebUtils();
		webUtils.launchBrowser("chrome");
		webUtils.hitURL("https://www.amazon.in/");
		
	}
	
}
