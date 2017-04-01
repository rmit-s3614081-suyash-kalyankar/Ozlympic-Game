package Participants;

public class Participant {

	// instance variables
	private String ID;
	private String name;
	private int age;
	private String state;

	// constructor
	public Participant(String ID, String name, int age, String state) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.state = state;
	}
	public String getName()
	{
		return name;
	}
}