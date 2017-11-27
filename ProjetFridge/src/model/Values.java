package model;

public class Values {
	
	private double tempValue;
	private int tempValueWanted = 18;
	
	public double getTempValue(){
		return tempValue;
	}
	public int getTempValueWanted(){
		return tempValueWanted;
	}
	
	public void setTempValue(double newTempValue){
		tempValue = newTempValue;
	}
	public void setTempValueWanted(int newTempValueWanted){
		tempValueWanted = newTempValueWanted;
	}

}
