package org.ash.amazon.pages;

import org.ash.amazon.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebUtils webUtils ;
	
	
	
@FindBy(xpath="//input[@id='twotabsearchtextbox']")	
private WebElement searchBox;
	
@FindBy(xpath="//input[@id='nav-search-submit-button']")
private WebElement searchButton;




//********<Actions (Perform)>***********//

public void fillIn_SearchBox(String enterInSearchBox) {
	webUtils.sendkeys(searchBox, enterInSearchBox); 
	webUtils.click(searchButton);
}
}
