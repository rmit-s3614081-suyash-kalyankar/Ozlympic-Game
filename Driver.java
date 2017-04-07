package Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Participants.Compete;
import Participants.Cyclists;
import Participants.Database;
import Participants.Athlete;
import Participants.Sprinters;
import Participants.Swimmers;


/**@Suyash Kalyankar
 * 
 * 
 * 
 *
 */


public class Driver {
	
	
	Map<String,List<Athlete>> finalResultMap = new HashMap<String,List<Athlete>>(); 
	Map<String,Athlete> finalAthletePointsMap = new HashMap<String,Athlete>(); 
	int swimmerGameIdCounter = 1;
	int cyclistGameIdCounter = 1;
	int sprinterGameIdCounter = 1;
	
	
	
	// Displays the game menu
	public void menu(){
		
		getMenu();
		
		Compete athletes = null;
		Athlete userSelection = null;
		List<Athlete> abc = null;
		
		for (int userInput = 0; userInput < 7; userInput++) {
			
			userInput = getUserInput();
			
			if(userInput == 1){
				
				athletes=selectGame();
				getMenu();
			}
			
			else if(userInput == 2){
				 abc = new ArrayList<Athlete>();
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
	public Compete selectGame(){
		
		System.out.println("Select a Game to run");
		System.out.println("=========================");
		System.out.println("1. Swimming");
		System.out.println("2. Cycling");
		System.out.println("3. Running");
		
		int userInput = getUserInput();
		
		Compete selectgame = null;
		
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
	
	public Athlete predictWinner(Compete ath,List<Athlete> abc) {

		System.out.println("Please predict the winner of the game. Below is the list of participants. Please choose one amongst them");
		System.out.println("=========================");

		
		
		//Randomly generates the list of players , game will be cancelled if the athletes are less than 4
		
		Random randomNumberOfPlayers = new Random();
		int randomNumber = randomNumberOfPlayers.nextInt(7);
		randomNumber++;
		Athlete userSelection = null;

		if (randomNumber <= 4) {
			System.out.println("Game is cancelled since there are less than 4 participants.Please start again");
		} else {

			List<Athlete> allParticipant = new ArrayList<Athlete>();
			Database game = new Database();

			

			if (ath instanceof Swimmers) {
				
				game.populateSwimmers();
				game.populateSA(ath);
				for (Athlete Swimmer : game.listOfSwimmers) {
					allParticipant.add(Swimmer);
				}
				for (Athlete superAthlete : game.listOfSA) {
					allParticipant.add(superAthlete);
				}
			} else if (ath instanceof Cyclists) {
				
				game.populateCyclists();
				game.populateSA(ath);
				for (Athlete Cyclists : game.listOfCyclists) {
					allParticipant.add(Cyclists);
				}
				for (Athlete superAthlete : game.listOfSA) {
					allParticipant.add(superAthlete);
				}
			} else if (ath instanceof Sprinters) {
				
				game.populateSprinters();
				game.populateSA(ath);
				for (Athlete Sprinter : game.listOfSprinters) {
					allParticipant.add(Sprinter);
				}
				for (Athlete superAthlete : game.listOfSA) {
					allParticipant.add(superAthlete);
				}
			}

			Collections.shuffle(allParticipant);
			for (int i = 0; i < randomNumber; i++) {
				abc.add(allParticipant.get(i));
			}

			int i = 1;
			for (Athlete players : abc) {
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
	
	public void updateTotalPoints(List<Athlete> list) {
			for (int i = 0; i < list.size(); i++) {
				String gameId = list.get(i).getId();
				if(!finalAthletePointsMap.containsKey(gameId)) {
						finalAthletePointsMap.put(gameId,list.get(i));
					}else{
						finalAthletePointsMap.get(gameId).setTotalPoints(finalAthletePointsMap.get(gameId).getTotalPoints()+ list.get(i).getTotalPoints());
					}
			}
	}

	public List<Athlete> updatePoints(List<Athlete> points){
		points.get(0).setTotalPoints(5);
		points.get(1).setTotalPoints(2);
		points.get(2).setTotalPoints(1);
		return points;
		
	}
	

	// Start the game - take the complete time of respective participant
private void startGame(Compete athlete ,List<Athlete> result, Athlete userSelection ) {
	
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
			
			finalResultMap.put("SP" + sprinterGameIdCounter, result);
	
			sprinterGameIdCounter++;
		}
	}else{
		System.out.println("Please predict first and then start the game");
	}
	
}

//Results of all the games played and Referee assigned to each game with their id


private void displayFinalResult(Map<String, List<Athlete>> finalResult) {
	
	for (Map.Entry<String, List<Athlete>> entry : finalResult.entrySet()) {
		System.out.println("Results of Game with game id : " + entry.getKey());
		System.out.println("***************");
		for(Athlete p : entry.getValue()){
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


private void displayAthletePoints(Map<String, Athlete> athletePointsMap) {

for (Map.Entry<String, List<Athlete>> entry : finalResultMap.entrySet()) {
	updateTotalPoints(entry.getValue());
}
	
for (Map.Entry<String, Athlete> entry : athletePointsMap.entrySet()) {
	System.out.println("Final Points of all Athletes ");
	System.out.println("***************");
	System.out.println("Player Id : " + entry.getKey() + "---- Player Name : " + entry.getValue().getName() + "---- Player State :"+entry.getValue().getState()+
			"---- Player Total Points : " + entry.getValue().getTotalPoints());
}
}


}