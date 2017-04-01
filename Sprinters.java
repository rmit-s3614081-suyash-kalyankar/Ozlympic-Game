package Participants;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Wenbo Peng
 *
 */
public class Sprinters implements Athletes {

	public int compete(){
		
		int sprintTime = 0;
		sprintTime = 10 + (int)(Math.random() * 10); 
		return sprintTime;
	}
	
	public List<Participant> listOfSprinters = new ArrayList<Participant>();
	
	public List<Participant> populateSprinters(){
		
		
		listOfSprinters.add(new Participant("SP01","Edmund",32,"QLD",0,compete()));
		listOfSprinters.add(new Participant("SP02","Suyash",25,"Vic",0,compete()));
		listOfSprinters.add(new Participant("SP03","Ali",28,"Tas",0,compete()));
		listOfSprinters.add(new Participant("SP04","Yogi",26,"Vic",0,compete()));
		listOfSprinters.add(new Participant("SP05","Loki",27,"WA",0,compete()));
		return listOfSprinters;
		
		
	}

}
