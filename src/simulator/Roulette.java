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
			betAmount /= this.countEvenPockets();
			return this.betEven(betAmount);
		}

		else if (evenOrOdd == 'o' || evenOrOdd == 'O') {
			betAmount /= this.countOddPockets();
			return this.betOdd(betAmount);
		} else {
			return false;
		}

	}

	public void displayBets() {
		System.out.println("Current Bets:");
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

	public void displayWheel() {
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
		double winnings = this.pockets.get(selectedIndex).getBet() * 36;
		int winningNumber = this.pockets.get(selectedIndex).getNumber();
		winnings = Math.round(winnings*100)/100.0;
		System.out.println("Number " + winningNumber + " has won you $" + winnings + "!");
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

	private int countEvenPockets() {
		int count = 0;
		for (int x = 0; x < this.pockets.size(); x++) {
			if (this.pockets.get(x).getNumber() % 2 == 0 && this.pockets.get(x).getNumber() != 0) {
				count++;
			}
		}
		return count;
	}

	private int countOddPockets() {
		int count = 0;
		for (int x = 0; x < this.pockets.size(); x++) {
			if (this.pockets.get(x).getNumber() % 2 != 0 && this.pockets.get(x).getNumber() != 0) {
				count++;
			}
		}
		return count;
	}

	private boolean betEven(double betAmount) {
		for (int x = 0; x < this.pockets.size(); x++) {
			if (this.pockets.get(x).getNumber() % 2 == 0 && this.pockets.get(x).getNumber() != 0) {
				if (!this.pockets.get(x).addBet(betAmount)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean betOdd(double betAmount) {
		for (int x = 0; x < this.pockets.size(); x++) {
			if (this.pockets.get(x).getNumber() % 2 == 1) {
				if (!this.pockets.get(x).addBet(betAmount)) {
					return false;
				}
			}
		}
		return true;
	}
}
