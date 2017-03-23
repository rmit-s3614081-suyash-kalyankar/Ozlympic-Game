package ass1;

import java.util.ArrayList;
import java.util.List;

public class Sprinters implements Athletes {

	public int compete(){
		
		int sprintTime = 0;
		sprintTime = 10 + (int)(Math.random() * 10); 
		return sprintTime;
	}
	
	List<Participant> listOfSprinters = new ArrayList<Participant>();
	
	public List<Participant> populateSprinters(){
		
		
		listOfSprinters.add(new Participant("SP01","Edmund",32,"QLD",0,compete()));
		listOfSprinters.add(new Participant("SP02","SuyashSP",25,"Vic",0,compete()));
		listOfSprinters.add(new Participant("SP03","Ali",10,"Tas",0,compete()));
		
		return listOfSprinters;
		
		
	}

}
