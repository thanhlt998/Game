package game;

public class Player {
	protected String playerName;
	protected int score;
	protected boolean won;
	
	public Player(String playerName) {
		this.playerName = playerName;
		this.score = 0;
		this.won = false;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addPoint(int noPoint) {
		this.score += noPoint;
		if (this.score == 21) {
			this.won = true;
		}
		else if(this.score > 21) {
			this.score = 0;
		}
	}
	
	public boolean isWon() {
		return won;
	}
}
