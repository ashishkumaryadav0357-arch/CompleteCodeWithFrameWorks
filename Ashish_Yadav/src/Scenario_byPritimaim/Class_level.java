package Scenario_byPritimaim;

public class Class_level {
	String Name="ashish";
	public static void main(String[] args) {
		Class_level call=	new Class_level();
call.ShowName();
		
	}
public void ShowName() {
	String Name="ashish ydv";
	System.out.println(Name);
	System.out.println(this.Name);
}
}
