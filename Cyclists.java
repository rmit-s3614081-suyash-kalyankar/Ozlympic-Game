package Participants;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Wenbo Peng
 *
 */
public class Cyclists implements Athletes {

	public int compete(){
		
		int cycleTime = 0;
		cycleTime = 500 + (int)(Math.random() * 300); 
		return cycleTime;
	}
	
	public List<Participant> listOfCyclists = new ArrayList<Participant>();
	
	public List<Participant> populateCyclists(){
		
		
		listOfCyclists.add(new Participant("CY01","Edward",21,"Vic",0,compete()));
		listOfCyclists.add(new Participant("CY02","Andy",28,"Qld",0,compete()));
		listOfCyclists.add(new Participant("CY03","Samuel",36,"NSW",0,compete()));
		listOfCyclists.add(new Participant("CY04","Sam",23,"NSW",0,compete()));
		
		return listOfCyclists;
		
		
	}

	

}
