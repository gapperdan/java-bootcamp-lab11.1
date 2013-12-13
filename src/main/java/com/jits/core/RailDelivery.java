package com.jits.core;

import com.jits.util.ICalculator;
import com.jits.util.ShippingCalculatorProxy;

public class RailDelivery extends Delivery {
	ICalculator calc = new ShippingCalculatorProxy();

	public void calculateDeliveryTime() {
		double deliveryTime = calc.calculateDeliveryTime(getFromZip(),
				getToZip(), DeliveryMethod.RAIL); 
		setDeliveryTime(deliveryTime);
	}
	
	public void calculateShippingCost() {
		Parcel parcel = getParcel();
		double shippingCost = calc.calculateShippingCost(getFromZip(),
				getToZip(), DeliveryMethod.RAIL, parcel.getWeight(),
				parcel.getVolume());
		setShippingCost(shippingCost);
	}
}
