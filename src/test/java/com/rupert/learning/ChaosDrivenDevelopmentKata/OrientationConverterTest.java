package com.rupert.learning.ChaosDrivenDevelopmentKata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrientationConverterTest {
		
	@Test
	public void northGives0() {
		OrientationConverter convert = new OrientationConverter();
		assertEquals(0, convert.convertToDegrees("N"));
	}
	
	@Test
	public void eastGives90() {
		OrientationConverter convert = new OrientationConverter();
		assertEquals(90, convert.convertToDegrees("E"));
	}
	
	@Test
	public void southGives180() {
		OrientationConverter convert = new OrientationConverter();
		assertEquals(180, convert.convertToDegrees("S"));
	}
	
	@Test
	public void westGives270() {
		OrientationConverter convert = new OrientationConverter();
		assertEquals(270, convert.convertToDegrees("W"));
	}
		
}
