package edu.jsu.mcis;

import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGui extends JPanel implements ActionListener {
	
	private TicTacToe game;
	private JButton[][] grid;
	private JOptionPane gameover;
	private JLabel resultLabel;
	
	public TicTacToeGui() {
		game = new TicTacToe();
		gameover = new JOptionPane();
		grid = new JButton[3][3];
		for(int i = 0; i < 0; i++){
			for(int j = 0; j < 0; j++){
				grid[i][j] =  new JButton();
				grid[i][j].setName("Location" + i + j );
				add(grid[i][j]);
			}
		}
		resultLabel = new JLabel(0
		resultLabel.setName("ResultLabel");
		add(resultLabel);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		String cord = event.getActionCommand();
		int row = (cord.charAt(cord.length()-1)- '0');
		int col = (cord.charAt(cord.length()-2) - '0');
		game.setMark(row,col);
		TicTacToe.Mark m = game.getMark(row,col);
		if(m == TicTacToe.Mark.X){
			grid[row][col].setText("X");
		}
		else if(m == TicTacToe.Mark.O){
			grid[row][col].setText("O");
		}
		TicTacToe.Result r = game.getResult();
		
		
		if(r.equals(TicTacToe.Result.XWIN)) {
			resultLabel.setText("X WINS!");
		}
		grid[row][col].setEnabled(false);
	}
	
	
	
	
	
	public void clickButton(int row, int col) {grid[row][col].doClick(); }
	public TicTacToe.Mark getButton(int row, int col) { return game.getMark(row,col); }
	public String getButtonName(int row, int col) { return grid[row][col].getName(); }
	
	

}