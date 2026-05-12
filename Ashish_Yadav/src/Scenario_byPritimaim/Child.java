package Scenario_byPritimaim;

//import org.bouncycastle.asn1.x500.AttributeTypeAndValue;

public class Child extends parent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Child ab=	new Child();
	//ab.showMessage();
	ab.checkValues();
	}
	public void message() {
		System.out.println("Child Message");
	}
public void showMessage() {
	message();
	super.message();
}

///--------------2 Work=-=>>>>>>>>>>>>>>>>>>>>>>>>>

public void variable() {
	int value=1000;
	System.out.println(value);
}
public void checkValues() {
	variable();
	//this.checkValues();
	super.variable();
}
}
