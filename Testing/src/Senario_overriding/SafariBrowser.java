package Senario_overriding;

public  class SafariBrowser implements WebDriver {

	public  void openBrowser() {
		System.out.println("Open Browser from SafariBrowser page");
	}

	@Override
	public void getUrl() {
		System.out.println("Hit URL in SafariBrowser page");
		
	}

	@Override
	public void getText() {
		System.out.println("Return element inner text in SafariBrowser page");
		
	}

	@Override
	public void closeBrowser() {
		System.out.println("Close Browser from SafariBrowser page");
		
	}
	
}
