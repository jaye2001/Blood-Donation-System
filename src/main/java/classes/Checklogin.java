package classes;

public class Checklogin {
	
	public static boolean status = false;
	
	public static void setLogin(boolean status1) {
	
		status = status1;
		
		System.out.println("set");
	}
	
	public static boolean getStatus() {
		return status;
	}
	
}
