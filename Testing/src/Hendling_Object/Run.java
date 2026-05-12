package Hendling_Object;

import java.util.HashSet;
import java.util.Set;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new B(11);
		
	Set<Integer>  yetd=	new HashSet<Integer>();
	yetd.add(4555);
	
	HashSet<Integer>  td=	new HashSet<Integer>();

	td.add(22);
	td.add(11);
	td.add(33);
	td.add(02);
	td.add(21);
	td.add(02);
	
	for(int num :td) {
		System.out.println(num);
	}
	
	
	}

}
