package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Address;
import com.jits.core.Box;
import com.jits.core.Letter;
import com.jits.core.Parcel;

public class ParcelTest {

	Parcel parcel;
	
	@Before
	public void setup() {
		parcel = ParcelFactory.createParcel("box");
	}
	
	@Test
	public void testPackageIsNotNull() {
		assertNotNull(parcel);
	}

	@Test
	public void testPackageHasId() {
		parcel.setId(1);
		assertEquals(1, parcel.getId());
	}
	
	@Test
	public void testPackageHasInvalidId() {
		parcel.setId(0);
		assertFalse(parcel.hasValidId());
	}
	
	@Test
	public void testPackageTypeBoxIsCreated() {
		Box box = new Box();
		assertNotNull(box);
	}
	
	@Test
	public void TestPackageTypeLetterIsCreated() {
		Letter letter = new Letter();
		assertNotNull(letter);
	}
	
	@Test
	public void testPackageHasDestination() {
		Address dest = new Address(
				"Some Person",
				"555 Broken Dreams Blvd",
				"San Francisco",
				"CA",
				"94105");
		parcel.setDestination(dest);
		assertNotNull(parcel.getDestination());
	}

	@Test
	public void testPackageHasOrigin() {
		Address origin = new Address(
				"Another Person",
				"123 Aywhere St.",
				"San Francisco",
				"CA",
				"94105");
		parcel.setOrigin(origin);
		assertNotNull(parcel.getOrigin());
	}

}
