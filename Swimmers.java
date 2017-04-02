package Participants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author wenbo peng
 *
 */
public class Swimmers implements Athletes  { 
	
	public int compete(){
		// Randomly generate the Swimtime of Swimmers
		int swimTime = 0;
		swimTime = 100 + (int)(Math.random() * 100); 
		return swimTime;
		
	}
 
	public List<Participant> listOfSwimmers = new ArrayList<Participant>();
	
	public List<Participant> populateSwimmers(){
		
		 
		//List of Swimmers and Superathletes
		listOfSwimmers.add(new Participant("SW01","John",29,"NSW",0,compete()));
		listOfSwimmers.add(new Participant("SW02","Jarad",30,"SA",0,compete()));
		listOfSwimmers.add(new Participant("SW03","Cass",29,"vic",0,compete()));
		listOfSwimmers.add(new Participant("SW04","Bruce",22,"vic",0,compete()));
		listOfSwimmers.add(new Participant("SW05","Candince",24,"WA",0,compete()));
		listOfSwimmers.add(new Participant("SA05","joshua",22,"QLD",0,compete()));
		listOfSwimmers.add(new Participant("SA04","Sammy",23,"NSW",0,compete()));
		
		
			
		
		return listOfSwimmers;
		
		
	}

}