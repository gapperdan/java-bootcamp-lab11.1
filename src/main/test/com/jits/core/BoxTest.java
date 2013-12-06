package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Box;

public class BoxTest {
	
	Box box;
	
	@Before
	public void setup() {
		box = new Box();	
	}

	@Test
	public void testBoxIsNotNull() {
		assertNotNull(box);
	}

	@Test
	public void testBoxHasValidDimensions() {
		box.setHeight(1.0);
		box.setWidth(1.0);
		box.setDepth(2.0);
		assertNotEquals(0.0, (box.getHeight() * box.getWidth() * box.getDepth()), 0.0);
	}
	
	@Test
	public void testBoxforInvalidDimensions() {
		box.setHeight(-1.0);
		box.setWidth(0.0);
		box.setDepth(0.0);
		assertFalse(box.isValid());
	}
	
}
