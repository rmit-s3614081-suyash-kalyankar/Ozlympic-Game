package Participants;

import java.util.Random;

public class superAthlete extends Athlete{
	// constructor
		public superAthlete(String ID, String name, int age, String state) {
			super(ID,name,age,state);
		}

		@Override
		public int compete() {
			int max = 800;
			int min = 500;
			Random Rand = new Random();
			int ranNum = Rand.nextInt(max - min) + min;
			return ranNum;
		}

}
