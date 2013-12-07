package com.jits.core;

public class Letter extends Parcel {

	public enum LETTER_TYPE {
		FIREPROOF, WEATHERPROOF, PLAIN
	}

	LETTER_TYPE type;
	
	public LETTER_TYPE getType() {
		return this.type;
	}

	public void setType(LETTER_TYPE type) {
		this.type = type;
	}
}
