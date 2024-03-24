package classes;

public class RequestedBlood {
	
	private int hospitalId;
	private String bloodType;
	private int amount;
	private String hospitalName;
	
	
	public void setValues(int _hospitalId, String _bloodType, int _amount, String _hospitalName) {
		
		hospitalId = _hospitalId;
		bloodType = _bloodType;
		amount = _amount;
		hospitalName = _hospitalName;
		
	}
	
	public int getHospitalId() {
		return hospitalId;
	}
	
	public String getBloodType() {
		return bloodType;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}

}
