package ass1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Driver {
	
	// Displays the game menu
	public void menu(){
		
		getMenu();
		
		Athletes ath = null;
		Participant userSelection = null;
		List<Participant> abc = new ArrayList<Participant>();
		
		for (int userInput = 0; userInput < 7; userInput++) {
			
			userInput = getUserInput();
			
			if(userInput == 1){
				//System.out.println("user input 1");
				ath=selectGame();
				getMenu();
			}
			
			else if(userInput == 2){
			//	System.out.println("user input 2");
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
				//System.out.println("user input 3");
				startGame(ath , userSelection );
				getMenu(); 
			}
			
			else if(userInput == 4){
			//	System.out.println("user input 4");
				getMenu();
			}
			
			else if(userInput == 5){
			//	System.out.println("user input 5");
				getMenu();
			}
			
			else if(userInput == 6){
			//	System.out.println("user input 6");
			}
			
			else{
				System.out.println("Wrong input !!! Please input again !!");
				getMenu();
				userInput=0;
			}
		}
	}

	// Start the game - take the complete time of respective participant
	private void startGame(Athletes ath , Participant userSelection ) {
		
		//ParticipantSort ps = new ParticipantSort();
		if(ath instanceof Swimmers){
			Swimmers s = new Swimmers();	
			s.populateSwimmers();
			List<Participant> abc = s.listOfSwimmers;
			Collections.sort(abc);
			for(int i =0 ; i<abc.size() ; i++){
				System.out.println("name :" + abc.get(i).getName() +"state"+abc.get(i).getState() + "**complete time" + abc.get(i).getCompleteTime());
				}
			if(abc.get(0).getId().equals(userSelection.getId())){
				System.out.println("You won !!");
			}
		}
		else if (ath instanceof Cyclists){
			Cyclists s = new Cyclists();	
			List<Participant> abc = s.listOfCyclists;
			Collections.sort(abc);
			for(int i =0 ; i<abc.size() ; i++){
				System.out.println("name :" + abc.get(i).getName() + "**complete time" + abc.get(i).getCompleteTime());
				}
			if(abc.get(0).getId().equals(userSelection.getId())){
				System.out.println("You won !!");
			}
		}
		else if(ath instanceof Sprinters){
			Sprinters s = new Sprinters();
			List<Participant> abc = s.listOfSprinters;
			Collections.sort(abc);
			for(int i =0 ; i<abc.size() ; i++){
				System.out.println("name" + abc.get(i).getName() + "**complete time" + abc.get(i).getCompleteTime());
				}
			if(abc.get(0).getId().equals(userSelection.getId())){
				System.out.println("You won !!");
			}
		}
			
		
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