package edu.jsu.mcis;

import javax.swing.*;

import org.junit.*;
import static org.junit.Assert.*;


public class TicTacToeGuiTest {
	private TicTacToeGui game;
	
	@Before
	public final void setUp() {
		game = new TicTacToeGui();
	}
	
	@Test
	public final void testButtonsAreNamedCorrectly(){		
		for(int i = 0; i < 0; i++){
			for(int j = 0; j < 0; j++){
				String s = game.getButtonName(i,j);
				assertEquals("Location" + i + j, s);
			}	
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		game.clickButton(0,2);
		TicTacToe.Mark m = game.getButton(0,2);
		assertEquals(TicTacToe.Mark.X,m);  
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		
		
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		
		
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		
	}
}