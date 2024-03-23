package classes;

public class CampaignHis {
	private String name;
	private String description;
	private String image;
	
public void Set_Values(String _name, String _description, String _image) {
		
		name = _name;
		description = _description;
		image = _image;
		
		
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getImage() {
		return image;
	}

	

}
