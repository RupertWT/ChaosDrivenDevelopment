package com.rupert.learning.ChaosDrivenDevelopmentKata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrientationConverterTest {
		
		@Test
		public void northGives0() {
			OrientationConverter convert = new OrientationConverter();
			assertEquals(0, convert.convertToDegrees("N"));
		}
		
}
