package wargame;

public class Card {

	private String card; 
	private String suit; 
	private int rank;
	
	public Card(String card, String suit, int rank) {
		this.card = card;
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return card + " of " + suit;
	}

	public int getRank() {
		return rank;
	}

}
