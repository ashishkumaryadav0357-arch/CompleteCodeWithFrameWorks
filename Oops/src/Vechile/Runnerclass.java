package Vechile;

public class Runnerclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Bike bike=new Bike(); //Parent and child class All non static method and variable are loaded 
	
		 
	Vechile vechile=new Bike();
	
	vechile.start();  
	
	
	Vechile bik=new Vechile();//All non static method and variable are loaded only for Parent class
	
	}

}
