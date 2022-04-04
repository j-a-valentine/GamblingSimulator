package simulator;
import java.util.Scanner;

public class GamblingSystem {
	
	private Roulette roulette;
	
	public GamblingSystem() {
		this.roulette = new Roulette();
	}
	
	public boolean placeBet() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Please place your bet"); // dollar amount and (pocket OR e/o)

	    String[] userBet = myObj.nextLine().split(" ");
	    
	    if(isValidBet(userBet)) {
	    	double betAmount = Double.parseDouble(userBet[0]);
		    int betLocation = Integer.parseInt(userBet[1]);
		    
	    	if(Character.isLetter(betLocation)) {
		    	return this.roulette.addBet(betAmount, (char)betLocation);
		    }
		    return this.roulette.addBet(betAmount, betLocation);
	    }
	    else {
	    	System.out.println("Bet is not valid");
	    	return false;
	    }
	}
	
	private boolean isValidBet(String[] userBet) {
	    try {
	    	double betAmount = Double.parseDouble(userBet[0]);
		    int betLocation = Integer.parseInt(userBet[1]);
		    return true;
	    }
	    catch (NumberFormatException e){
	    	return false;
	    }
	}
}
