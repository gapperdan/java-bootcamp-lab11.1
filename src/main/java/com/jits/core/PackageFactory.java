package com.jits.core;

public class PackageFactory {
	
	public static Package createPackage(String type) {
		
		Package pkg;
		
		if ("box".equalsIgnoreCase(type)) {
			pkg = new Box();
		} else if ("letter".equalsIgnoreCase(type)) {
			pkg = new Letter();
		} else {
			pkg = null;
		}
		
		return pkg;
	}

}
