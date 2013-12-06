package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jits.core.Letter;

public class LetterTest {

	@Test
	public void testLetterIsNotNull() {
		Letter letter = new Letter();
		assertNotNull(letter); 
	}
}
