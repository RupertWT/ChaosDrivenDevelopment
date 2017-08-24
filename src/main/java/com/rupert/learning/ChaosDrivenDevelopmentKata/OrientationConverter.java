package com.rupert.learning.ChaosDrivenDevelopmentKata;

import java.util.Dictionary;
import java.util.Hashtable;

public class OrientationConverter {

	public int convertToDegrees (String s) {
		return toDegreeOrientation().get(s);
	}
	
	private static Dictionary<String, Integer> toDegreeOrientation() {
		
		Dictionary<String, Integer> toDegreeDictionary = new Hashtable<String, Integer>();  
		toDegreeDictionary.put("N", 0);
		toDegreeDictionary.put("E", 90);
		toDegreeDictionary.put("S", 180);
		toDegreeDictionary.put("W", 270);
		
	    return toDegreeDictionary;
	  
	}
	
	public String convertToString (int i) {
		return toStringOrientation().get(i);
	}
	
	private static Dictionary<Integer, String> toStringOrientation() {
		
		Dictionary<Integer, String> toStringDictionary = new Hashtable<Integer, String>();  
		toStringDictionary.put(0, "N");
		toStringDictionary.put(90, "E");
		toStringDictionary.put(180, "S");
		toStringDictionary.put(270, "W");
		toStringDictionary.put(360, "N");
		
	    return toStringDictionary;
	  
	}
	
	
	
}
