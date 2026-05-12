package Senario_overriding;

public class ChromBrowser implements WebDriver {

	public  void openBrowser() {
		System.out.println("Open Browser from ChromBrowser page");
	}

	@Override
	public void getUrl() {
		System.out.println("Hit URL in ChromBrowser page");
		
	}

	@Override
	public void getText() {
		System.out.println("Return element inner text in ChromBrowser page");
		
	}

	@Override
	public void closeBrowser() {
		System.out.println("Close Browser from ChromBrowser page");
		
	}
}
