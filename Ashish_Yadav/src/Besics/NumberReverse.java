package Besics;

public class NumberReverse {

	public static void main(String[] args) {
		
		int[]num= {22,22,33,68,};
		for(int i=num.length-1;i>=0;i--) {
			int a=num[i];
			System.out.println(a);
		}
		
		

	
	int[] num1 = {12,34,43};
	int word=num1.length;
	for(int i=word-1;i>=0;i--) {
		int str=num1[i];
		System.out.print(str);
	}

	String name1="Dhruv kumar gupta";
	for(int i=name1.length()-1;i>=0;i--) {
		System.out.print(name1.charAt(i));
	}
}	
}
