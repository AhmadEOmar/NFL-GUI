import java.io.File;
import javax.swing.JFrame;
import java.util.Scanner;
import java.io.FileNotFoundException;



public class NflData {
	
	public static void main(String[] args){
		
		int turnOverMargins;
		String gameInformation;
		
		
		String inputName = "nfl2013gameStatsEd2.txt";
		Scanner scan = null;
		MesurableSet gameStats = new MesurableSet();
		
		
		try
		{
				scan = new Scanner(new File(inputName));
			
				while(scan.hasNext())
				{
					turnOverMargins = scan.nextInt();
					gameInformation = scan.nextLine();
				
					Game addData = new Game(turnOverMargins, gameInformation);
					gameStats.addData(addData);
				}
			
		} catch (FileNotFoundException e) 
		  {
				// TODO Auto-generated catch block
				e.printStackTrace();
		  }
		finally
		{
			
		
		}
			
			JFrame frame = new JFrame("2013 NFL Turnover Differential Analyzer ");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(new NflTurnover(gameStats));
			frame.pack();
			frame.setVisible(true);
			System.out.println(gameStats.toString());
		
	}
}
