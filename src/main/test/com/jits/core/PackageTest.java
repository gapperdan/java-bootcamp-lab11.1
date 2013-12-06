package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Address;
import com.jits.core.Box;
import com.jits.core.Letter;
import com.jits.core.Package;

public class PackageTest {

	Package pkg;
	
	@Before
	public void setup() {
		pkg = new Package();
	}
	
	@Test
	public void testShipmentApproved() {
		pkg.setPackageStatus(Package.PACKAGE_STATUS.APPROVED);
		assertEquals(Package.PACKAGE_STATUS.APPROVED, pkg.getPackageStatus());
	}
	 
	@Test
	public void testShipmentCancelled() {
		pkg.setPackageStatus(Package.PACKAGE_STATUS.CANCELLED);
		assertEquals(Package.PACKAGE_STATUS.CANCELLED, pkg.getPackageStatus());
	}
	
	@Test
	public void testShipmentShipped() {
		pkg.setPackageStatus(Package.PACKAGE_STATUS.SHIPPED);
		assertEquals(Package.PACKAGE_STATUS.SHIPPED, pkg.getPackageStatus());
	}

	@Test
	public void testPackageIsNotNull() {
		assertNotNull(pkg);
	}

	@Test
	public void testPackageHasId() {
		pkg.setId("valid id");
		assertTrue(pkg.isValid());
	
	}
	
	@Test
	public void testPackageHasInvalidId() {
		pkg.setId("");
		assertFalse(pkg.isValid());
		
		pkg.setId(null);
		assertFalse(pkg.isValid());
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
		pkg.setDestination(dest);
		assertNotNull(pkg.getDestination());
	}

	@Test
	public void testPackageHasOrigin() {
		Address origin = new Address(
				"Another Person",
				"123 Aywhere St.",
				"San Francisco",
				"CA",
				"94105");
		pkg.setOrigin(origin);
		assertNotNull(pkg.getOrigin());
	}

	@Test
	public void testPackageAirDelivery() {
		pkg.setDeliveryType(Package.DELIVERY_TYPE.AIR);
		assertEquals(Package.DELIVERY_TYPE.AIR, pkg.getDeliveryType());
	}

	@Test
	public void testPackageGroundDelivery() {
		pkg.setDeliveryType(Package.DELIVERY_TYPE.GROUND);
		assertEquals(Package.DELIVERY_TYPE.GROUND, pkg.getDeliveryType());
	}
	
}
