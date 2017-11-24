public class Data {
	private int tOverMargin;
	private String gameInfo;
	
	
	public Data(int margin, String info){
		tOverMargin = margin;
		gameInfo = info;
	}
	
	public int getMargin(){
		return tOverMargin;
	}
	
	public String getInfo(){
		return gameInfo;
	}
	
	
}

