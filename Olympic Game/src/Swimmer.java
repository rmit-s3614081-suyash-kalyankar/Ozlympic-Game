package Participants;

import java.util.Random;

public class Swimmer extends Athlete {

	// constructor
	public Swimmer(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}

	// randomly generate 100 to 200 seconds for a swimmer's performance
	public int compete() {
		int max = 200;
		int min = 100;
		Random Rand = new Random();
		int ranNum = Rand.nextInt(max - min) + min;
		return ranNum;
	}
}
