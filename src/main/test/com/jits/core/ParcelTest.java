package com.jits.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

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
	
	@Test
	public void testPackageHasWeight() {
		
		parcel.setWeight(0.0);
		assertEquals(1.0, parcel.weighPackage(), 0);
		
		parcel.setWeight(0.9);
		assertEquals(1.0, parcel.weighPackage(), 0);
		
		parcel.setWeight(1.1);
		assertEquals(2.0, parcel.weighPackage(), 0);
		
		parcel.setWeight(1.5);
		assertEquals(2.0, parcel.weighPackage(), 0);
		
		parcel.setWeight(2.0);
		assertEquals(2.0, parcel.weighPackage(), 0);
		
	}
	
	@Test 
	public void test3rdPartyScale() {
		double w = parcel.calculateWeight(parcel);
		parcel.setWeight(w);
		assertEquals(w, parcel.getWeight(), 1.0);
	}
	
}
