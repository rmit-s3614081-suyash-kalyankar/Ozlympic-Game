package Participants;

/**@Wenbo peng
 * 
 * 
 *
 */


public class Sprinters implements Athletes {

	public int compete(){
		
		int sprintTime = 0;
		sprintTime = 10 + (int)(Math.random() * 10); 
		return sprintTime;
	}

}
