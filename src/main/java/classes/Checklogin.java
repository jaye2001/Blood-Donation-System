package classes;

public class Checklogin {
	
	private boolean status = false;
	
	public void setLogin(boolean status1) {
		this.status = status1;
		System.out.println("set");
	}
	
	public boolean getStatus() {
		return status;
	}
	
}
