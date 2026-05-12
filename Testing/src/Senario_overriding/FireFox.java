package Senario_overriding;

public class FireFox implements WebDriver{

	public  void openBrowser() {
		System.out.println("Open Browser from FireFox page");
	}

	@Override
	public void getUrl() {
		System.out.println("Hit URL in FireFox page");

	}

	@Override
	public void getText() {
		System.out.println("Return element inner text in FireFox page");

	}

	@Override
	public void closeBrowser() {
		System.out.println("Close Browser from FireFox page");

	}
}
