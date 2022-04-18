package simulator;

public class Card{
	private String display;
	private int value;

	public Card(int value, String display) {
		this.value = value;
		this.display = display;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getDisplay() {
		return this.display;
	}
}
