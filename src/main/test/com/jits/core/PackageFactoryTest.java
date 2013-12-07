package com.jits.core;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PackageFactoryTest {

	@Test
	public void testForInstanceOfBox() {
		Parcel parcel = ParcelFactory.createParcel("box");
		assertTrue (parcel instanceof Box);
	}
	
	@Test
	public void testForInstanceOfLetter() {
		Parcel parcel = ParcelFactory.createParcel("letter");
		assertTrue (parcel instanceof Letter);
	}
	
}
