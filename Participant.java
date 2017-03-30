package Participants;
/**
 * 
 * @author Wenbo Peng
 *
 */
public class Participant implements Comparable<Participant> {
	
	
	private String id ;
	private String name ;
	private int age ;
	private String state ;
	private int totalPoints ;
	private int completeTime ;
	

	public Participant(String id, String name, int age, String state,int totalPoints,int completeTime) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.state = state;
		this.totalPoints = totalPoints;
		this.completeTime = completeTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	public int getCompleteTime() {
		return completeTime;
	}
	
	public void setCompleteTime(int completeTime) {
		this.completeTime = completeTime;
	}

	@Override
	public int compareTo(Participant p) {
		return completeTime - p.completeTime;
	}
	
	
	
	}


