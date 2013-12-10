package com.jits.util;

import com.jits.core.DeliveryMethod;

public class ShippingUtil {
	
	final static int TIMEZONE_ET = 1;
	final static int TIMEZONE_CT = 2;
	final static int TIMEZONE_MT = 3;
	final static int TIMEZONE_PT = 4;
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
		
		if (firstDigit <= 2) {
			timeZone = TIMEZONE_ET;
		} else if (firstDigit <= 5) {
			timeZone = TIMEZONE_CT;
		} else if (firstDigit <= 7) {
			timeZone = TIMEZONE_MT;
		} else if (firstDigit <= 9) {
			timeZone = TIMEZONE_PT;
		}
		
		return timeZone;
		
	}


}
