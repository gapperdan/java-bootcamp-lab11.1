package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RailDeliveryTest {

	private RailDelivery delivery;
	private Parcel parcel;

	@Before
	public void setup() {
		delivery = new RailDelivery();
		parcel = (Box) ParcelFactory.createParcel("box");
	}
	
	@Test
	public void testDeliveryHasAParcel() {
		delivery.setParcel(parcel);
		assertNotNull(delivery.getParcel());
	}

}
