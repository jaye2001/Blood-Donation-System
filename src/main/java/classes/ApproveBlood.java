package classes;

public class ApproveBlood {
	
	private String bloodType;
	private int requested;
	private int available;
	
	public void setValues(String _bloodType, int _available, int _requested) {
		
	bloodType = _bloodType;
	available = _available;
	requested = _requested;
	
		
	}
	
	public String getBloodType() {
		return bloodType;
	}
	
	
	public int getAvailable() {
		return available;
	}
	
	public int getRequested() {
		return requested;
	}

}
