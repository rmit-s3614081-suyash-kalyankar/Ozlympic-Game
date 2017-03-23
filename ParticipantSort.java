package ass1;

import java.util.Comparator;

public class ParticipantSort implements Comparator<Participant>{

	public int compare(Participant p1, Participant p2) {
		
		return p1.getCompleteTime()-p2.getCompleteTime();
	}

	
}
