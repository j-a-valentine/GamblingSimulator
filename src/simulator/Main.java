package simulator;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		GamblingSystem g = new GamblingSystem();
//		g.deposit(200);
//		while (true) {
//			g.runRoulette();
//		}
		
		Hand h = new Hand(true);
		h.addCard(new Card(10,"10"));
		h.addCard(new Card(10, "J"));
		System.out.println(h);
	}

}
