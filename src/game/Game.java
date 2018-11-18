package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private static final Random RANDOM = new Random();

	private List<Player> playerList;
	private Referee referee;
	private List<Dice> diceList;
	private boolean isEnd;

	private static final Scanner SCANNER = new Scanner(System.in);

	public Game() {
		playerList = new ArrayList<>();
		referee = new Referee();
		diceList = new ArrayList<>();
		isEnd = false;
		
		setPlayerList();
		setDiceList();
	}

	public void setPlayerList() {
		int noPlayer;
		do {
			System.out.print("Nhập vào số người chơi: ");
			noPlayer = Integer.parseInt(SCANNER.nextLine());
		} while (noPlayer >= 4 || noPlayer < 0);

		int i;
		for (i = 0; i < noPlayer; i++) {
			System.out.print("Nhập vào tên người chơi " + i + ": ");
			String playerName = SCANNER.nextLine();
			playerList.add(new Player(playerName));
		}

		for (; i < 4; i++) {
			playerList.add(new VirtualPlayer());
		}
	}

	public void setDiceList() {
		for (int i = 0; i < 4; i++) {
			diceList.add(new Dice(i + 1));
		}
	}

	public void startGame() {
		Player currentPlayer = null;
		int selectedDiceNum;
		while (!isEnd) {
			// Referee point Player
			currentPlayer = playerList.get(referee.getCurrentPlayer());
			System.out.println("Lượt " + currentPlayer.getPlayerName());
			
			// Player select dice
			if(currentPlayer instanceof VirtualPlayer) {
				selectedDiceNum = RANDOM.nextInt(4);
			}
			else {
				do {
					System.out.print("Lựa chọn xúc sắc số: ");
					selectedDiceNum = Integer.parseInt(SCANNER.nextLine());
				} while (selectedDiceNum >= 4 || selectedDiceNum < 0);
			}
			System.out.println(currentPlayer.getPlayerName() + " select Dice " + selectedDiceNum);
			
			// Rollint dice
			System.out.print("Rolling: ");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int noPoint = diceList.get(selectedDiceNum).roll();
			
			System.out.println(noPoint);
			
			// Score after rolling
			referee.addScore(currentPlayer, noPoint);
			System.out.println("Điểm hiện tại: " + currentPlayer.getScore());

			// Check player is won
			if (currentPlayer.isWon()) {
				isEnd = true;
				referee.announceWonPeople(currentPlayer);
			}
			else {
				referee.nextPlayer();
				System.out.println();
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
		
		// express emotion if is Virtual Player
		for (Player player : playerList) {
			if (player instanceof VirtualPlayer && !player.isWon()) {
				System.out.print(player.getPlayerName() + ": ");
				((VirtualPlayer) player).expressEmotion();
			}
		}
		System.out.println("End Game!");
	}
}
