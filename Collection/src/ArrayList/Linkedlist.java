package ArrayList;

import java.util.LinkedList;

public class Linkedlist {
	
	public static void main(String[] args) {
		
	}

	public void linkedlist() {
		
		LinkedList<String> name=new LinkedList<String>();
		name.add("Ramkumar");
		name.add("Dhreeraj");
		name.add("Deepak");
		name.add("Rajesh");
		name.add("Rajesh");
		name.add("deelepl");
		name.add("AZ");
		
		
		//System.out.println(name.get(0));
		
		for(int j=0;j<name.size();j++) {
		String all= name.get(j);
		System.out.println(all);
		}
	}
}
