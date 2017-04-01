package Participants;

public abstract class Athlete extends Participant {

	// subclass constructor
	public Athlete(String ID, String name, int age, String state) {
		// call the superclass constructor
		super(ID, name, age, state);	
	}

	// abstract method 
	public abstract int compete();
	
	
}