
public class Pocket {
	
	private int number;
	private double bet;

	public Pocket(int number) {
		this.number = number;
		this.bet = 0;

	}
	
	public double getBet() {
		return this.bet;
	}

	public boolean addBet(double betAmount) {
		if (betAmount > 0) {
			this.bet += betAmount;
		}
		return betAmount > 0;
	}	

	public void clearBet(){
		this.bet = 0;
	}
}
