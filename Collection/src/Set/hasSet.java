package Set;

import java.util.HashSet;

public class hasSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public  void hasset_num() {

		HashSet<Integer>  y=	new HashSet<Integer>();
		y.add(4555);
		y.add(4);
		y.add(12);
		y.add(54);
		for(int ay:y)
			System.out.println(ay);

	}
	public  void hasset_name() {	

		HashSet<String> hasName=	new HashSet<String>();
		hasName.add("rathiSawant");
		hasName.add("alakPanday");
		hasName.add("sunilshetty");
		hasName.add("abcd");
		hasName.add("xyz");
		hasName.add("Aayz");	

		for(String name:hasName)
		{System.out.println(name);}
	}
}
