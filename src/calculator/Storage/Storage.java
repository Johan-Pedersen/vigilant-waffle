package calculator.Storage;

import java.util.ArrayList;

public class Storage {
	
	//Singleton
	private static Storage storage;
	private ArrayList<String> calculations = new ArrayList<String>();
	
	
	private Storage() {}
	
	//Singleton
	public static Storage getInstance() {
		if(storage == null) {
			storage = new Storage();
		}
		
		return storage;
	}
	
	public ArrayList<String> getCalculations() {
	
		return calculations;
	}
	
	public void addCalculation(String calculation) {
		calculations.add(calculation);
	}
}
