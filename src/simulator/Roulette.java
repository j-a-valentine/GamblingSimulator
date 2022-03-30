package simulator;
import java.util.ArrayList;

public class Roulette {

	private ArrayList<Pocket> pockets;

	public Roulette() {

		String wheel = "0-32-15-19-4-21-2-25-17-34-6-27-13-36-11-30-8-23-10-5-24-16-33-1-20-14-31-9-22-18-29-7-28-12-35-3-26";
		String[] wheelSplit = wheel.split("-");

		pockets = new ArrayList<Pocket>();

		for (int x = 0; x < wheelSplit.length; x++) {
			pockets.add(new Pocket(Integer.parseInt(wheelSplit[x])));
		}

	}

	public boolean addBet(double betAmount, int pocketNumber) {
		int pocketIndex = this.getPocketIndex(pocketNumber);
		if (pocketIndex == -1) {
			return false;
		}
		return this.pockets.get(pocketIndex).addBet(betAmount);
	}

	public boolean addBet(double betAmount, char evenOrOdd) {
		if (evenOrOdd == 'e' || evenOrOdd == 'E') {
			betAmount = betAmount / this.countPockets('e');
			for (int x = 0; x < this.pockets.size(); x++) {
				if (this.pockets.get(x).getNumber() % 2 == 0 && this.pockets.get(x).getNumber() != 0) {
					if (!this.pockets.get(x).addBet(betAmount)) {
						return false;
					}
				}
			}
			return true;
		} else if (evenOrOdd == 'o' || evenOrOdd == 'O') {
			betAmount = betAmount / this.countPockets('o');
			for (int x = 0; x < this.pockets.size(); x++) {
				if (this.pockets.get(x).getNumber() % 2 == 1) {
					if (!this.pockets.get(x).addBet(betAmount)) {
						return false;
					}
				}
			}
			return true;

		}
		return false;

	}
	
	public void displayBets() {
		for (Pocket p : this.pockets) {
			if (p.getBet() != 0) {
				System.out.println(p.getNumber() + " : $ " + p.getBet());
			}
		}
	}
	
	public double play() throws InterruptedException {
		this.displayWheel();
		int selectedIndex = this.spinWheel();
		this.displaySpin(selectedIndex);
		double winnings = this.evaluateBets(selectedIndex);
		this.clearBets();
		return winnings;
	}
	
	private int spinWheel() {
		return (int) (Math.random() * this.pockets.size());
	}

	private void displayWheel() {
		String wheelDisplay = "";
		for (Pocket x : this.pockets) {
			if (x.getNumber() < 10) {
				wheelDisplay += 0 + "";
			}
			wheelDisplay += x.getNumber() + " ";

		}
		System.out.println(wheelDisplay);
	}
	
	private void displaySpin(int selectedIndex) throws InterruptedException {
		for (int x = 0; x < selectedIndex; x++) {
			for (int y = 0; y < 3; y++) {
				Thread.sleep(50);
				System.out.print(".");
			}
		}
		System.out.println(".");
	}
	
	private double evaluateBets(int selectedIndex) {
		double winnings = this.pockets.get(selectedIndex).getBet() * 35;
		int winningNumber = this.pockets.get(selectedIndex).getNumber();
		System.out.println("Number " + winningNumber +" has won you $"+winnings+"!");
		return winnings;
	}

	private int getPocketIndex(int pocketNumber) {
		for (int x = 0; x < this.pockets.size(); x++) {
			if (this.pockets.get(x).getNumber() == pocketNumber) {
				return x;
			}
		}
		return -1;
	}
	
	private void clearBets() {
		for (Pocket p : this.pockets) {
			p.clearBet();
		}
	}

	private int countPockets(char evenOrOdd) {
		int count = 0;
		if (evenOrOdd == 'e' || evenOrOdd == 'E') {
			for (int x = 0; x < this.pockets.size(); x++) {
				if (this.pockets.get(x).getNumber() % 2 == 0 && this.pockets.get(x).getNumber() != 0) {
					count++;
				}
			}
		} else if (evenOrOdd == 'o' || evenOrOdd == 'O') {
			for (int x = 0; x < this.pockets.size(); x++) {
				if (this.pockets.get(x).getNumber() % 2 != 0 && this.pockets.get(x).getNumber() != 0) {
					count++;
				}
			}
		}
		return count;
	}
}
