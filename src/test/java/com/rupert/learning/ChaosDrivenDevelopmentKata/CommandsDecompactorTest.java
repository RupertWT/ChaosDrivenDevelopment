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
	public void oneCompactedCommandWithIntOf1ReturnsOneRegularCommands() {
		CommandsDecompactor decompactor = new CommandsDecompactor();
		String[] testCommands = new String[] {"DF 1"};
		String[] expectedResult = new String[] {"DF"};
		assertArrayEquals(expectedResult, decompactor.decompact(testCommands));
	}
	
	@Test
	public void oneCompactedCommandWithIntOf2ReturnsTwoRegularCommands() {
		CommandsDecompactor decompactor = new CommandsDecompactor();
		String[] testCommands = new String[] {"DF 2"};
		String[] expectedResult = new String[] {"DF","DF"};
		assertArrayEquals(expectedResult, decompactor.decompact(testCommands));
	}
	
	@Test
	public void twoCompactedCommandsWithIntOf3ReturnsSixRegularCommands() {
		CommandsDecompactor decompactor = new CommandsDecompactor();
		String[] testCommands = new String[] {"TL 3","DB 3"};
		String[] expectedResult = new String[] {"TL","TL","TL","DB","DB","DB"};
		assertArrayEquals(expectedResult, decompactor.decompact(testCommands));
	}
	
	@Test
	public void threeMixedCommandsWithDifferentIntsReturnsEightRegularCommands() {
		CommandsDecompactor decompactor = new CommandsDecompactor();
		String[] testCommands = new String[] {"TL 2","TR","DB 4"};
		String[] expectedResult = new String[] {"TL","TL","TR","DB","DB","DB","DB"};
		assertArrayEquals(expectedResult, decompactor.decompact(testCommands));
	}
		
}
