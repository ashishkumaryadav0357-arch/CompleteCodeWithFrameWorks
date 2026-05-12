package Besics;

public class StringReverse {

	public static void main(String[] args) {
//	 revName();
	 
	 reverseName();

	}
	public static void reverseName() {
		String name="Ashish kumar yadav";
		String[] val=name.split(" ");
		for(int i=0;i<val.length;i++ ) {
			String word=val[i];
			for(int j=word.length()-1;j>=0;j--) {
				char chr=word.charAt(j);
				System.out.print(chr);
			}
		}
	}
public static void revName() {
	String name="Ashish kumar yadav";
	for(int i=name.length()-1;i>=0;i--) {
		char chr=name.charAt(i);
		System.out.print(chr);
	}
	
}
}
