package com.rupert.learning.ChaosDrivenDevelopmentKata;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CommandsDecompactorTest {
		
	@Test
	public void oneRegularCommandReturnsOneRegularCommand() {
		CommandsDecompactor decompactor = new CommandsDecompactor();
		String[] testCommands = new String[] {"DF"};
		String[] expectedResult = new String[] {"DF"};
		assertArrayEquals(expectedResult, decompactor.decompact(testCommands));
	}
	
	@Test
	public void twoRegularCommandsReturnsTwoRegularCommands() {
		CommandsDecompactor decompactor = new CommandsDecompactor();
		String[] testCommands = new String[] {"DF","TL"};
		String[] expectedResult = new String[] {"DF","TL"};
		assertArrayEquals(expectedResult, decompactor.decompact(testCommands));
	}
	
	@Test
	public void oneCompactedCommandWithIntOf1ReturnsTwoRegularCommands() {
		CommandsDecompactor decompactor = new CommandsDecompactor();
		String[] testCommands = new String[] {"DF 1"};
		String[] expectedResult = new String[] {"DF"};
		assertArrayEquals(expectedResult, decompactor.decompact(testCommands));
	}
		
}
