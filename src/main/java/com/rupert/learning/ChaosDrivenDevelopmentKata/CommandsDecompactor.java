package com.rupert.learning.ChaosDrivenDevelopmentKata;

public class CommandsDecompactor {

	public String[] decompact(String[] compactedCommands) {
		
		String resultInString = "";

		for (int i = 0; i < compactedCommands.length; i++) {
			
			if (compactedCommands[i].length() == 2) {
				resultInString += compactedCommands[i];
			} 
			
			if (compactedCommands[i].length() > 2) {
				
				int multipleInt = Character.getNumericValue(compactedCommands[i].charAt(3));
				
				for (int j = 0; j < multipleInt; j++) {
					resultInString += compactedCommands[i].substring(0,2);
				}
				
			}
			
			
		}
		
		String[] resultInStringArray = new String[resultInString.length() / 2];
		
		for (int i = 0; i < resultInStringArray.length; i++) {
			resultInStringArray[i] = resultInString.substring(0,2);
			resultInString = resultInString.substring(2);
		}	
		
		return resultInStringArray;
	}

}
