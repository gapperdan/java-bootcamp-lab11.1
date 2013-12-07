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
		parcel = ParcelFactory.createParcel("box");
		delivery.setParcel(parcel);
	}

	@Test
	public void testDeliveryHasAParcel() {
		delivery.setParcel(parcel);
		assertNotNull(delivery.getParcel());
	}

}
