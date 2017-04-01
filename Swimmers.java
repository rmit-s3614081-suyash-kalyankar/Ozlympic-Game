package Participants;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wenbo peng
 *
 */
public class Swimmers implements Athletes  { 
	
	public int compete(){
		
		int swimTime = 0;
		swimTime = 100 + (int)(Math.random() * 100); 
		return swimTime;
		
	}
 
	public List<Participant> listOfSwimmers = new ArrayList<Participant>();
	
	public List<Participant> populateSwimmers(){
		
		
		listOfSwimmers.add(new Participant("SW01","John",29,"NSW",0,compete()));
		listOfSwimmers.add(new Participant("SW02","Jarad",30,"SA",0,compete()));
		listOfSwimmers.add(new Participant("SW04","Cass",29,"vic",0,compete()));
		listOfSwimmers.add(new Participant("SW05","Bruce",22,"vic",0,compete()));
		listOfSwimmers.add(new Participant("SW06","Candince",24,"WA",0,compete()));
		return listOfSwimmers;
		
		
	}

}