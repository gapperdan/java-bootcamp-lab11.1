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
		parcel.setPackageStatus(Parcel.PackageStatus.APPROVED);
		assertEquals(Parcel.PackageStatus.APPROVED, parcel.getPackageStatus());
	}
	 
	@Test
	public void testShipmentCancelled() {
		parcel.setPackageStatus(Parcel.PackageStatus.CANCELLED);
		assertEquals(Parcel.PackageStatus.CANCELLED, parcel.getPackageStatus());
	}
	
	@Test
	public void testShipmentShipped() {
		parcel.setPackageStatus(Parcel.PackageStatus.SHIPPED);
		assertEquals(Parcel.PackageStatus.SHIPPED, parcel.getPackageStatus());
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
		parcel.setDeliveryType(Parcel.DeliveryMethod.AIR);
		assertEquals(Parcel.DeliveryMethod.AIR, parcel.getDeliveryType());
	}

	@Test
	public void testPackageGroundDelivery() {
		parcel.setDeliveryType(Parcel.DeliveryMethod.GROUND);
		assertEquals(Parcel.DeliveryMethod.GROUND, parcel.getDeliveryType());
	}
	
}
