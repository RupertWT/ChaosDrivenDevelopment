package com.rupert.learning.ChaosDrivenDevelopmentKata;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CommandsDecompactorTest {
		
	@Test
	public void oneCommandReturnsOneCommand() {
		CommandsDecompactor decompactor = new CommandsDecompactor();
		String[] testCommands = new String[] {"DF"};
		String[] expectedResult = new String[] {"DF"};
		assertArrayEquals(expectedResult, decompactor.decompact(testCommands));
	}
		
}
