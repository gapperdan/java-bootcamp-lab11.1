package com.jits.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jits.core.DeliveryMethod;

public class ShippingUtilTest {
	
	double deliveryTime;
	double shippingCost;

	@Test
	public void testDeliveryTimeForGround() {
		deliveryTime = ShippingUtil.calculateDeliveryTime("94122", "74126", DeliveryMethod.GROUND);
		assertEquals(2.0, deliveryTime, 0.0);

		deliveryTime = ShippingUtil.calculateDeliveryTime("10001", "99999", DeliveryMethod.GROUND);
		assertEquals(6.0, deliveryTime, 0.0);

		deliveryTime = ShippingUtil.calculateDeliveryTime("10001", "10001", DeliveryMethod.GROUND);
		assertEquals(2.0, deliveryTime, 0.0);
	}

	@Test
	public void testDeliveryTimeForAir() {
		deliveryTime = ShippingUtil.calculateDeliveryTime("94122", "74126", DeliveryMethod.AIR);
		assertEquals(0.5, deliveryTime, 0.0);
		
		deliveryTime = ShippingUtil.calculateDeliveryTime("74126", "94122", DeliveryMethod.AIR);
		assertEquals(0.5, deliveryTime, 0.0);
		
		deliveryTime = ShippingUtil.calculateDeliveryTime("94122", "94122", DeliveryMethod.AIR);
		assertEquals(0.25, deliveryTime, 0.0);
	}
	
	@Test
	public void testShippingCostForAir() {
		shippingCost = ShippingUtil.calculateShippingCost("11111", "11111", DeliveryMethod.AIR, 1.0, 1.0);
		assertEquals(1.0, shippingCost, 0.0);
		
		shippingCost = ShippingUtil.calculateShippingCost("11111", "11111", DeliveryMethod.AIR, 0.0, 1.0);
		assertEquals(1.0, shippingCost, 0.0);
		
		shippingCost = ShippingUtil.calculateShippingCost("11111", "11111", DeliveryMethod.AIR, 1.0, 0.0);
		assertEquals(1.0, shippingCost, 0.0);
		
		shippingCost = ShippingUtil.calculateShippingCost("11111", "33333", DeliveryMethod.AIR, 2.0, 2.0);
		assertEquals(8.0, shippingCost, 0.0);
	}
	
	@Test
	public void testShippingCostForGround() {
		shippingCost = ShippingUtil.calculateShippingCost("11111", "11111", DeliveryMethod.GROUND, 1.0, 1.0);
		assertEquals(1.0, shippingCost, 0.0);
		
		shippingCost = ShippingUtil.calculateShippingCost("11111", "11111", DeliveryMethod.GROUND, 0.0, 1.0);
		assertEquals(1.0, shippingCost, 0.0);
		
		shippingCost = ShippingUtil.calculateShippingCost("11111", "11111", DeliveryMethod.GROUND, 1.0, 0.0);
		assertEquals(1.0, shippingCost, 0.0);
		
		shippingCost = ShippingUtil.calculateShippingCost("11111", "99999", DeliveryMethod.GROUND, 2.0, 2.0);
		assertEquals(6.0, shippingCost, 0.0);
	}
}
