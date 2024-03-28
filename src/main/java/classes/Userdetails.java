package classes;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
	private static String typeString;
	
	
	
	public  void setUser(String nic, String fname, String lname, String email, Date dob, String gender, String pht, String phn, String address, 
						String blood, int _weight, int province, int distric, int city, String pname, String dname, String cname){
		
		nICString = nic;
		fnameString = fname;
		lnameString = lname;
		emailString = email;
		dOBDate = dob;
		genderString = gender;
		photopathString = pht;
		addressString = address;
		bloodtypeString = blood;
		weight = _weight;
		provinceid = province;
		districtid = distric;
		cityid = city;
		pnameString = pname;
		DnameString = dname;
		CnameString = cname;
		System.out.println(nICString);
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
	
	public int getAge() {
		LocalDate date2 = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
		String yearString = formatter.format(date2);
		
		
		//Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String yearString2 = sdf.format(dOBDate);
		
		int year = Integer.parseInt(yearString);
		int yearuserint = Integer.parseInt(yearString2);
		
		return (year-yearuserint);
	}
	
	public static void setType(String type) {
		typeString = type;
		System.out.println(type);
	}
	
	public static String getType() {
		return typeString;
	}
	
}