package com.jits.core;

public class Box extends Parcel {
	
	final static String BOX = "box";
	
	int width;
	int depth;
	int height;
 
	public double getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isValidDimensions() {
		return (height > 0 && depth > 0 && width > 0);
	}
}
