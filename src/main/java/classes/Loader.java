package classes;

import javax.sql.RowSetListener;

public class Loader {
	private int number;
	private int numberfordis;
	private String nameString;
	
	public void SetList(int num,String name) {
		number = num;
		nameString = name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getNameString() {
		return nameString;
	}
	
	public void setNum(int num) {
		numberfordis = num;
		System.out.println(numberfordis);
	}
	
	public int getNumberfordis() {
		return numberfordis;
	}
}
