package game;

public class VirtualPlayer extends Player {
	private static final String[] losenEmotionList = {"Fuck!!!", "Shit!!!", "Lol!!!", "Damn it!!!"};
	private static int noVirtualPlayer = 0;
	String losenEmotion;

	public VirtualPlayer() {
		super("VirtualPlayer" + noVirtualPlayer);
		this.losenEmotion = losenEmotionList[noVirtualPlayer];
		noVirtualPlayer++;
	}

	public String getLosenEmotion() {
		return losenEmotion;
	}

	public void setLosenEmotion(String losenEmotion) {
		this.losenEmotion = losenEmotion;
	}
	
	public void expressEmotion() {
		System.out.println(this.losenEmotion);
	}
}
