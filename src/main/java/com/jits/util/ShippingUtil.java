package com.jits.util;

import java.util.NavigableMap;
import java.util.TreeMap;

import com.jits.core.DeliveryMethod;

public class ShippingUtil {
	
	static final NavigableMap<Integer, Integer> timeZoneMap = new TreeMap<Integer, Integer>();
	static {
		timeZoneMap.put(2, 1);
		timeZoneMap.put(5, 2);
		timeZoneMap.put(7, 3);
		timeZoneMap.put(9, 4);
	}
	
	final static double ZONE_FACTOR_AIR = 0.25;
	final static double ZONE_FACTOR_GROUND = 2.0;

	public static double calculateDeliveryTime(String fromZip, String toZip,
			DeliveryMethod deliveryMethod) {
		int zoneDiff = calculateZoneDifference(fromZip, toZip, deliveryMethod);
		double zoneFactor = 0.0;
		
		if (deliveryMethod.equals(DeliveryMethod.AIR)) {
			zoneFactor = ZONE_FACTOR_AIR;
		} else if (deliveryMethod.equals(DeliveryMethod.GROUND)) {
			zoneFactor = ZONE_FACTOR_GROUND;
		}
 
		return zoneFactor * zoneDiff;
	}
	
	public static double calculateShippingCost(String fromZip, String toZip,
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
		}
		
		return shippingCost;
	}
	
	static int calculateZoneDifference(String fromZip, String toZip,
			DeliveryMethod deliveryMethod) {
		int from = Integer.parseInt(fromZip.substring(0, 1));
		int to = Integer.parseInt(toZip.substring(0, 1));
		
		int zoneDiff = 0;
		
		if (DeliveryMethod.AIR.equals(deliveryMethod)) {
			zoneDiff = Math.abs(to - from);
		} else if (DeliveryMethod.GROUND.equals(deliveryMethod)) {
			zoneDiff = Math.abs(getTimeZone(from) - getTimeZone(to));
		}
		
		if (zoneDiff == 0) {
			zoneDiff++;
		}
		
		return zoneDiff;
	}
	
	static int getTimeZone(int firstDigit) {
		int timeZone = 0;
		
		timeZone = timeZoneMap.get(timeZoneMap.ceilingKey((firstDigit)));
		return timeZone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShippingUtil []");
		return builder.toString();
	}
	
}
