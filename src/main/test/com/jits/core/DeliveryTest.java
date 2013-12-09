package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeliveryTest {
	private Delivery delivery;
	private Parcel parcel;

	@Before
	public void setup() {
		delivery = new Delivery();
		parcel = (Box) ParcelFactory.createParcel("box");
		
	}
	@Test
	public void testDeliveryHasAParcel() {
		delivery.setParcel(parcel);
		assertNotNull(delivery.getParcel());
	}
	
	@Test
	public void testDeliveryHasAGroundMethod() {
		delivery.setDeliveryMethod(DeliveryMethod.GROUND);
		assertEquals(DeliveryMethod.GROUND, delivery.getDeliveryMethod());
	}

}
