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
		
		//individual commands
		//drive forward commands
		@Test
		public void driveForwardCommandNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][N]\n[][]", play.doCommand(1,1,"N","DF"));
		}
		
		@Test
		public void driveForwardCommandWestOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[W][]", play.doCommand(1,1,"W","DF"));
		}
		
		//individual commands
		//drive backwards commands
		@Test
		public void driveBackwardCommandNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(0,1,"N","DB"));
		}
			
		//individual commands
		//turn right commands
		@Test
		public void turnRightCommandFromNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][E]", play.doCommand(1,1,"N","TR"));
		}
		
		@Test
		public void turnRightCommandFromSouthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(1,1,"S","TR"));
		}
		
		//individual commands
		//turn left commands
		@Test
		public void turnLeftCommandFromNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(1,1,"N","TL"));
		}
		
		@Test
		public void turnLeftCommandFromEastOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(1,1,"E","TL"));
		}		
				
		//result showing game state after each command
		@Test
		public void driveForwardOnlyCommandWithFullResult2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]\n\n[][N]\n[][]", play.playCommands(1,1,"N","DF"));
		}
		
}
