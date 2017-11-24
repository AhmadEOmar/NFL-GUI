import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class NflTurnover extends JPanel {

	private MesurableSet gameStats;
	//The North,South,East,West,Center Panel
	
	//NorthSide
	private JPanel northTitle;
	//CenterSide
	private JPanel center;
	//WestSide with add,subtract and the floor showing;
	private JPanel west;
	private JPanel leftWestSideAddSub;
	private JPanel leftWestSideFloor;
	//EastSide with add,subtract and the ceiling showing;
	private JPanel east;
	private JPanel eastAddSub;
	private JPanel eastCeiling;
	//SouthSide with the information about turnovers
	private JPanel south;
	private JLabel floorLabel;
	private JLabel centerLabel; 
	private JLabel ceilingLabel;
	
	private JPanel southBelowFloor;
	private JLabel southBelowFloorLabel;
	
	private JPanel southAboveCeiling;
	private JLabel southAboveCeilingLabel;
	
	private JPanel southWorstTurnMargin;
	private JLabel southWorstTurnMarginLabel;
	
	private JPanel southBestTurnMargin;
	private JLabel southBestTurnMarginLabel;
	
	private JPanel southTotGames;
	private JLabel southTotGamesLabel;

	//These are the vairables that are needed to get the important information from the other doc
	private int floor;
	private int ceiling;
	private int gamesBetween;
	private int gamesBelow;
	private int gamesAbove;
	private int minValue;
	private int totGames;
	private int maxValue;
	

	public NflTurnover(MesurableSet stats) {
		//showing what type of gui style I will use
		gameStats = stats;
		setLayout(new BorderLayout());
		
		ceiling = gameStats.getMax();
		floor = gameStats.getMin();
		minValue = gameStats.getMin();
		maxValue = gameStats.getMax();
		totGames = gameStats.getSize();
		gamesBelow = gameStats.getBelow(floor);
		gamesAbove = gameStats.getAbove(ceiling);
		gamesBetween = gameStats.getBetween(floor, ceiling);
		
		makeNorth();
		makeWest();
		makeSouth();
		makeEast();
		makeCenter();

		add(northTitle, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		updateGui();
	}

	private void makeNorth() 
	{
		northTitle = new JPanel();
		northTitle.add(new JLabel("NFL Turnover Differential Analyzer"));
	}
	

	private void makeWest(){
		
		//This creates the whole area that I will be working in named west so that it will be easier for me to remember for future use
		
		west = new JPanel();
		west.setLayout(new GridLayout(1, 2));
		
		//Created 2 variables to seperates the Add button and the Subtract button from the Floor variable where the information will show for the floor
		//Remember that leftWestSide is the Add Button, While the leftWestSide2 is for the Subtract button!!!!!!!!!!!
		leftWestSideAddSub = new JPanel();
		leftWestSideAddSub.setLayout(new GridLayout(1,2));
		
		//This section will create the what the add and subtract button will do to the program, use programming exercise where we practiced
		//ActionListenners to make it work. 
		//Could not figure out how to decrease the size of the Buttons they will be bigger than the floor.
		JButton WestSideAddButton = new JButton("ADD");
		JButton WestSideSubtractButton = new JButton("SUBTRACT");
		ActionListener increaseFloorAmount = new floorIncrease();
		ActionListener decreaseFloorAmount = new floorDecrease();
		WestSideAddButton.addActionListener(increaseFloorAmount);
		WestSideSubtractButton.addActionListener(decreaseFloorAmount);
		leftWestSideAddSub.add(WestSideAddButton);
		leftWestSideAddSub.add(WestSideSubtractButton);
		
		
		//REMEMBER THAT LEFT WEST SIDE FLOOR is for the Floor variable where I put floor and number that goes with it. 
		leftWestSideFloor = new JPanel(); 
		leftWestSideFloor.add(new JLabel("Floor"));
		
		floorLabel = new JLabel(String.valueOf(floor));
		floorLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		
		//This will add all the information to be seen onto the west section of the project.
		leftWestSideFloor.add(floorLabel);
		west.add(leftWestSideAddSub);
		west.add(leftWestSideFloor);
	}
	
	private void makeEast()
	{
		//Setting up how I will use the east side 
		east = new JPanel();
		east.setLayout(new GridLayout(1,2));
		
		//Setting up how I will access the Add, and Subtract button to the East section
		eastAddSub = new JPanel();
		eastAddSub.setLayout(new GridLayout(1,2));
		
		JButton eastSideAddButton = new JButton("ADD");
		JButton eastSideSubtractButton = new JButton("SUBTRACT");
		ActionListener increaseCeiling = new ceilingIncrease();
		ActionListener decreaseCeiling = new ceilingDecrease();
		eastSideAddButton.addActionListener(increaseCeiling);
		eastSideSubtractButton.addActionListener(decreaseCeiling);
		eastAddSub.add(eastSideAddButton);
		eastAddSub.add(eastSideSubtractButton);
		
		//Getting the information for the ceiling information
		eastCeiling = new JPanel();
		eastCeiling.add(new JLabel("Ceiling"));
		ceilingLabel = new JLabel(String.valueOf(ceiling));
		ceilingLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		//Adds them to be seen on the East section
		eastCeiling.add(ceilingLabel);
		east.add(eastCeiling);
		east.add(eastAddSub);
		
	}
	
	private void makeCenter()
	{
		//Once again this is creating the space in which I will use the center to fit my needs
		center = new JPanel();
		center.add(new JLabel(String.valueOf("Number Of Games Between")));
		centerLabel = new JLabel(String.valueOf(gamesBetween));
		centerLabel.setFont(new Font("Serif", Font.BOLD, 18));
		center.add(centerLabel);
		
	}
	
	private void makeSouth()
	{
		
		//The South section is where I decided to add all my information to see how it changes when pressing the Add or Subtract button
		//Creating the south section I make all the information show up in a single line making it easier to read and watch how it changes
		south = new JPanel();
		south.setLayout(new GridLayout(5, 1));
		
		
		//This gets the information need for the games that were above the ceiling from turnovers 
		//Creates the information in a single line could not figure out how to make it look better
		southAboveCeiling = new JPanel();
		southAboveCeiling.add(new JLabel("Games Above Ceiling"));
		southAboveCeilingLabel = new JLabel(String.valueOf(gamesAbove));
		southAboveCeilingLabel.setFont(new Font("Serif", Font.BOLD, 18));
		southAboveCeiling.add(southAboveCeilingLabel);
		
		//Same as above gets the information for the below ceiling from the nfl document
		//nothing different runs the same way
		southBelowFloor = new JPanel();
		southBelowFloor.add(new JLabel("Games Below Floor"));
		southBelowFloorLabel = new JLabel(String.valueOf(gamesBelow));
		southBelowFloorLabel.setFont(new Font("Serif", Font.BOLD, 18));
		southBelowFloor.add(southBelowFloorLabel);
		
		//Same as above gets the information for the team that had the worst turnovers in the nfl document
		//nothing different runs the same way
		southWorstTurnMargin = new JPanel();
		southWorstTurnMargin.add(new JLabel("Worst Turnover Margin"));
		southWorstTurnMarginLabel = new JLabel(String.valueOf(minValue));
		southWorstTurnMarginLabel.setFont(new Font("Serif", Font.BOLD, 18));
		southWorstTurnMargin.add(southWorstTurnMarginLabel);
		
		//Same as above gets the information for the team that had the best turnover rate in the nfl document
		//nothing different runs the same way
		southBestTurnMargin = new JPanel();
		southBestTurnMargin.add(new JLabel("Best Turnover Margin"));
		southBestTurnMarginLabel = new JLabel(String.valueOf(maxValue));
		southBestTurnMarginLabel.setFont(new Font("Serif", Font.BOLD, 18));
		southBestTurnMargin.add(southBestTurnMarginLabel);
		
		//Same as above gets the information for the total amount of games that were played in the 2013 nfl season
		//nothing different runs the same way
		southTotGames = new JPanel();
		southTotGames.add(new JLabel("Total Number of Games"));
		southTotGamesLabel= new JLabel(String.valueOf(totGames));
		southTotGamesLabel.setFont(new Font("Serif", Font.BOLD, 18));
		southTotGames.add(southTotGamesLabel);
		
		//adds them all to the south section of the gui
		south.add(southBelowFloor);
		south.add(southAboveCeiling);
		south.add(southWorstTurnMargin);
		south.add(southBestTurnMargin);
		south.add(southTotGames);
	}
	
	//how the action listener will act when the ceilingIncrease which is the Add button will increase in the game
	private class ceilingIncrease implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			if(ceiling < gameStats.getMax()){
				ceiling++;
			}
			updateGui();
		}
	}
	
	//how the action listener will act when the ceilingDecrease which is the Subtract button will decrease in the game
	private class ceilingDecrease implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			if(ceiling > gameStats.getMin()){
				ceiling--;
			}
			updateGui();
		}
	}
	//how the action listener will act when the floorIncrease which is the Add button will increase in the game
	private class floorIncrease implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			if(floor < gameStats.getMax()){
				floor++;
			}
			updateGui();
		}
	}
	//how the action listener will act when the floorDecrease which is the Subtract button will increase in the game
	private class floorDecrease implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			if(floor > gameStats.getMin()){
				floor--;
			}
			updateGui();
		}
	}
	
	//This is where the the gui will do when it see the updateGui update that happens at each end of the functions for each segment.
	private void updateGui(){
		centerLabel.setText(String.valueOf(gamesBetween));
		floorLabel.setText(String.valueOf(floor));
		ceilingLabel.setText(String.valueOf(ceiling));
		gamesBetween = gameStats.getBetween(floor, ceiling);
		gamesBelow = gameStats.getBelow(floor);
		gamesAbove = gameStats.getAbove(ceiling);
		southBelowFloorLabel.setText(String.valueOf(gamesBelow));
		southAboveCeilingLabel.setText(String.valueOf(gamesAbove));
	}

}