package com.jits.core;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PackageFactoryTest {

	@Test
	public void testForInstanceOfBox() {
		Parcel parcel = ParcelFactory.createParcel(Box.BOX);
		assertTrue (parcel instanceof Box);
	}
	
	@Test
	public void testForInstanceOfLetter() {
		Parcel parcel = ParcelFactory.createParcel(Letter.LETTER);
		assertTrue (parcel instanceof Letter);
	}
	
}
