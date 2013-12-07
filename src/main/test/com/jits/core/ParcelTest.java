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
	public void testShipmentApproved() {
		parcel.setPackageStatus(Parcel.PACKAGE_STATUS.APPROVED);
		assertEquals(Parcel.PACKAGE_STATUS.APPROVED, parcel.getPackageStatus());
	}
	 
	@Test
	public void testShipmentCancelled() {
		parcel.setPackageStatus(Parcel.PACKAGE_STATUS.CANCELLED);
		assertEquals(Parcel.PACKAGE_STATUS.CANCELLED, parcel.getPackageStatus());
	}
	
	@Test
	public void testShipmentShipped() {
		parcel.setPackageStatus(Parcel.PACKAGE_STATUS.SHIPPED);
		assertEquals(Parcel.PACKAGE_STATUS.SHIPPED, parcel.getPackageStatus());
	}

	@Test
	public void testPackageIsNotNull() {
		assertNotNull(parcel);
	}

	@Test
	public void testPackageHasId() {
		parcel.setId("valid id");
		assertTrue(parcel.hasValidId());
	}
	
	@Test
	public void testPackageHasInvalidId() {
		parcel.setId("");
		assertFalse(parcel.hasValidId());
		
		parcel.setId(null);
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
	public void testPackageAirDelivery() {
		parcel.setDeliveryType(Parcel.DELIVERY_TYPE.AIR);
		assertEquals(Parcel.DELIVERY_TYPE.AIR, parcel.getDeliveryType());
	}

	@Test
	public void testPackageGroundDelivery() {
		parcel.setDeliveryType(Parcel.DELIVERY_TYPE.GROUND);
		assertEquals(Parcel.DELIVERY_TYPE.GROUND, parcel.getDeliveryType());
	}
	
}
