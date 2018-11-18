package game;

import java.util.Random;

public class Referee {
	private int currentPlayer;
	
	public Referee() {
		currentPlayer = new Random().nextInt(4);
	}
	
	public void addScore(Player player, int noPoint) {
		player.addPoint(noPoint);
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void nextPlayer() {
		this.currentPlayer = (this.currentPlayer + 1) % 4;
	}
	
	public void announceWonPeople(Player player) {
		System.out.println("Người thắng cuộc là " + player.getPlayerName());
	}
}
