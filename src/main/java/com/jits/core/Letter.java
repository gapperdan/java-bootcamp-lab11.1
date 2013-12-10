package com.jits.core;

public class Letter extends Parcel {
	
	final static String LETTER = "letter";

	LetterType type;
	
	public LetterType getType() {
		return this.type;
	}

	public void setType(LetterType type) {
		this.type = type;
	}
	
	public double getVolume() {
		return 1.0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Letter [type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
}
