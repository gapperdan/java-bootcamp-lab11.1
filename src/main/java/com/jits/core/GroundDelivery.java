package com.jits.core;

import com.jits.util.ICalculator;
import com.jits.util.ShippingCalculatorProxy;

public class GroundDelivery extends Delivery {
	ICalculator calc = new ShippingCalculatorProxy();
	public void calculateDeliveryTime() {
		double deliveryTime = calc.calculateDeliveryTime(getFromZip(),
				getToZip(), DeliveryMethod.GROUND); 
		setDeliveryTime(deliveryTime);
	}
	
	public void calculateShippingCost() {
		Parcel parcel = getParcel();
		double shippingCost = calc.calculateShippingCost(getFromZip(),
				getToZip(), DeliveryMethod.GROUND, parcel.getWeight(),
				parcel.getVolume());
		setShippingCost(shippingCost);
	}
}