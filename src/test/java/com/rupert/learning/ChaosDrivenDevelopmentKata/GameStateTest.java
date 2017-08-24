package com.rupert.learning.ChaosDrivenDevelopmentKata;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameStateTest {
				
		@Rule
		public ExpectedException thrown= ExpectedException.none();
	
	//--------------------individual commands--------------------
		//no commands
		@Test
		public void noCommandGivesStarting2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(1,1,"N",""));
		}
		
		//drive forward commands
		@Test
		public void driveForwardCommandNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][N]\n[][]", play.doCommand(1,1,"N","DF"));
		}
		
		@Test
		public void driveForwardCommandSouthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][S]", play.doCommand(0,1,"S","DF"));
		}
		
		@Test
		public void driveForwardCommandWestOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[W][]", play.doCommand(1,1,"W","DF"));
		}
		
		@Test
		public void driveForwardCommandEastOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][E]", play.doCommand(1,0,"E","DF"));
		}
		
		//drive backwards commands
		@Test
		public void driveBackwardCommandNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(0,1,"N","DB"));
		}
		
		@Test
		public void driveBackwardCommandSouthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][S]\n[][]", play.doCommand(1,1,"S","DB"));
		}
		
		@Test
		public void driveBackwardCommandWestOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(1,0,"W","DB"));
		}
		
		@Test
		public void driveBackwardCommandEastOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[E][]\n[][]", play.doCommand(0,1,"E","DB"));
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
		
		//illegal moves
		@Test
		public void exceptionDriveBackwardsFromPosition11NorthOrientation2X2Board() {
			GameState play = new GameState();
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The avatar has fallen off the map!");
			play.doCommand(1,1,"N","DB");
		}
		
		@Test
		public void exceptionDriveForwardsFromPosition00NorthOrientation2X2Board() {
			GameState play = new GameState();
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The avatar has fallen off the map!");
			play.doCommand(0,0,"N","DF");
		}
		
		@Test
		public void exceptionDriveForwardFromPosition11EastOrientation2X2Board() {
			GameState play = new GameState();
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The avatar has fallen off the map!");
			play.doCommand(1,1,"E","DF");
		}
		
		@Test
		public void exceptionDriveForwardFromPosition00WestOrientation2X2Board() {
			GameState play = new GameState();
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The avatar has fallen off the map!");
			play.doCommand(0,0,"W","DF");
		}
	
		
		//result showing game state after one command
		@Test
		public void driveForwardOnlyCommandWithFullResult2X2Board() {
			GameState play = new GameState();
			String[] commands = new String[1];
			commands[0] = "DF";
			assertEquals("[][]\n[][N]\n\n[][N]\n[][]", 
					play.playCommands(1,1,"N",commands));
		}
		
		//result showing game state after two command
		@Test
		public void driveForwardThenTurnRightCommandsWithFullResult2X2Board() {
			GameState play = new GameState();
			String[] commands = new String[2];
			commands[0] = "DF"; commands[1] = "TR";
			assertEquals("[][]\n[][N]\n\n[][N]\n[][]\n\n[][E]\n[][]", 
					play.playCommands(1,1,"N",commands));
		}
		
		//result showing game state after Kata01.txt example
		@Test
		public void Kata01Example() {
			GameState play = new GameState();
			String[] commands = new String[5];
			commands[0] = "DF"; commands[1] = "TR"; commands[2] = "DB"; commands[3] = "TL"; commands[4] = "DB";
			assertEquals("[][]\n[][N]\n\n[][N]\n[][]\n\n[][E]\n[][]\n\n[E][]\n[][]\n\n[N][]\n[][]\n\n[][]\n[N][]", 
					play.playCommands(1,1,"N",commands));
		}
		
		//multiple turns to go beyond 360 degrees
		@Test
		public void fiveTurnRights() {
			GameState play = new GameState();
			String[] commands = new String[5];
			commands[0] = "TR"; commands[1] = "TR"; commands[2] = "TR"; commands[3] = "TR"; commands[4] = "TR";
			assertEquals("[][]\n[][N]\n\n[][]\n[][E]\n\n[][]\n[][S]\n\n[][]\n[][W]\n\n[][]\n[][N]\n\n[][]\n[][E]", 
					play.playCommands(1,1,"N",commands));
		}
		
		@Test
		public void tenTurnLefts() {
			GameState play = new GameState();
			String[] commands = new String[10];
			commands[0] = "TL"; commands[1] = "TL"; commands[2] = "TL"; commands[3] = "TL"; commands[4] = "TL";
			commands[5] = "TL"; commands[6] = "TL"; commands[7] = "TL"; commands[8] = "TL"; commands[9] = "TL";
			assertEquals("[][]\n[][N]\n\n[][]\n[][W]\n\n[][]\n[][S]\n\n[][]\n[][E]\n\n[][]\n[][N]\n\n[][]\n[][W]"
					+ "\n\n[][]\n[][S]\n\n[][]\n[][E]\n\n[][]\n[][N]\n\n[][]\n[][W]\n\n[][]\n[][S]", 
					play.playCommands(1,1,"N",commands));
		}
		
}
