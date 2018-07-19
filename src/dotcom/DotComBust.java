package dotcom;

import java.util.ArrayList;
import java.util.Scanner;

public class DotComBust {
	
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	private int numOfGuesses;
	private Scanner reader = new Scanner(System.in);
	private GameHelper gamehelp = new GameHelper();
	
	public void setUpGame() {
		// make some dot coms and give them locations
		DotCom one  = new DotCom();
		one.setName("Pets.com");
		
		DotCom two = new DotCom();
		two.setName("eToys.com");
		
		DotCom three = new DotCom();
		three.setName("Go2.com");
		
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, e2Toys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		// set up the init location
		for (DotCom dotComToSet: dotComList) {
			dotComToSet.setLocationCell(gamehelp.placeDotCom(3));
		}
	}
	
	
	public void startPlaying () {
		while (!dotComList.isEmpty()) {
			System.out.println("Enter a guess: ");
			String guess = reader.nextLine();
			checkUserGuess(guess);
		}
		
		// la lista de dotcoms se ha vaciado, hemos terminado el juego
		finishGame();
	}
	
	
	public void checkUserGuess (String userGuess) {
		numOfGuesses++;
		String result = "miss";
		
		
		// comprobamos cada dotcom de la lista
		for (DotCom dotComToTest: dotComList) {
			result = dotComToTest.checkYourself(userGuess);
			
			if (result.equals("hit")) {
				break;
			}
			
			if (result.equals("kill")) {
				dotComList.remove(dotComToTest);
				break;
			}
			
		}
		
		System.out.println(result);
	}
	
	
	public void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		
		if (numOfGuesses <= 18) {
			System.out.println("It only took  you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sank.");
		} else {
			System.out.println("Took you long enough " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
		
	}
	

	
	public static void main (String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
	

}
