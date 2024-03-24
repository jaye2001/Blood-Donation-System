package classes;

import java.io.Serializable;
import java.util.Date;

public class LabView implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nic;
    private Date date;
	private String bloodType; 
    private String status;
    private String location;

    public LabView() {
        super();
    }

	public LabView(int id, String nic, Date date, String bloodType, String status, String location) {
        this.id = id;
        this.nic = nic;
        this.date = date;
	    this.bloodType = bloodType; 
        this.status = status;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
	
	 public String getBloodType() {
		 return bloodType; 
	}
	 
	 public void setBloodType(String bloodType) { 
		 this.bloodType = bloodType; 
	}
	 
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
