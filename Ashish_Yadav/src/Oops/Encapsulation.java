package Oops;

public class Encapsulation {


	private int age;


	public int getage() {
		if(age>=18) {

		}else {
			System.out.println("Your age is not eligibal bhakk bsdk");
		}
		return age;
	}



	public int setage(int setAge) {
		age=setAge;
		return setAge;

	}

	public static void main(String[] args) {
		Encapsulation as=new Encapsulation();


		int b=as.setage(19);
		System.out.println(b);
		
		int c=as.getage();
		System.out.println(c);
	}

}
