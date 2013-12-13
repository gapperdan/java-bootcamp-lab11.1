package com.jits.core;

import com.jits.util.ShippingCalculatorProxy;
import com.jits.util.ICalculator;

public class AirDelivery extends Delivery {
	ICalculator calc = new ShippingCalculatorProxy(); 
	public void calculateDeliveryTime() {
		double deliveryTime = calc.calculateDeliveryTime(getFromZip(),
				getToZip(), DeliveryMethod.AIR); 
		setDeliveryTime(deliveryTime);
	}
	
	public void calculateShippingCost() {
		Parcel parcel = getParcel();
		double shippingCost = calc.calculateShippingCost(getFromZip(),
				getToZip(), DeliveryMethod.AIR, parcel.getWeight(),
				parcel.getVolume());
		setShippingCost(shippingCost);
	}
}
