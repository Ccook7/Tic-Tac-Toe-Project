package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
		
	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToe model = new TicTacToe();
		for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                TicTacToe.Mark m = model.getMark(row, col);
                assertEquals(TicTacToe.Mark.EMPTY, m);
            }
        }
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe model = new TicTacToe();
        model.setMark(0, 2);
        TicTacToe.Mark m = model.getMark(0, 2);
        assertEquals(TicTacToe.Mark.X, m);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe model = new TicTacToe();
		model.setMark(1,1);
		model.setMark(2,0);
		TicTacToe.Mark m = model.getMark(2,0);
		assertEquals(TicTacToe.Mark.O,m);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToe model = new TicTacToe();
		model.setMark(1,1);
		TicTacToe.Mark m = model.getMark(1,1);
		assertEquals(TicTacToe.Mark.X,m);
		model.setMark(1,1);
		m = model.getMark(1,1);
		assertEquals(TicTacToe.Mark.X,m);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToe model= new TicTacToe();
		model.setMark(1,1);
		TicTacToe.Result r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe model = new TicTacToe();
		model.setMark(0,0);
		TicTacToe.Result r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(1,1);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(0,1);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(2,2);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(0,2);
		r = model.getResult();
		assertEquals(TicTacToe.Result.XWIN,r);
		
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe model = new TicTacToe();
		model.setMark(0,0);
		TicTacToe.Result r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(0,1);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(0,2);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(1,1);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(1,0);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(1,2);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(2,1);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(2,0);
		r = model.getResult();
		assertEquals(TicTacToe.Result.NONE,r);
		model.setMark(2,2);
		r = model.getResult();
		assertEquals(TicTacToe.Result.CAT,r);
	}
}
