package ass1;

import java.util.Scanner;

public class Driver {
	
	// Displays the game menu
	public void menu(){
		
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
	
	public void getUserInput(){
		
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		
		
		if(userInput == 1){
			
			System.out.println("user inpput 1");
		}
		
		
		else if(userInput == 2){
			
			System.out.println("user inpput 2");
		}
		

		else if(userInput == 3){
			
			System.out.println("user inpput 3");
		}
		
		
		else if(userInput == 4){
			System.out.println("user inpput 4");
		}
		
		
		else if(userInput == 5){
			System.out.println("user inpput 5");
		}
		
		else if(userInput == 6){
			System.out.println("user inpput 6");
		
		}
		
		else{
			System.out.println("Wrong input !!! Please input again !!");
			menu();
		}
	}
}