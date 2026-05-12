package Vechile;

public class Bike extends Vechile {

	public  Bike() {
		System.out.println("My vechile name is Bike..");
	}
public void start() {
	super.start();
	System.err.println("Vechile is starting with kick..");
}
}
