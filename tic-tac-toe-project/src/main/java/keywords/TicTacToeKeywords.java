import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe model;
	
	public void startNewGame() {
		model = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		model.setMark(row,col);
	}
	
	public String getMark(int row, int col) {
		TicTacToe.Mark r = model.getMark(row,col);
		if(r == TicTacToe.Mark.X) return "X";
		else if(r == TicTacToe.Mark.O) return "O";
		else return "";
	}
    
	public String getWinner() {
		TicTacToe.Result r = model.getResult();
		if(r == TicTacToe.Result.XWIN) return "X";
		else if(r == TicTacToe.Result.OWIN) return "O";
		else if(r == TicTacToe.Result.CAT) return "TIE";
		else return " ";
	}
}
