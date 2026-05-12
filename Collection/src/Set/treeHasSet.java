package Set;

import java.util.TreeSet;

public class treeHasSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void treeset() {

		TreeSet<String> name=new TreeSet<String>();
		name.add("ashish");
		name.add("akash");
		name.add("abcd");
		name.add("a");
		name.add("aa");
		name.add("ab");
		name.add("aab");
		name.add("Z");
		name.add("z");
		name.add("d");
		name.add("S");

		for(String nn:name) {
			System.out.println(nn);
		}
	}	

}
