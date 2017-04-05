package Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Participants.Athletes;
import Participants.Cyclists;
import Participants.Database;
import Participants.Participant;
import Participants.Sprinters;
import Participants.Swimmers;


/**@Suyash Kalyankar
 * 
 * 
 *
 */


public class Driver {
	
	
	// Displays the game menu
	public void menu(){
		
		getMenu();
		
		Athletes athletes = null;
		Participant userSelection = null;
		List<Participant> abc = null;
		
		for (int userInput = 0; userInput < 7; userInput++) {
			
			userInput = getUserInput();
			
			if(userInput == 1){
				
				athletes=selectGame();
				getMenu();
			}
			
			else if(userInput == 2){
				 abc = new ArrayList<Participant>();
			;
				// if game is not selected and user is directly predicting , prompting the user to main menu
				if(null==athletes){
					System.out.println("Please select game first");
					menu();
				}else{
				userSelection = predictWinner(athletes,abc);
				getMenu();
				}
			}

			else if(userInput == 3){
				
				startGame(athletes,abc,userSelection );
				getMenu(); 
			}
			
			else if(userInput == 4){
			
				displayFinalResult(finalResultMap);
				getMenu();
			}
			
			else if(userInput == 5){
			
				displayAthletePoints(finalAthletePointsMap);
				getMenu();
			}
			
			else if(userInput == 6){
			
			}
			
			else{
				System.out.println("Wrong input !!! Please input again !!");
				getMenu();
				userInput=0;
			}
		}
	}

	
	

	
	

	
	/**
	 * 
	 */
	
	//Lets Play the Ozlymic Game 
	
	
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
		
		Athletes selectgame = null;
		
		if(userInput == 1){
			selectgame = new Swimmers();
		}
		
		else if(userInput == 2){
			selectgame = new Cyclists();
		}

		else if(userInput == 3){
			selectgame = new Sprinters();
		}
		
		else{
			System.out.println("Wrong input !!! Please input again !!");
			menu();
		}
		
		return selectgame;
		
	}
	
	// Predict the winner of the game -- Give user list of participants and take the user's prediction 
	
	public Participant predictWinner(Athletes ath,List<Participant> abc) {

		System.out.println("Please predict the winner of the game. Below is the list of participants. Please choose one amongst them");
		System.out.println("=========================");

		Random randomNumberOfPlayers = new Random();
		int randomNumber = randomNumberOfPlayers.nextInt(7);
		randomNumber++;
		Participant userSelection = null;

		if (randomNumber <= 4) {
			System.out.println("Game is cancelled since there are less than 4 participants.Please start again");
		} else {

			List<Participant> allParticipant = new ArrayList<Participant>();
			Database game = new Database();

			

			if (ath instanceof Swimmers) {
				
				game.populateSwimmers();
				game.populateSA(ath);
				for (Participant Swimmer : game.listOfSwimmers) {
					allParticipant.add(Swimmer);
				}
				for (Participant superAthlete : game.listOfSA) {
					allParticipant.add(superAthlete);
				}
			} else if (ath instanceof Cyclists) {
				
				game.populateCyclists();
				game.populateSA(ath);
				for (Participant Cyclists : game.listOfCyclists) {
					allParticipant.add(Cyclists);
				}
				for (Participant superAthlete : game.listOfSA) {
					allParticipant.add(superAthlete);
				}
			} else if (ath instanceof Sprinters) {
				
				game.populateSprinters();
				game.populateSA(ath);
				for (Participant Sprinter : game.listOfSprinters) {
					allParticipant.add(Sprinter);
				}
				for (Participant superAthlete : game.listOfSA) {
					allParticipant.add(superAthlete);
				}
			}

			Collections.shuffle(allParticipant);
			for (int i = 0; i < randomNumber; i++) {
				abc.add(allParticipant.get(i));
			}

			int i = 1;
			for (Participant players : abc) {
				System.out.println(i + "." + players.getName());
				i++;
			}

			int userInput = getUserInput();

			if (userInput <= abc.size()) {
				
				userSelection = abc.get(userInput - 1);
			} else {
				System.out.println("Wrong input !!! Please input again !!");
				menu();
			}

		}
		return userSelection;

	}
	/**
	 @param abc
	 * @param i
	 */
	public void updateTotalPoints(List<Participant> list) {
			for (int i = 0; i < list.size(); i++) {
				if(!finalAthletePointsMap.containsKey(list.get(i).getId())) {
						finalAthletePointsMap.put(list.get(i).getId(),list.get(i));
					}else{
						list.get(i).setTotalPoints(list.get(i).getTotalPoints() + finalAthletePointsMap.get(list.get(i).getId()).getTotalPoints());
						finalAthletePointsMap.put(list.get(i).getId(),list.get(i));
					}
			}
	}

	public List<Participant> updatePoints(List<Participant> abc){
		abc.get(0).setTotalPoints(5);
		abc.get(1).setTotalPoints(2);
		abc.get(2).setTotalPoints(1);
		return abc;
		
	}
	

	// Start the game - take the complete time of respective participant
private void startGame(Athletes athlete ,List<Participant> result, Participant userSelection ) {
	
	if (null !=userSelection) {
		
		if (athlete instanceof Swimmers) {
			
			Collections.sort(result);
			result = updatePoints(result);
			for (int i = 0; i < result.size(); i++) {
				System.out.println("Id : "+result.get(i).getId()+"---- name :" + result.get(i).getName()+"---- State :"+result.get(i).getState()
						+ "---- complete time  :" + result.get(i).getCompleteTime());
			}
			if (result.get(0).getId().equals(userSelection.getId())) {
				System.out.println("User  won !!");
			}
			updateTotalPoints(result);
			finalResultMap.put("SW" + swimmerGameIdCounter, result);
			swimmerGameIdCounter++;
			
		} else if (athlete instanceof Cyclists) {
			
			Collections.sort(result);
			result = updatePoints(result);
			for (int i = 0; i < result.size(); i++) {
				System.out.println("Id : "+result.get(i).getId()+"---- name :" + result.get(i).getName()+"---- State :"+result.get(i).getState()
						+ "---- complete time  :" + result.get(i).getCompleteTime());
			}
			if (result.get(0).getId().equals(userSelection.getId())) {
				System.out.println("User won !!");
			}
			updateTotalPoints(result);
			finalResultMap.put("CY" + cyclistGameIdCounter, result);
			cyclistGameIdCounter++;
			
		} else if (athlete instanceof Sprinters) {
			
			Collections.sort(result);
			result = updatePoints(result);
			for (int i = 0; i < result.size(); i++) {
				System.out.println("Id : "+result.get(i).getId()+"---- name :" + result.get(i).getName()+"---- State :"+result.get(i).getState()
						+ "---- complete time  :" + result.get(i).getCompleteTime());
			}
			if (result.get(0).getId().equals(userSelection.getId())) {
				System.out.println("User won !!");
			}
			
			updateTotalPoints(result);
			finalResultMap.put("SP" + sprinterGameIdCounter, result);
			sprinterGameIdCounter++;
		}
	}else{
		System.out.println("Please predict first and then start the game");
	}
	
}

//Results of all the games played and Refree assigned to each game with their id
private void displayFinalResult(Map<String, List<Participant>> finalResult) {
	
	for (Map.Entry<String, List<Participant>> entry : finalResult.entrySet()) {
		System.out.println("Results of Game with game id : " + entry.getKey());
		System.out.println("***************");
		for(Participant p : entry.getValue()){
			System.out.println("Player Name : " + p.getName() + "---- Player points :" + p.getTotalPoints());
		}
		Database game = new Database();
		game.populateRefree();
		Random randomRefree = new Random();
		int randomNumber = randomRefree.nextInt(4);
		randomNumber++;
		System.out.println("Refree Id :"+game.listOfRefree.get(randomNumber).getId());
		System.out.println("Refree Name :"+game.listOfRefree.get(randomNumber).getName());
		
	}
	
	
	
}

//Displaying the Final Result of all athletes including superAthlete
Map<String,List<Participant>> finalResultMap = new HashMap<String,List<Participant>>(); 
Map<String,Participant> finalAthletePointsMap = new HashMap<String,Participant>(); 
int swimmerGameIdCounter = 1;
int cyclistGameIdCounter = 1;
int sprinterGameIdCounter = 1;

private void displayAthletePoints(Map<String, Participant> athletePointsMap) {

for (Map.Entry<String, Participant> entry : athletePointsMap.entrySet()) {
	System.out.println("Final Points of all Athletes ");
	System.out.println("***************");
	System.out.println("Player Id : " + entry.getKey() + "---- Player Name : " + entry.getValue().getName() + "---- Player State :"+entry.getValue().getState()+
			"---- Player Total Points : " + entry.getValue().getTotalPoints());
}
}


}