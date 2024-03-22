package classes;

public class DonateHis {
	
	private String date;
	private String status;
	private String location;
	
	
	public void setValues(String _date, String _status, String _location) {
		
		date = _date;
		status = _status;
		location = _location;
		
	}
	
	public String getDate() {
		return date;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getLocation() {
		return location;
	}

}
