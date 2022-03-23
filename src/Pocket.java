
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
	public double addBet(int number, double bet) {
			this.bet = this.bet + bet;
				return this.bet;
	}	

}
