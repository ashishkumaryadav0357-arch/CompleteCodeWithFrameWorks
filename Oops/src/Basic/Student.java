package Basic;

public class Student {

	
	private String name;
	private int marks;
	 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks=marks;
	}
	
	public static void main(String[] args) {
		Student stObj=new Student();
		
		stObj.setName("ydv");
		stObj.getName();
		stObj.setMarks(100);
		stObj.getMarks();
	}
}
