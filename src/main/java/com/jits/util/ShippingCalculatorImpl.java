package com.jits.util;

import java.util.NavigableMap;
import java.util.TreeMap;

import com.jits.core.DeliveryMethod;

public class ShippingCalculatorImpl implements ICalculator {
	
	static final NavigableMap<Integer, Integer> groundTimeZoneMap = new TreeMap<Integer, Integer>();
	static {
		groundTimeZoneMap.put(2, 1);
		groundTimeZoneMap.put(5, 2);
		groundTimeZoneMap.put(7, 3);
		groundTimeZoneMap.put(9, 4);
	}
	
	static final NavigableMap<Integer, Integer> railTimeZoneMap = new TreeMap<Integer, Integer>();
	static {
		railTimeZoneMap.put(4, 1);
		railTimeZoneMap.put(9, 2);
	}
	
	final static double ZONE_FACTOR_AIR = 0.25;
	final static double ZONE_FACTOR_GROUND = 2.0;
	final static double ZONE_FACTOR_RAIL = 2.5;
	final static double RAIL_FLAT_COST = 5.0;

	public double calculateDeliveryTime(String fromZip, String toZip,
			DeliveryMethod deliveryMethod) {
		int zoneDiff = calculateZoneDifference(fromZip, toZip, deliveryMethod);
		double zoneFactor = 0.0;
		
		if (deliveryMethod.equals(DeliveryMethod.AIR)) {
			zoneFactor = ZONE_FACTOR_AIR;
		} else if (deliveryMethod.equals(DeliveryMethod.GROUND)) {
			zoneFactor = ZONE_FACTOR_GROUND;
		} else if (deliveryMethod.equals(DeliveryMethod.RAIL)) {
			zoneFactor = ZONE_FACTOR_RAIL;
		}
		return  zoneFactor * zoneDiff;
	}

	public double applyInsurance(double cost, double rate) {
		return cost + (cost * rate);
	}
	
	public double calculateShippingCost(String fromZip, String toZip,
			DeliveryMethod deliveryMethod, double weight, double volume) {
		
		double shippingCost = 0.0;
		
		if (weight < 1.0) {
			weight = 1.0;
		}
		
		if (volume < 1.0) {
			volume = 1.0;
		}
		
		int zoneDiff = calculateZoneDifference(fromZip, toZip, deliveryMethod);
		
		if (deliveryMethod.equals(DeliveryMethod.AIR)) {
			shippingCost = zoneDiff * weight * volume;
		} else if (deliveryMethod.equals(DeliveryMethod.GROUND)) {
			shippingCost = zoneDiff * weight;
		} else if (deliveryMethod.equals(DeliveryMethod.RAIL)) {
			shippingCost = zoneDiff * RAIL_FLAT_COST;
		}
		
		return shippingCost;
	}
	
	int calculateZoneDifference(String fromZip, String toZip,
			DeliveryMethod deliveryMethod) {
		int from = Integer.parseInt(fromZip.substring(0, 1));
		int to = Integer.parseInt(toZip.substring(0, 1));
		
		int zoneDiff = 0;
		
		if (DeliveryMethod.AIR.equals(deliveryMethod)) {
			zoneDiff = Math.abs(to - from);
		} else if (DeliveryMethod.GROUND.equals(deliveryMethod)) {
			zoneDiff = Math.abs(getTimeZone(from, deliveryMethod) - getTimeZone(to, deliveryMethod));
		} else if (DeliveryMethod.RAIL.equals(deliveryMethod)) {
			zoneDiff = Math.abs(getTimeZone(from, deliveryMethod) - getTimeZone(to, deliveryMethod));
			zoneDiff++;
		}
		
		if (zoneDiff == 0) {
			zoneDiff++;
		}
		
		return zoneDiff;
	}
	
	int getTimeZone(int firstDigit, DeliveryMethod deliveryMethod) {
		int timeZone = 0;
		
		if (DeliveryMethod.GROUND.equals(deliveryMethod)) {
			timeZone = groundTimeZoneMap.get(groundTimeZoneMap.ceilingKey((firstDigit)));
		} else if (DeliveryMethod.RAIL.equals(deliveryMethod)){
			timeZone = railTimeZoneMap.get(railTimeZoneMap.ceilingKey((firstDigit)));
		}
		
		return timeZone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShippingUtil []");
		return builder.toString();
	}
	
}
