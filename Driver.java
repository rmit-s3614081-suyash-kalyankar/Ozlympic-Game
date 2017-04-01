package Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Participants.Athletes;
import Participants.Cyclists;
import Participants.Participant;
import Participants.Sprinters;
import Participants.Swimmers;

public class Driver {
	
	Map<String,List<Participant>> finalResultMap = new HashMap<String,List<Participant>>(); 
	Map<String,Participant> finalAthletePointsMap = new HashMap<String,Participant>(); 
	int swimmerGameIdCounter = 1;
	int cyclistGameIdCounter = 1;
	int sprinterGameIdCounter = 1;
	// Displays the game menu
	public void menu(){
		
		getMenu();
		
		Athletes ath = null;
		Participant userSelection = null;
		List<Participant> abc = new ArrayList<Participant>();
		
		for (int userInput = 0; userInput < 7; userInput++) {
			
			userInput = getUserInput();
			
			if(userInput == 1){
				//System.out.println("user inpput 1");
				ath=selectGame();
				getMenu();
			}
			
			else if(userInput == 2){
			//	System.out.println("user inpput 2");
				// if game is not selected and user is directly predicting , prompting the user to main menu
				if(null==ath){
					System.out.println("Please select game first");
					menu();
				}else{
				userSelection = predictWinner(ath);
				getMenu();
				}
			}

			else if(userInput == 3){
				//System.out.println("user inpput 3");
				startGame(ath , userSelection );
				getMenu(); 
			}
			
			else if(userInput == 4){
			//	System.out.println("user inpput 4");
				displayFinalResult(finalResultMap);
				getMenu();
			}
			
			else if(userInput == 5){
			//	System.out.println("user inpput 5");
				displayAthletePoints(finalAthletePointsMap);
				getMenu();
			}
			
			else if(userInput == 6){
			//	System.out.println("user inpput 6");
			}
			
			else{
				System.out.println("Wrong input !!! Please input again !!");
				getMenu();
				userInput=0;
			}
		}
	}

	private void displayAthletePoints(Map<String, Participant> athletePointsMap) {
		
		for (Map.Entry<String, Participant> entry : athletePointsMap.entrySet()) {
			System.out.println("Final Points of all Athletes ");
			System.out.println("***************");
			System.out.println("Player Id : " + entry.getKey() + "Player Name : " + entry.getValue().getName() + 
					"Player Total Points : " + entry.getValue().getTotalPoints());
		}
	}

	private void displayFinalResult(Map<String, List<Participant>> finalResult) {
		
		for (Map.Entry<String, List<Participant>> entry : finalResult.entrySet()) {
			System.out.println("Results of Game with game id : " + entry.getKey());
			System.out.println("***************");
			for(Participant p : entry.getValue()){
				System.out.println("Player Name " + p.getName() + "Player points " + p.getTotalPoints());
			}
		}
		
	}

	// Start the game - take the complete time of respective participant
	private void startGame(Athletes ath , Participant userSelection ) {
		
		if (null !=userSelection) {
			//ParticipantSort ps = new ParticipantSort();
			if (ath instanceof Swimmers) {
				Swimmers s = new Swimmers();
				s.populateSwimmers();
				List<Participant> abc = s.listOfSwimmers;
				Collections.sort(abc);
				abc = updatePoints(abc);
				for (int i = 0; i < abc.size(); i++) {
					System.out.println("name" + abc.get(i).getName()
							+ "**complete time" + abc.get(i).getCompeteTime());
				}
				if (abc.get(0).getId().equals(userSelection.getId())) {
					System.out.println("u won !!");
				}
				updateTotalPoints(abc);
				finalResultMap.put("SW" + swimmerGameIdCounter, abc);
				swimmerGameIdCounter++;
				
			} else if (ath instanceof Cyclists) {
				Cyclists s = new Cyclists();
				s.populateCyclists();
				List<Participant> abc = s.listOfCyclists;
				Collections.sort(abc);
				abc = updatePoints(abc);
				for (int i = 0; i < abc.size(); i++) {
					System.out.println("name" + abc.get(i).getName()
							+ "**complete time" + abc.get(i).getCompeteTime());
				}
				if (abc.get(0).getId().equals(userSelection.getId())) {
					System.out.println("u won !!");
				}
				updateTotalPoints(abc);
				finalResultMap.put("CY" + cyclistGameIdCounter, abc);
				cyclistGameIdCounter++;
				
			} else if (ath instanceof Sprinters) {
				Sprinters s = new Sprinters();
				s.populateSprinters();
				List<Participant> abc = s.listOfSprinters;
				Collections.sort(abc);
				abc = updatePoints(abc);
				for (int i = 0; i < abc.size(); i++) {
					System.out.println("name" + abc.get(i).getName()
							+ "**complete time" + abc.get(i).getCompeteTime());
				}
				if (abc.get(0).getId().equals(userSelection.getId())) {
					System.out.println("u won !!");
				}
				
				updateTotalPoints(abc);
				finalResultMap.put("SP" + sprinterGameIdCounter, abc);
				sprinterGameIdCounter++;
			}
		}else{
			System.out.println("Please predict first and then start the game");
		}
		
	}

	/**
	 * @param abc
	 * @param i
	 */
	public void updateTotalPoints(List<Participant> abc) {
			for (int i = 0; i < abc.size(); i++) {
				if(!finalAthletePointsMap.containsKey(abc.get(i).getId())) {
						finalAthletePointsMap.put(abc.get(i).getId(),abc.get(i));
					}else{
						abc.get(i).setTotalPoints(abc.get(i).getTotalPoints() + finalAthletePointsMap.get(abc.get(i).getId()).getTotalPoints());
						finalAthletePointsMap.put(abc.get(i).getId(),abc.get(i));
					}
			}
	}

	public List<Participant> updatePoints(List<Participant> abc){
		abc.get(0).setTotalPoints(5);
		abc.get(1).setTotalPoints(3);
		abc.get(2).setTotalPoints(2);
		return abc;
		
	}
	/**
	 * 
	 */
	private void getMenu() {
		System.out.println("Ozlympic Game");
		System.out.println("=========================");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the game");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
	}
	
	// Get the user input
	public int getUserInput(){
		
		int userInput = 0;
		try {
			Scanner sc = new Scanner(System.in);
			userInput = sc.nextInt();
		} catch (Exception e) {
		}
		
		return userInput;
		
	}
	
	// select a game to run
	public Athletes selectGame(){
		
		System.out.println("Select a Game to run");
		System.out.println("=========================");
		System.out.println("1. Swimming");
		System.out.println("2. Cycling");
		System.out.println("3. Running");
		
		int userInput = getUserInput();
		
		Athletes ath = null;
		
		if(userInput == 1){
			ath = new Swimmers();
		}
		
		else if(userInput == 2){
			ath = new Cyclists();
		}

		else if(userInput == 3){
			ath = new Sprinters();
		}
		
		else{
			System.out.println("Wrong input !!! Please input again !!");
			menu();
		}
		
		return ath;
		
	}
	
	// Predict the winner of the game -- Give user list of participants and take the user's prediction 
	
	public Participant predictWinner(Athletes ath){
		
		System.out.println("Please predict the winner of the game. Below is the list of participants. Please choose one amongst them");
		System.out.println("=========================");
		
		List<Participant> abc = new ArrayList<Participant>();
		
		if(ath instanceof Swimmers){
			Swimmers s = new Swimmers();
			s.populateSwimmers();
			for(Participant p:s.listOfSwimmers){
			abc.add(p);
			}
		}
		else if (ath instanceof Cyclists){
			Cyclists s = new Cyclists();	
			s.populateCyclists();
			for(Participant p:s.listOfCyclists){
				abc.add(p);
				}
		}
		else if(ath instanceof Sprinters){
			Sprinters s = new Sprinters();	
			s.populateSprinters();
			for(Participant p:s.listOfSprinters){
				abc.add(p);
				}
		}
		
		int i = 1;
		for(Participant p : abc){
			System.out.println(i + "." + p.getName());
			i++;
			}
		
		int userInput = getUserInput();
		
		Participant userSelection = null;
		if(userInput<=abc.size()){
		//	System.out.println(abc.size());
			userSelection = abc.get(userInput-1);
		}else{
			System.out.println("Wrong input !!! Please input again !!");
			menu();
		}
		
		return userSelection;
		
	}
	
}