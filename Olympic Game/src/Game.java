package Console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import Participants.dataBase;
import Participants.superAthlete;
import Participants.Athlete;
import Participants.Cyclist;
import Participants.Participant;

public class Game {
	
	String gameID;
	Scanner input=new Scanner(System.in);
	ArrayList<Participant> athleteListAll = new ArrayList<Participant>();
	ArrayList<Participant> athleteList = new ArrayList<Participant>();
	
	// randomly selsect 5 to 8 athletes from our stored data for one game 
	public void appointAthlete(){
		
	}
	
	// randomly select a referee from our stored data for one game
	public void appointReferee(){
		
	}
	
	public void runGame(){
		mainMenu();
	}
	public void mainMenu(){
		int mainMenuSelection=0;
		boolean quitting=false;
		
		do{
			System.out.println("Ozlympic Game");
			System.out.println("===========================");
			System.out.println("1. Select a game to run");
			System.out.println("2. Predict the winner of the game");
			System.out.println("3. Start the game");
			System.out.println("4. Display the final results of all games");
			System.out.println("5. Display the points of all athletes");
			System.out.println("6. Exit");
			System.out.println();
			System.out.println("Enter an option: ");
			mainMenuSelection=input.nextInt();
			switch(mainMenuSelection){
			case 1:
				gameMenu();
				break;
			case 2:
				predictWinner();
				break;
			case 3:
				startGame();
				break;
			case 4:
				displayFinalResult();
				break;
			case 5:
				displayPoint();
				break;
			case 6:
				System.out.println("Shutting down.");
				quitting = true;
				break;
			default:
				System.out.println("Not a valid option!");
			}
		} while (quitting != true);
	}
	private void displayPoint() {
		// TODO Auto-generated method stub
		
	}

	private void displayFinalResult() {
		// TODO Auto-generated method stub
		
	}

	private void startGame() {
		for(int n=0;n<athleteList.size();n++)
		{
			if(athleteList.get(n) instanceof Cyclist)
			{
				System.out.println(athleteList.get(n).getName()+" uses "+((Cyclist) athleteList.get(n)).compete()+" seconds");
			}
			if(athleteList.get(n) instanceof superAthlete)
			{
				System.out.println(athleteList.get(n).getName()+" uses "+((superAthlete) athleteList.get(n)).compete()+" seconds");
			}
		}
	}

	private void predictWinner() {
		// TODO Auto-generated method stub
		
	}

	public void gameMenu(){
		int gameSelection=0;
		
		System.out.println("1.Create a swimming match");
		System.out.println("2.Create a cycling match");
		System.out.println("3.Create a running match");
		gameSelection=input.nextInt();
		switch(gameSelection){
		case 1:
			createSwimming();
			break;
		case 2:
			createCycling();
			break;
		}
	}

	public void createCycling() {
		int numAthlete=0;
		
		System.out.println("You hava created a cycling match!");
		System.out.println("Determine number of athlete in this game");
		numAthlete=input.nextInt();
		generateNum(numAthlete);
		System.out.println("Here are the participants: ");
		Iterator i = athleteList.iterator();
		while (i.hasNext())
			System.out.print(((Participant) i.next()).getName() + " ");
		System.out.println();
		System.out.println("=================================");
		System.out.println(">>>Returing to main menu....");
	}

	public void generateNum(int userInput) {
		int n = userInput;
		
		athleteListAll.clear();
		athleteList.clear();
		dataBase.setListOfCyclists();
		dataBase.setListOfSuperAthletes();
		
		//conbine athlete from cyclist and superAhlete
			athleteListAll.addAll(dataBase.cyclists);
			athleteListAll.addAll(dataBase.superAthletes);
			int total=athleteListAll.size();
		Random ra = new Random();	
		for (int j = 0; j < n; j++)
		{
			if(total>0){
			int random = ra.nextInt(total-1);
			athleteList.add(athleteListAll.get(random));
			athleteListAll.remove(athleteListAll.get(random));		
			}
			total--;
		}
			System.out.print("");
	}

	private void createSwimming() {
		// TODO Auto-generated method stub
		
	}


}