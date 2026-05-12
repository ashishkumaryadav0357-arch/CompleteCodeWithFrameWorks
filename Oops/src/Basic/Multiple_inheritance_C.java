package Basic;

public class Multiple_inheritance_C implements Inheritance_A,Inheritance_B{



	@Override
	public void morning_india() {
		System.out.println("(class A):In India say Namaste");
	}


	@Override
	public void utterPardesh() {
		System.out.println("(class A):In Utter Pardesh say Ram Ram ");	
	}


	@Override
	public void nepal() {
		System.out.println("(class A): In Nepal say Shubh Prabhat");		
	}

	@Override
	public void london() {
		System.out.println("(class B):In london say to Indian style Namestey");
	}
	
	@Override
	public void name() {
		System.out.println("(class B): Name = Ashish");
		Inheritance_A.super.name();
	}


}
