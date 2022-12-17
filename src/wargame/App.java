package wargame;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
	
	private List<String>players = List.of("Jake", "John", "Gab", "Sam" );
	
	private Random random = new Random();
	
	public static void main(String[] args) {
		new App().run();
	}
	private void run() {
		List<String> names = new LinkedList<>(players);
		Player player1 = selectPlayer(names);
		Player player2 = selectPlayer(names);
		
		System.out.println(player1 + " is playing " + player2);
		
		Deck deck = new Deck();
		deck.shuffle();
		
		deal(deck,player1, player2);
		play(player1, player2);
		
		declareWinner(player1,player2);
	}
	private void declareWinner(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			printWinner(player1);
			printLoser(player2);
		}
		else if(player2.getScore() > player1.getScore()) {
			printWinner(player2);
			printLoser(player1);
		}
		else {
			printTie(player1,player2);
		}
	}
	private void printTie(Player player1, Player player2) {
		System.out.println(player1 + " and " + player2 + "tied with a score of " +
	player1.getScore());
		
	}
	private void printLoser(Player loser) {
		System.out.println(loser + " is the loser. Score: " + loser.getScore());
	}
	private void printWinner(Player winner) {
		System.out.println(winner + " is the winner! Score: " + winner.getScore() + "!");
		
	}
	private void play(Player player1, Player player2) {
		int numTurns = player1.getHand().size();
		
		for (int turn = 0; turn < numTurns; turn++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();
			
			if (card1.getRank()> card2.getRank()) {
				player1.incrementScore();
			}
			else if (card2.getRank() > card1.getRank()){
				player2.incrementScore();
			}
		}
		
	}
	private void deal(Deck deck, Player player1, Player player2) {
		int size = deck.size();
		
		for (int i = 0; i < size; i++) {
			if(i % 2 == 0) {
				player1.draw(deck);
			}
			else {
				player2.draw(deck);
			}
		}
	}
	private Player selectPlayer(List<String> names) {
		int pos = random.nextInt(names.size());
		String name = names.remove(pos);
		return new Player(name);
	}
}
