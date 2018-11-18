package game;

import java.util.Random;

public class Dice {
	private static final Random RANDOM = new Random();
	private int mostProbabilitySide;
	
	public Dice(int mostProbabilitySide) {
		this.mostProbabilitySide = mostProbabilitySide;
	}
	
	public int roll() {
		double randomValue = RANDOM.nextDouble();
		
		if(randomValue < 0.2) {
			return mostProbabilitySide;
		}
		else if(randomValue < 0.36) {
			return ((mostProbabilitySide + 1) > 6 ? (mostProbabilitySide + 1) % 6 : mostProbabilitySide + 1);
		}
		else if(randomValue < 0.52) {
			return ((mostProbabilitySide + 2) > 6 ? (mostProbabilitySide + 2) % 6 : mostProbabilitySide + 2);
		}
		else if(randomValue < 0.68) {
			return ((mostProbabilitySide + 3) > 6 ? (mostProbabilitySide + 3) % 6 : mostProbabilitySide + 3);
		}
		else if(randomValue < 0.84) {
			return ((mostProbabilitySide + 4) > 6 ? (mostProbabilitySide + 4) % 6 : mostProbabilitySide + 4);
		}
		else {
			return ((mostProbabilitySide + 5) > 6 ? (mostProbabilitySide + 5) % 6 : mostProbabilitySide + 5);
		}
	}
	
}
