package com.rupert.learning.ChaosDrivenDevelopmentKata;

public class CommandsDecompactor {

	public String[] decompact(String[] compactedCommands) {
		
		String[] result = new String[compactedCommands.length];
		
		for (int i = 0; i < compactedCommands.length; i++) {
			
			if (compactedCommands[i].length() == 2) {
				result[i] = compactedCommands[i];
			} 
			
//			if (compactedCommands[i].length() > 2) {
//				
//				int number = Character.getNumericValue(compactedCommands[i].charAt(3));
//				
//				System.out.println(number);
//				
//				for (int j = 0; j < number; i++) {
//					
//					result[i+j] = compactedCommands[i].substring(0, 2);;
//					
//				}
//			
//			}
		
		}
		
		return result;
	}

}
