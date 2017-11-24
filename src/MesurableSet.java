import java.util.ArrayList;
import java.util.Scanner;

//Reused the measurable set from our previous labs;
public class MesurableSet {
	
	private static ArrayList<Game> games = new ArrayList<>();
	private Game min;
	private Game max;
	Scanner scan = null;
	
	
	public MesurableSet(){
	}
	
	public void addData(Game newData){
		games.add(newData);
		if(games.size() == 1){
			min = newData;
			max = newData;
		}
		
		if(newData.getMargin() < min.getMargin()){
			min = newData;
		}
		
		if(newData.getMargin() > max.getMargin()){
			max = newData;
		}
	}
	
	public int getBelow(int floor){
		int counter = 0;
		for(int i = 0; i < games.size(); i++){
			if(games.get(i).getMargin() < floor){
				counter++;
			}
		}
		return counter;
	}
	
	public int getAbove(int ceiling){
		int counter = 0;
		for(int i = 0; i < games.size(); i++){
			if(games.get(i).getMargin() > ceiling){
				counter++;
			}
		}
		return counter;
	}
	
	public int getBetween(int floor, int ceiling){
		int counter = 0;
		for(int i = 0; i < games.size(); i++){
			if(games.get(i).getMargin() >= floor && games.get(i).getMargin() <= ceiling){
				counter++;
			}
		}
		return counter;
	}
	
	
	public int getSize(){
		return games.size();
	}
	
	public String toString(){
		String results = "";
		for(int i = 0; i < games.size(); i++){
			results += games.get(i).getMargin() + "      ";
			results += games.get(i).getInfo() + "\n";
			
		}
		return results;
	}
	
	public int getMin(){
		return min.getMargin();
	}
	
	public int getMax(){
		return max.getMargin();
	}
		
}
