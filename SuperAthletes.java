package Participants;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Wenbo Peng
 *
 */
public class SuperAthletes implements Athletes {

	public int compete(){
		
		int swimTime = 0;
		swimTime = 100 + (int)(Math.random() * 100); 
		return swimTime;
		
	}
List<Participant> listofsuperathletes = new ArrayList<Participant>();
	
	public List<Participant> populateSuperAthletes(){
		
		
		listofsuperathletes.add(new Participant("SA01","Ed",21,"Vic",0,compete()));
		listofsuperathletes.add(new Participant("SA02","Steve",28,"Qld",0,compete()));
		listofsuperathletes.add(new Participant("SA03","johny",36,"NSW",0,compete()));
		listofsuperathletes.add(new Participant("SA04","Sammy",23,"NSW",0,compete()));
		listofsuperathletes.add(new Participant("SA05","joshua",22,"QLD",0,compete()));
		return listofsuperathletes;

}
}