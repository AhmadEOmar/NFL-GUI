import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;



public class NFLStatsMain {
	
	public static void main(String[] args){
		
		int margin;
		String otherInfo;
		
		
		String inputName = "nfl2013gameStatsEd2.txt";
		Scanner scan = null;
		DataSet gameStats = new DataSet();
		
		
		try{
			scan = new Scanner(new File(inputName));
			
			while(scan.hasNext()){
				margin = scan.nextInt();
				otherInfo = scan.nextLine();
				
				Data addData = new Data(margin, otherInfo);
				gameStats.addData(addData);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
			
		
		JFrame frame = new JFrame("2013 NFL TURNOVER DIFFERENTIALS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new TurnoverPanel(gameStats));
		
		
		frame.pack();
		frame.setVisible(true);
		
		System.out.println(gameStats.toString());
		
	}
}
