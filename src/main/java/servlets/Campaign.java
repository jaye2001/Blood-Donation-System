package servlets;

public class Campaign {
	
	private int id;
	private String name;
	private String date;
	private String time;
	private String location;
	
	
	public void Set_Values(int _id, String _name, String _date, String _time, String _location) {
		id = _id;
		name = _name;
		date = _date;
		time = _time;
		location = _location;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDate() {
		return date;
	}


	public String getTime() {
		return time;
	}


	public String getLocation() {
		return location;
	}
	
	
	

}
