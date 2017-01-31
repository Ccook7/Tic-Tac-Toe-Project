package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGui extends JFrame implements ActionListener {
	
	private JTextField myTitle;
	private TicTacToe game;
	private JButton[][] grid;
	private JLabel resultLabel;
	
	public TicTacToeGui() {
		myTitle = new JTextField("Tic Tac Toe");  
		myTitle.setBounds(80, 40, 225, 20);
		add(myTitle);
		this.setTitle(myTitle.getText());
		game = new TicTacToe();
		grid = new JButton[3][3];
		
		setLayout(new BorderLayout());
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				grid[i][j] =  new JButton();
				grid[i][j].setName("Location" + i + j );
				grid[i][j].addActionListener(this);
				gamePanel.add(grid[i][j]);
			}
		}
		add(gamePanel, BorderLayout.CENTER);
		
		resultLabel = new JLabel("Results: ");
		resultLabel.setName("ResultLabel");
		add(resultLabel, BorderLayout.SOUTH);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		JButton temp = (JButton) event.getSource();
		String cord = temp.getName();
		
		int row = Character.getNumericValue(cord.charAt(cord.length() - 2));
		int col = Character.getNumericValue(cord.charAt(cord.length() - 1));
		
		game.setMark(row,col);
		TicTacToe.Mark m = game.getMark(row,col);
		
		if(m.equals(TicTacToe.Mark.X)){
			grid[row][col].setText("X");
		}
		else if(m.equals(TicTacToe.Mark.O)){
			grid[row][col].setText("O");
		}
		TicTacToe.Result r = game.getResult();
		
		
		if(r.equals(TicTacToe.Result.XWIN)) {
			resultLabel.setText("X");
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					grid[i][j].setEnabled(false);
				
				}
			}
		}
		else if(r.equals(TicTacToe.Result.OWIN)) {
			resultLabel.setText("O");
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					grid[i][j].setEnabled(false);
				
				}
			}
		}
		else if(r.equals(TicTacToe.Result.CAT)) {
			resultLabel.setText("TIE");
		}
		else resultLabel.setText("No current winner");
		grid[row][col].setEnabled(false);
		
		
	}
	
	
	
	
	
	public void clickButton(int row, int col) {grid[row][col].doClick(); }
	public String getButtonMark(int row, int col) { return grid[row][col].getText(); }
	public String getButtonName(int row, int col) { return grid[row][col].getName(); }
	public String getResultLabelText() { return resultLabel.getText(); }
	
	


public static void main(String[] args) {
        TicTacToeGui game = new TicTacToeGui();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(400,300);
        game.setVisible(true);
    }
	
}