package com.jits.core;
import com.thirdParty.calibration.MailScale;

public class MailScaleAdapter {
	
	public double weighPackage(Parcel parcel) {
		MailScale scale = new MailScale();
		double weight = scale.calculateWeight(parcel);
		return weight;
	}
}
