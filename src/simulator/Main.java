package simulator;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		Roulette r = new Roulette();
		r.addBet(100, 'o');
		r.addBet(1, 0);
		r.addBet(15, 11);
		r.addBet(6, 20);
		//r.displayBets();
		r.play();
	}

}
