package edu.jsu.mcis;
import java.util.Scanner;

public class TicTacToe {
	public enum Mark { EMPTY, X, O };
	public enum Result {OWIN, XWIN, CAT, NONE};
    private Mark[][] board;
    private boolean xTurn;
	private static final Scanner keyboard = new Scanner(System.in);
    
    public TicTacToe() {
        board = new Mark[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
        xTurn = true;
    }
    
    public Mark getMark(int row, int col) {
        return board[row][col];
    }
    
    public void setMark(int row, int col) {
        Mark m = (xTurn)? Mark.X : Mark.O;
        if(board[row][col] == Mark.EMPTY) {
            board[row][col] = m;
            xTurn = !xTurn;
        }
    }
	
	public boolean allSpacesFilled(){
		int counter = 0;
		for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] != Mark.EMPTY) counter++;
			}
		}
		if(counter == 9) return true;
		else return false;
	}

	public Result getResult(){
		int oCounterH = 0;
		int xCounterH = 0;
		int oCounterV = 0;
		int xCounterV = 0;
		for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == Mark.X) xCounterH++;
				else if(board[i][j] == Mark.O) oCounterH++;
				if(oCounterH == 3)return Result.OWIN;
				else if(xCounterH == 3)return Result.XWIN;
			}
			xCounterH = 0;
			oCounterH = 0;
			if(board[i][0] == Mark.X) xCounterV++;
			else if(board[i][0] == Mark.O) oCounterV++;
			if(oCounterV == 3)return Result.OWIN;
			else if(xCounterV == 3)return Result.XWIN;
			if(board[0][0] == Mark.X && board[1][1] == Mark.X && board[2][2] == Mark.X) return Result.XWIN;
			if(board[0][0] == Mark.O && board[1][1] == Mark.O && board[2][2] == Mark.O) return Result.OWIN;
			if(board[0][2] == Mark.X && board[1][1] == Mark.X && board[2][0] == Mark.X) return Result.XWIN;
			if(board[0][2] == Mark.O && board[1][1] == Mark.O && board[2][0] == Mark.O) return Result.OWIN;
		}
		boolean t = allSpacesFilled();
		if(t) return Result.CAT;
		
		return Result.NONE;
		
	}
	

	
	@Override
    public String toString() {
		String s = "";
		for(int i = 0;i < 3; i++){
			for(int j = 0; j < 3; j++){
				Mark m = board[i][j];
				if(m.equals(Mark.EMPTY)) s = s + "-";
				else if(m.equals(Mark.O)) s = s + "O";
				else s = s + "X";
			}
			s = s + "\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		/*TicTacToe model = new TicTacToe();
		TicTacToe.Result r = model.getResult();
		while(r == TicTacToe.Result.NONE){
			int row = 0;
			int col = 0;
			while(col == 0 || row == 0){
				System.out.println(model.toString());
				System.out.println("Enter the row and column to move: ");
				int temp = keyboard.nextInt();
				if(row == 0){
					if(temp >= 0 || temp < 3) row = temp;
					else System.out.println("Please enter a valid number for row");
				}
				else{
					if(temp >= 0 || temp < 3) col = temp;
					else System.out.println("Please enter a valid number for row");
				}
			}
				model.setMark(row,col);
				r = model.getResult();
			
		}
		if(r == TicTacToe.Result.XWIN) System.out.println("X Wins!");
		else if(r == TicTacToe.Result.OWIN) System.out.println("O Wins!");
		else System.out.println("The game is a tie!");
		*/
	}
}
