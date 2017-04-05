package Participants;

import java.util.ArrayList;
import java.util.List;

/**@Wenbo peng
 * 
 * 
 *
 */


// This is the Database of all Athletes including Super Athlete and Refree

public class Database {

	Swimmers swim = new Swimmers();
	Cyclists cycle = new Cyclists();
	Sprinters sprint = new Sprinters();
	
	//List of Swimmers which will take part in Swimming game
	
	public List<Athlete> listOfSwimmers = new ArrayList<Athlete>();
	
	public List<Athlete> populateSwimmers(){
		
		
		listOfSwimmers.add(new Athlete("SW01","Edmund",28,"Vic",0,swim.compete()));
		listOfSwimmers.add(new Athlete("SW02","Josh",22,"QLD",0,swim.compete()));
		listOfSwimmers.add(new Athlete("SW03","Ali",24,"SA",0,swim.compete()));
		listOfSwimmers.add(new Athlete("SW04","loki",29,"WA",0,swim.compete()));
		listOfSwimmers.add(new Athlete("SW05","Alam",32,"NSW",0,swim.compete()));
		listOfSwimmers.add(new Athlete("SW06","Happy",24,"Vic",0,swim.compete()));
		return listOfSwimmers;
		
		
	}
	
	//List Of Cyclists which will take part in Cycling game
	
	public List<Athlete> listOfCyclists = new ArrayList<Athlete>();
	
	public List<Athlete> populateCyclists(){
		
		
		listOfCyclists.add(new Athlete("CY01","Pratap",26,"WA",0,cycle.compete()));
		listOfCyclists.add(new Athlete("CY02","Suyash",27,"Vic",0,cycle.compete()));
		listOfCyclists.add(new Athlete("CY03","Alice",28,"QLD",0,cycle.compete()));
		listOfCyclists.add(new Athlete("CY04","Johnny",32,"NSW",0,cycle.compete()));
		listOfCyclists.add(new Athlete("CY05","Andy",28,"QLD",0,cycle.compete()));
		
		return listOfCyclists;
		
		
	}
	
	//List of Sprinters which will take part in Running game
	
	public List<Athlete> listOfSprinters = new ArrayList<Athlete>();
	
	public List<Athlete> populateSprinters(){
		
		
		listOfSprinters.add(new Athlete("SP01","Gaurav",28,"Vic",0,sprint.compete()));
		listOfSprinters.add(new Athlete("SP02","Cass",22,"Vic",0,sprint.compete()));
		listOfSprinters.add(new Athlete("SP03","yog",29,"QLD",0,sprint.compete()));
		listOfSprinters.add(new Athlete("SP05","Anky",26,"SA",0,sprint.compete()));
		listOfSprinters.add(new Athlete("SP04","Homy",26,"WA",0,sprint.compete()));
		
		return listOfSprinters;
		
		
	}
	
	// List Of SuperAthlete which will take part in all games i.e Swimming , Cycling and Running
	
	public List<Athlete> listOfSA = new ArrayList<Athlete>();
	
	public List<Athlete> populateSA(Compete ath){
		
		if(ath instanceof Swimmers){
			listOfSA.add(new Athlete("SA01","Ed",22,"Vic",0,swim.compete()));
			listOfSA.add(new Athlete("SA02","Bredon",24,"QLD",0,swim.compete()));
			listOfSA.add(new Athlete("SA03","Joshua",29,"WA",0,swim.compete()));
		}
		else if(ath instanceof Sprinters){
			listOfSA.add(new Athlete("SP01","Ed",22,"Vic",0,sprint.compete()));
			listOfSA.add(new Athlete("SP02","Bredon",24,"QLD",0,sprint.compete()));
			listOfSA.add(new Athlete("SP03","Joshua",29,"WA",0,sprint.compete()));
		}
		else if(ath instanceof Cyclists){
			listOfSA.add(new Athlete("CY01","Ed",22,"Vic",0,sprint.compete()));
			listOfSA.add(new Athlete("CY02","Bredon",24,"QLD",0,cycle.compete()));
			listOfSA.add(new Athlete("CY03","Joshua",29,"WA",0,cycle.compete()));
		}
		
		return listOfSA;
		
		
	}
	
	//List of All Refree which will Assign points to the Athletes depending on their finishing time and Winner will be announced
	
public List<Refree> listOfRefree = new ArrayList<Refree>();
	
	public List<Refree> populateRefree(){
		
		
		listOfRefree.add(new Refree("Ref1","David",28,"Vic"));
		listOfRefree.add(new Refree("Ref2","Steven",22,"QLD"));
		listOfRefree.add(new Refree("Ref3","kalan",24,"SA"));
		listOfRefree.add(new Refree("Ref4","Mukesh",29,"WA"));
		listOfRefree.add(new Refree("Ref5","Sajal",32,"NSW"));
		listOfRefree.add(new Refree("Ref6","RM",24,"Vic"));
		return listOfRefree;
		
		
	}
}
