package com.jits.util;

import com.jits.core.DeliveryMethod;

public interface ICalculator {
	abstract public double calculateDeliveryTime(String fromZip, String toZip,
			DeliveryMethod deliveryMethod); 
	abstract public double applyInsurance(double cost, double rate);
	abstract public double calculateShippingCost(String fromZip, String toZip,
			DeliveryMethod deliveryMethod, double weight, double volume);
}
