package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Box;

public class BoxTest {
	
	Box box;
	
	@Before
	public void setup() {
		box = (Box) ParcelFactory.createParcel(Box.BOX);
	}

	@Test
	public void testBoxIsNotNull() {
		assertNotNull(box);
	}

	@Test
	public void testBoxHasValidDimensions() {
		box.setHeight(1);
		box.setWidth(1);
		box.setDepth(2);
		assertNotEquals(0, (box.getHeight() * box.getWidth() * box.getDepth()));
	}
	
	@Test
	public void testBoxforInvalidDimensions() {
		box.setHeight(-1);
		box.setWidth(0);
		box.setDepth(0);
		assertFalse(box.isValidDimensions());
	}
	
}
