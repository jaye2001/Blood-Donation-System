package thirdparty;



public class PinGenarate {
	
	private int random; // To assign generate pin number
	private boolean genarate; // To generate pin
	
	
	public void setGenarate(boolean x) {
		this.genarate = x;
		if (genarate == true){
			int randomNum = (int)((Math.random() * 898989+1)+101010); 
			this.random = randomNum;
		}
		genarate = false;
	}
	
	
	public int getRandom() {
		return random;
	}
	
	//public void setRandom(int y) {
	//	this.random = y;
	//}
}

