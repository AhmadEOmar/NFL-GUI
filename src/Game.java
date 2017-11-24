public class Game {
	private int turnOverMargin;
	private String gameInformation;
	
	
	public Game(int margin, String info){
		turnOverMargin = margin;
		gameInformation = info;
	}
	
	public int getMargin(){
		return turnOverMargin;
	}
	
	public String getInfo(){
		return gameInformation;
	}
	
	
}

