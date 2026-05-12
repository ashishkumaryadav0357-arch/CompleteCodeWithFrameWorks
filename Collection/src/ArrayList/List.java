package ArrayList;

import java.util.ArrayList;

public class List {

	public static void main(String[] args) {

	}
	public void Integer() {


		// TODO Auto-generated method stub
		ArrayList<Integer> num=new ArrayList<Integer>();
		 num.add(23);
		 num.add(66);
		num.add(77);

		System.out.println(num.set(0, 33));

		System.out.println(num.set(0, 34));

	}
	public void strin() {

		ArrayList<String> name=new ArrayList<>();
		name.add("ashish");
		name.add("rajveer");
		name.add("kallu");
		name.add("ankita");

		String change=name.set(0, "abhisek");
		String chang=name.set(0, "abhisek");

		System.out.println(change);
		System.out.println(chang);

	}

	public void name() {
		ArrayList<String> name=new ArrayList<String>();
		name.add("ashish");
		name.add("dhruv");
		name.add("jayyyy");
		name.add("vimal");
		name.add("Ritesh");
		name.add("Sandeep");

		//System.out.println(name.get(0));

		for(int i=0;i<name.size();i++) {
			String d= name.get(i);
			System.out.println(d);
		}
	}
}

