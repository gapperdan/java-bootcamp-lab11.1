package com.jits.util;

import com.jits.core.DeliveryMethod;

public class ShippingCalculatorProxy implements ICalculator {

	ShippingCalculatorImpl calc = new ShippingCalculatorImpl();
	
	@Override
	public double calculateDeliveryTime(String fromZip, String toZip,
			DeliveryMethod deliveryMethod) {
		
		return calc.calculateDeliveryTime(fromZip, toZip, deliveryMethod);
	}

	@Override
	public double applyInsurance(double cost, double rate) {
		double totalCost = calc.applyInsurance(cost, rate);
		LoggingUtil.audit(totalCost);
		return totalCost;
	}

	@Override
	public double calculateShippingCost(String fromZip, String toZip,
			DeliveryMethod deliveryMethod, double weight, double volume) {
		double cost = calc.calculateShippingCost(fromZip, toZip, deliveryMethod, weight, volume);
		LoggingUtil.audit(cost);
		return calc.calculateShippingCost(fromZip, toZip, deliveryMethod, weight, volume);
	}
}
