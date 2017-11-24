import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class TurnoverPanel extends JPanel {

	private DataSet gameStats;
	private JPanel title, middle, left, leftLeft, leftRight;
	private JPanel right, rightRight, rightLeft, bottom;
	private JPanel bottomLeftUp, bottomMidUp, bottomRightUp;
	private JPanel bottomLeftDown, bottomMidDown, bottomRightDown;
	private JLabel floorLabel, midLabel, ceilingLabel, titleLabel;
	private JLabel bLULabel, bMULabel, bRULabel;
	private JLabel bLDLabel, bMDLabel, bRDLabel;
	private int floor, ceiling, gamesBetween;
	private int gamesBelow, gamesAbove, gamesOutside;
	private int minValue, totGames, maxValue;
	

	public TurnoverPanel(DataSet stats) {
		gameStats = stats;
		setLayout(new BorderLayout());
		
		floor = gameStats.getMin();
		ceiling = gameStats.getMax();
		minValue = gameStats.getMin();
		maxValue = gameStats.getMax();
		totGames = gameStats.getSize();
		gamesBelow = gameStats.getBelow(floor);
		gamesAbove = gameStats.getAbove(ceiling);
		gamesBetween = gameStats.getBetween(floor, ceiling);
		gamesOutside = gameStats.getOutside(floor, ceiling);
		
		setSize(400, 400);
		makeNorth();
		makeWest();
		makeSouth();
		makeEast();
		makeCenter();

		add(title, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(middle, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		
		updateGui();
	}

	private void makeNorth() {
		title = new JPanel();
		title.setBorder(BorderFactory.createRaisedBevelBorder());
		title.setBackground(Color.LIGHT_GRAY);
		titleLabel = new JLabel("NFL TURNOVER MARGIN CALCULATOR");
		titleLabel.setFont(new Font("helvitica", Font.BOLD, 60));
		title.add(titleLabel);
	}
	/*
	private void makeCenter(){
		middle = new JPanel();
		
			
	}
	*/
	private void makeWest(){
		left = new JPanel();
		left.setLayout(new GridLayout(1, 2));
		
		leftLeft = new JPanel();
		leftLeft.setLayout(new GridLayout(2,1));
		
		
		JButton lAddButton = new JButton("+");
		JButton lMinusButton = new JButton("-");
		ActionListener incFloor = new floorInc();
		ActionListener decFloor = new floorDec();
		lAddButton.addActionListener(incFloor);
		lMinusButton.addActionListener(decFloor);
		leftLeft.add(lAddButton);
		leftLeft.add(lMinusButton);
		
		leftRight = new JPanel();
		
		leftRight.setBorder(BorderFactory.createTitledBorder("Floor"));
		floorLabel = new JLabel(String.valueOf(floor));
		floorLabel.setFont(new Font("Serif", Font.BOLD, 40));
		leftRight.add(floorLabel);
		
		left.add(leftLeft);
		left.add(leftRight);
	}
	
	private void makeEast(){
		right = new JPanel();
		right.setLayout(new GridLayout(1,2));
		
		rightRight = new JPanel();
		rightRight.setLayout(new GridLayout(2,1));
		
		JButton rAddButton = new JButton("+");
		JButton rMinusButton = new JButton("-");
		ActionListener incCeiling = new ceilingInc();
		ActionListener decCeiling = new ceilingDec();
		rAddButton.addActionListener(incCeiling);
		rMinusButton.addActionListener(decCeiling);
		rightRight.add(rAddButton);
		rightRight.add(rMinusButton);
		
		rightLeft = new JPanel();
		
		rightLeft.setBorder(BorderFactory.createTitledBorder("Ceiling"));
		ceilingLabel = new JLabel(String.valueOf(ceiling));
		ceilingLabel.setFont(new Font("Serif", Font.BOLD, 40));
		rightLeft.add(ceilingLabel);
		
		right.add(rightLeft);
		right.add(rightRight);
		
	}
	
	private void makeCenter(){
		middle = new JPanel();
		TitledBorder centerBorder = BorderFactory.createTitledBorder("Number Of Games Between");
		centerBorder.setTitleJustification(TitledBorder.CENTER);
		middle.setBorder(centerBorder);
		midLabel = new JLabel(String.valueOf(gamesBetween));
		midLabel.setFont(new Font("Serif", Font.BOLD, 60));
		middle.add(midLabel);
		
	}
	
	private void makeSouth(){
		bottom = new JPanel();
		bottom.setLayout(new GridLayout(2, 3));
		
		bottomLeftUp = new JPanel();
		bottomLeftUp.setBorder(BorderFactory.createTitledBorder("Games Below Floor"));
		bLULabel = new JLabel(String.valueOf(gamesBelow));
		bLULabel.setFont(new Font("Serif", Font.BOLD, 20));
		bottomLeftUp.add(bLULabel);
		
		bottomMidUp = new JPanel();
		bottomMidUp.setBorder(BorderFactory.createTitledBorder("Games Outside Given Range"));
		bMULabel = new JLabel(String.valueOf(gamesOutside));
		bMULabel.setFont(new Font("Serif", Font.BOLD, 20));
		bottomMidUp.add(bMULabel);
		
		bottomRightUp = new JPanel();
		bottomRightUp.setBorder(BorderFactory.createTitledBorder("Games Above Ceiling"));
		bRULabel = new JLabel(String.valueOf(gamesAbove));
		bRULabel.setFont(new Font("Serif", Font.BOLD, 20));
		bottomRightUp.add(bRULabel);
		
		bottomLeftDown = new JPanel();
		bottomLeftDown.setBorder(BorderFactory.createTitledBorder("Worst Turnover Margin"));
		bLDLabel = new JLabel(String.valueOf(minValue));
		bLDLabel.setFont(new Font("Serif", Font.BOLD, 20));
		bottomLeftDown.add(bLDLabel);
		
		bottomMidDown = new JPanel();
		bottomMidDown.setBorder(BorderFactory.createTitledBorder("Total Number of Games"));
		bMDLabel = new JLabel(String.valueOf(totGames));
		bMDLabel.setFont(new Font("Serif", Font.BOLD, 20));
		bottomMidDown.add(bMDLabel);
		
		bottomRightDown = new JPanel();
		bottomRightDown.setBorder(BorderFactory.createTitledBorder("Best Turnover Margin"));
		bRDLabel = new JLabel(String.valueOf(maxValue));
		bRDLabel.setFont(new Font("Serif", Font.BOLD, 20));
		bottomRightDown.add(bRDLabel);
		
		bottom.add(bottomLeftUp);
		bottom.add(bottomMidUp);
		bottom.add(bottomRightUp);
		bottom.add(bottomLeftDown);
		bottom.add(bottomMidDown);
		bottom.add(bottomRightDown);
	}
	
	private class floorInc implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(floor < gameStats.getMax()){
				floor++;
			}
			updateGui();
		}
	}
	
	private class floorDec implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(floor > gameStats.getMin()){
				floor--;
			}
			updateGui();
		}
	}
	
	private class ceilingInc implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(ceiling < gameStats.getMax()){
				ceiling++;
			}
			updateGui();
		}
	}
	
	private class ceilingDec implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(ceiling > gameStats.getMin()){
				ceiling--;
			}
			updateGui();
		}
	}
	private void updateGui(){
		floorLabel.setText(String.valueOf(floor));
		ceilingLabel.setText(String.valueOf(ceiling));
		gamesBetween = gameStats.getBetween(floor, ceiling);
		gamesBelow = gameStats.getBelow(floor);
		gamesOutside = gameStats.getOutside(floor, ceiling);
		gamesAbove = gameStats.getAbove(ceiling);
		midLabel.setText(String.valueOf(gamesBetween));
		bLULabel.setText(String.valueOf(gamesBelow));
		bMULabel.setText(String.valueOf(gamesOutside));
		bRULabel.setText(String.valueOf(gamesAbove));
	}

}