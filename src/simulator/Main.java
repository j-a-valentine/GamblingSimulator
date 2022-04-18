package simulator;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		GamblingSystem g = new GamblingSystem();
//		g.deposit(200);
//		while (true) {
//			g.runRoulette();
//		}
		
		Deck d = new Deck();
		d.generateCards();
		System.out.println(d.toString());
		d.shuffleCards();
		System.out.println(d);
	}

}
