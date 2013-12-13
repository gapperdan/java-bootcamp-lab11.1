package com.jits.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LetterTest {

	private Letter letter;
	
	@Before
	public void setUp() {
		letter = (Letter) ParcelFactory.createParcel(Letter.LETTER);
	}
	
	@Test
	public void testLetterIsNotNull() {
		assertTrue(letter instanceof Letter); 
	}
	
	@Test
	public void testFireProofLetter() {
		letter.setType(LetterType.fire);
		assertEquals(LetterType.fire,  letter.getType()); 
	}

	@Test
	public void testPlainLetter() {
		letter.setType(LetterType.plain);
		assertEquals(LetterType.plain,  letter.getType()); 
	}

	@Test
	public void testWeatherProofLetter() {
		letter.setType(LetterType.weather);
		assertEquals(LetterType.weather,  letter.getType()); 
	}

	@Test
	public void testLetterHasVolume() {
		assertEquals(1.0, letter.getVolume(), 0.0);
	}
	
	@Test
	public void testLetterIsNotInsurable() {
		assertFalse(letter.isInsurable());
	}

}
