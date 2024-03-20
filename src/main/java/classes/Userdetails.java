package classes;


import java.util.Date;

public class Userdetails {
	
	private String nICString;
	private String fnameString;
	private String lnameString;
	private String emailString;
	private Date dOBDate;
	private String genderString;
	private String photopathString;
	private String phnnumString;
	private String addressString;
	private String bloodtypeString;
	private int weight;
	private int provinceid;
	private int districtid;
	private int cityid;
	private String pnameString;
	private String DnameString;
	private String CnameString;
	
	
	
	public void setUser(String nic, String fname, String lname, String email, Date dob, String gender, String pht, String phn, String address, 
						String blood, int weight, int province, int distric, int city, String pname, String dname, String cname){
		
		this.nICString = nic;
		this.fnameString = fname;
		this.lnameString = lname;
		this.emailString = email;
		this.dOBDate = dob;
		this.genderString = gender;
		this.photopathString = pht;
		this.addressString = address;
		this.bloodtypeString = blood;
		this.weight = weight;
		this.provinceid = province;
		this.districtid = distric;
		this.cityid = city;
		this.pnameString = pname;
		this.DnameString = dname;
		this.CnameString = cname;

	}
	
	public String getNicString() {
		return nICString;
	}
	
	public String getFnameString() {
		return fnameString;
	}
	
	public String getLnameString() {
		return lnameString;
	}
	
	public String getEmailString() {
		return emailString;
	}
	
	public Date getDate() {
		return dOBDate;
	}
	
	public String getGenderString() {
		return genderString;
	}
	
	public String getPhotoString() {
		return photopathString;
	}
	
	public String getPhnnumString() {
		return phnnumString;
	}
	
	public String getAddresssString() {
		return addressString;
	}
	
	public String getBloodtypeString() {
		return bloodtypeString;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getProvinceid() {
		return provinceid;
	}
	
	public int getDistrictid() {
		return districtid;
	}
	
	public int getCityid() {
		return cityid;
	}
	
	public String getPname() {
		return pnameString;
	}
	
	public String getDname() {
		return DnameString;
	}
	
	public String getCname() {
		return CnameString;
	}
	
}