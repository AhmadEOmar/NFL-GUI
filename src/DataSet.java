import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSet {
	
	private static ArrayList<Data> games = new ArrayList<>();
	private Data min;
	private Data max;
	private int inData;
	Scanner scan = null;
	
	
	public DataSet(){
	}
	
	public void addData(Data newData){
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
	
	public int getOutside(int floor, int ceiling){
		int counter = 0;
		for(int i = 0; i < games.size(); i++){
			if(games.get(i).getMargin() < floor || games.get(i).getMargin() > ceiling){
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
