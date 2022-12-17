package wargame;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class Deck extends LinkedList<Card> {
	private List<String> cards = List.of("2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace");

	private List<String> suits = List.of("Hearts", "Clubs", "Diaminds", "Spades");
	
	public Deck() {
		for(int cardPos = 0; cardPos < cards.size(); cardPos++) {
		int rank = cardPos + 2;
		String card = cards.get(cardPos);
		
		for(String suit : suits) {
			add(new Card(card, suit, rank));
		}
		}
		}

	public void shuffle() {
		Random random = new Random();
		
		for (int pos = 0; pos < size(); pos++) {
			int other = random.nextInt(size());
			
			Card posCard = get(pos);
			set (other, get(other));
			set (other, posCard);
		}	
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		sb.append("DECK:").append(System.lineSeparator());
		
		for(int pos = 0; pos < size(); pos++) {
			sb.append("    ").append(get(pos)).append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	
}
