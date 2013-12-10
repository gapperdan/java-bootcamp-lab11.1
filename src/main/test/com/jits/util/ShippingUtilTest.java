package com.jits.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jits.core.DeliveryMethod;

public class ShippingUtilTest {


	@Test
	public void testDeliveryTimeForGround() {
		
		double deliveryTime = ShippingUtil.calculateDeliveryTime("94122", "74126", DeliveryMethod.GROUND);
		assertEquals(2.0, deliveryTime, 0.0);

		deliveryTime = ShippingUtil.calculateDeliveryTime("10001", "99999", DeliveryMethod.GROUND);
		assertEquals(6.0, deliveryTime, 0.0);

		deliveryTime = ShippingUtil.calculateDeliveryTime("10001", "10001", DeliveryMethod.GROUND);
		assertEquals(2.0, deliveryTime, 0.0);

	}

	@Test
	public void testDeliveryTimeForAir() {
		
		double deliveryTime = ShippingUtil.calculateDeliveryTime("94122", "74126", DeliveryMethod.AIR);
		assertEquals(0.5, deliveryTime, 0.0);
		
		deliveryTime = ShippingUtil.calculateDeliveryTime("74126", "94122", DeliveryMethod.AIR);
		assertEquals(0.5, deliveryTime, 0.0);
		
		deliveryTime = ShippingUtil.calculateDeliveryTime("94122", "94122", DeliveryMethod.AIR);
		assertEquals(0.25, deliveryTime, 0.0);
		
		
	}
}
