package Participants;

/**@Wenbo peng
 * 
 * 
 *
 */

public class Athlete extends Participant implements Comparable<Athlete> {
	
	

	private int totalPoints ;
	private int completeTime ;
	

	public Athlete(String id, String name, int age, String state,int totalPoints,int completeTime) {
		super(id,name,age,state);
				
		this.totalPoints = totalPoints;
		this.completeTime = completeTime;
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
	public int compareTo(Athlete p) {
		return completeTime - p.completeTime;
	}
	
	

}
