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
			assertEquals("[][]\n[][N]", play.doCommand(1,1,"N","",2));
		}
		
		@Test
		public void noCommandGivesStarting3X3Board() {
			GameState play = new GameState();
			assertEquals("[][][]\n[][][]\n[][][N]", play.doCommand(2,2,"N","",3));
		}
		
		//drive forward commands
		@Test
		public void driveForwardCommandNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][N]\n[][]", play.doCommand(1,1,"N","DF",2));
		}
		
		@Test
		public void driveForwardCommandSouthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][S]", play.doCommand(0,1,"S","DF",2));
		}
		
		@Test
		public void driveForwardCommandWestOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[W][]", play.doCommand(1,1,"W","DF",2));
		}
		
		@Test
		public void driveForwardCommandEastOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][E]", play.doCommand(1,0,"E","DF",2));
		}
		
		//drive backwards commands
		@Test
		public void driveBackwardCommandNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(0,1,"N","DB",2));
		}
		
		@Test
		public void driveBackwardCommandSouthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][S]\n[][]", play.doCommand(1,1,"S","DB",2));
		}
		
		@Test
		public void driveBackwardCommandWestOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(1,0,"W","DB",2));
		}
		
		@Test
		public void driveBackwardCommandEastOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[E][]\n[][]", play.doCommand(0,1,"E","DB",2));
		}
					
		//turn right commands
		@Test
		public void turnRightCommandFromNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][E]", play.doCommand(1,1,"N","TR",2));
		}
		
		@Test
		public void turnRightCommandFromSouthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(1,1,"S","TR",2));
		}
		
		//turn left commands
		@Test
		public void turnLeftCommandFromNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(1,1,"N","TL",2));
		}
		
		@Test
		public void turnLeftCommandFromEastOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(1,1,"E","TL",2));
		}		
		
		//u turn commands
		@Test
		public void uTurnCommandFromNorthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][S]", play.doCommand(1,1,"N","UT",2));
		}
		
		@Test
		public void uTurnCommandFromSouthOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][N]", play.doCommand(1,1,"S","UT",2));
		}
		
		@Test
		public void uTurnCommandFromWestOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][E]", play.doCommand(1,1,"W","UT",2));
		}
		
		@Test
		public void uTurnCommandFromEastOrientation2X2Board() {
			GameState play = new GameState();
			assertEquals("[][]\n[][W]", play.doCommand(1,1,"E","UT",2));
		}
		
	//--------------------multiple commands--------------------		
		//result showing game state after one command
		@Test
		public void driveForwardOnlyCommandWithFullResult2X2Board() {
		GameState play = new GameState();
		String[] testCommands = new String[] {"DF"};
		assertEquals("[][]\n[][N]\n\n[][N]\n[][]", 
					play.playCommands(1,1,"N",testCommands,2));
		}
			
		//result showing game state after two command
		@Test
		public void driveForwardThenTurnRightCommandsWithFullResult2X2Board() {
			GameState play = new GameState();
			String[] testCommands = new String[] {"DF","TR"};
			assertEquals("[][]\n[][N]\n\n[][N]\n[][]\n\n[][E]\n[][]", 
					play.playCommands(1,1,"N",testCommands,2));
		}
		
		//result showing game state after Kata01.txt example
		@Test
		public void Kata01Example() {
			GameState play = new GameState();
			String[] testCommands = new String[] {"DF","TR","DB","TL","DB"};
			assertEquals("[][]\n[][N]\n\n[][N]\n[][]\n\n[][E]\n[][]\n\n[E][]\n[][]\n\n[N][]\n[][]\n\n[][]\n[N][]", 
					play.playCommands(1,1,"N",testCommands,2));
		}
		
		//multiple turns to go beyond 360 degrees
		@Test
		public void fiveTurnRights() {
			GameState play = new GameState();
			String[] testCommands = new String[] {"TR","TR","TR","TR","TR"};
			assertEquals("[][]\n[][N]\n\n[][]\n[][E]\n\n[][]\n[][S]\n\n[][]\n[][W]\n\n[][]\n[][N]\n\n[][]\n[][E]", 
					play.playCommands(1,1,"N",testCommands,2));
		}
		
		@Test
		public void tenTurnLefts() {
			GameState play = new GameState();
			String[] testCommands = new String[] {"TL","TL","TL","TL","TL","TL","TL","TL","TL","TL"};
			assertEquals("[][]\n[][N]\n\n[][]\n[][W]\n\n[][]\n[][S]\n\n[][]\n[][E]\n\n[][]\n[][N]\n\n[][]\n[][W]"
					+ "\n\n[][]\n[][S]\n\n[][]\n[][E]\n\n[][]\n[][N]\n\n[][]\n[][W]\n\n[][]\n[][S]", 
					play.playCommands(1,1,"N",testCommands,2));
		}
		
	//--------------------exceptions--------------------
		//drive off board
		@Test
		public void exceptionDriveBackwardsFromPosition11NorthOrientation2X2Board() {
			GameState play = new GameState();
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The avatar has fallen off the map!");
			play.doCommand(1,1,"N","DB",2);
		}
		
		@Test
		public void exceptionDriveForwardsFromPosition00NorthOrientation2X2Board() {
			GameState play = new GameState();
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The avatar has fallen off the map!");
			play.doCommand(0,0,"N","DF",2);
		}
		
		@Test
		public void exceptionDriveForwardFromPosition11EastOrientation2X2Board() {
			GameState play = new GameState();
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The avatar has fallen off the map!");
			play.doCommand(1,1,"E","DF",2);
		}
		
		@Test
		public void exceptionDriveForwardFromPosition00WestOrientation2X2Board() {
			GameState play = new GameState();
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The avatar has fallen off the map!");
			play.doCommand(0,0,"W","DF",2);
		}
	
		//TODO
		//invalid - in command variable
		//invalid - start out of bounds
		//invalid - grid size 0
		//invalid 
		
		
		
		
}
