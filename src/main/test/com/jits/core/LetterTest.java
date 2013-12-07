package com.jits.core;

import static org.junit.Assert.*;

import com.jits.core.Letter.*;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Letter;

public class LetterTest {

	private Letter letter;
	
	@Before
	public void setUp() {
		letter = (Letter) ParcelFactory.createParcel("letter");
	}
	
	@Test
	public void testLetterIsNotNull() {
		assertTrue(letter instanceof Letter); 
	}
	
	@Test
	public void testFireProofLetter() {
		letter.setType(LETTER_TYPE.FIREPROOF);
		assertEquals(LETTER_TYPE.FIREPROOF,  letter.getType()); 
	}

	@Test
	public void testPlainLetter() {
		letter.setType(LETTER_TYPE.PLAIN);
		assertEquals(LETTER_TYPE.PLAIN,  letter.getType()); 
	}

	@Test
	public void testWeatherProofLetter() {
		letter.setType(LETTER_TYPE.WEATHERPROOF);
		assertEquals(LETTER_TYPE.WEATHERPROOF,  letter.getType()); 
	}

}
