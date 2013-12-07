package com.jits.core;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DeliveryTest {
	private Delivery delivery;
	private Parcel parcel;

	@Test
	public void testDeliveryHasAParcel() {
		delivery = new Delivery();
		parcel = (Box) ParcelFactory.createParcel("box");
		delivery.setParcel(parcel);
		assertNotNull(delivery.getParcel());
	}

}
