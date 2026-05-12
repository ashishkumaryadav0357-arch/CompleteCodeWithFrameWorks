package Oops;

public class Super {

	Super(){
		System.out.println("I am super simple constructor");
	}
	Super(int a){
		System.out.println("I am super single parameterized constructor");
	}
	Super(int a,int b){
		System.out.println("I am super double parameterized constructor");
	}

	
	
	public static void main(String[] args) {
		Super a=new Super();
		a.getadd();
	}

	

 private String add="Bhadohi";

private void showadd() {
	System.out.println("my add "+add);
}
	
	public void getadd() {
		showadd();
	}
}
