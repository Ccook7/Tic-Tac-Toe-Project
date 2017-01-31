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
		String m = game.getButtonMark(0,2);
		assertEquals("X",m);  
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		game.clickButton(0,2);
		game.clickButton(2,0);
		String m = game.getButtonMark(2,0);
		assertEquals("O",m);  
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		game.clickButton(0,2);
		String m = game.getButtonMark(0,2);
		assertEquals("X",m);
		
		game.clickButton(0,2);
		m = game.getButtonMark(0,2);
		assertEquals("X",m);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		game.clickButton(0,2);
		assertEquals("No current winner", game.getResultLabelText());
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		game.clickButton(0,0);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(1,1);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(0,1);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(2,2);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(0,2);
		assertEquals("X", game.getResultLabelText());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		game.clickButton(0,0);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(0,1);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(0,2);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(1,1);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(1,0);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(1,2);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(2,1);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(2,0);
		assertEquals("No current winner", game.getResultLabelText());
		game.clickButton(2,2);
		assertEquals("TIE", game.getResultLabelText());
	}
}