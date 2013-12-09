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
}
