package com.jits.core;

public class ParcelFactory {
	
	public static Parcel createParcel(String type) {
		
		Parcel parcel;
		
		if ("box".equalsIgnoreCase(type)) {
			parcel = new Box();
		} else if ("letter".equalsIgnoreCase(type)) {
			parcel = new Letter();
		} else {
			parcel = null;
		}
		
		return parcel;
	}

}
