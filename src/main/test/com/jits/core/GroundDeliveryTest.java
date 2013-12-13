package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GroundDeliveryTest {
	
	private GroundDelivery delivery;
	private Parcel parcel;

	@Before
	public void setup() {
		delivery = new GroundDelivery();
		parcel = (Box) ParcelFactory.createParcel("box");
	}
	
	@Test
	public void testDeliveryHasAParcel() {
		delivery.setParcel(parcel);
		assertNotNull(delivery.getParcel());
	}
	
}
