package com.jits.core;

public class Box extends Package {
	double width;
	double depth;
	double height;
 
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		
		this.depth = depth;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isValid() {
		return (height > 0.0 && depth > 0.0 && width > 0.0);
	}
}
