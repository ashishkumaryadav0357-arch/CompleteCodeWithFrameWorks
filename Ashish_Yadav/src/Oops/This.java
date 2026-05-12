package Oops;

public class This extends Super{

	This(){
		System.out.println("I am simple constructor");
	}
	This(int a){

		System.out.println("I am single parameterized constructor");
	}
	This(int a,int b){
		System.out.println("I am double parameterized constructor");
	}

	public static void main(String[] args) {

		Super sup=new This(10);
		 System.out.println(sup);
	}

}
