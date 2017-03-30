package suyash;

import java.util.ArrayList;
import java.util.List;

public class Cyclists implements Athletes {

	public int complete(){
		
		int cycleTime = 0;
		cycleTime = 500 + (int)(Math.random() * 300); 
		return cycleTime;
	}
	
	List<Participant> listOfCyclists = new ArrayList<Participant>();
	
	public List<Participant> populateCyclists(){
		
		
		listOfCyclists.add(new Participant("CY01","GauravCY","10","MP","0"));
		listOfCyclists.add(new Participant("CY02","SuyashCY","10","MP","0"));
		listOfCyclists.add(new Participant("CY03","AliCY","10","MP","0"));
		
		return listOfCyclists;
		
		
	}

}
