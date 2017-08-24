package com.rupert.learning.ChaosDrivenDevelopmentKata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameStateTest {
		
	
		//individual commands
		@Test
		public void noCommandGivesStarting2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(1,1,"N",""));
		}
		
		//drive commands
		@Test
		public void driveForwardCommandNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][N]\n[][]", play.doCommand(1,1,"N","DF"));
		}
		
		@Test
		public void driveBackwardCommandNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(0,1,"N","DB"));
		}
		
		//turn commands
		@Test
		public void turnRightCommandFromNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][E]", play.doCommand(1,1,"N","TR"));
		}
		
		@Test
		public void turnLeftCommandFromNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(1,1,"N","TL"));
		}
		
		
		//result showing game state after each command
		@Test
		public void driveForwardOnlyCommandWithFullResult2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]\n\n[][N]\n[][]", play.playCommands(1,1,"N","DF"));
		}
		
}
