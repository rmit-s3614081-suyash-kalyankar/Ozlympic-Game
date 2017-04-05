package Participants;


/**@Wenbo peng
 * 
 * 
 *
 */

public class Cyclists implements Athletes {

	public int compete(){
		
		int cycleTime = 0;
		cycleTime = 500 + (int)(Math.random() * 300); 
		return cycleTime;
	}

}
