package com.rupert.learning.ChaosDrivenDevelopmentKata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameStateTest {
		
	
		//individual commands
		@Test
		public void noCommandGivesStartingBoard() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(2,1,1,"N",""));
		}
		
		//drive commands
		@Test
		public void driveForwardCommandNorthOrientation() {
			GameState play = new GameState();
			assertEquals("[][N]\n[][]", play.doCommand(2,1,1,"N","DF"));
		}
		
		@Test
		public void driveBackwardCommandNorthOrientation() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(2,0,1,"N","DB"));
		}
		
		//turn commands
		@Test
		public void turnRightCommandFromNorthOrientation() {
			GameState play = new GameState();
			assertEquals("[][]\n[][E]", play.doCommand(2,1,1,"N","TR"));
		}
		
		@Test
		public void turnLeftCommandFromNorthOrientation() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(2,1,1,"N","TL"));
		}
		
		
		//result showing game state after each command
		@Test
		public void driveForwardOnlyCommandWithFullResult() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]\n\n[][N]\n[][]", play.playCommands(2,1,1,"N","DF"));
		}
		
}
