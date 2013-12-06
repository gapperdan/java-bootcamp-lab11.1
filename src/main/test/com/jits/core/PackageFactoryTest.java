package com.jits.core;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PackageFactoryTest {

	@Test
	public void testForInstanceOfBox() {
		Package pkg = PackageFactory.createPackage("box");
		assertTrue (pkg instanceof Box);
	}
	
	@Test
	public void testForInstanceOfLetter() {
		Package pkg = PackageFactory.createPackage("letter");
		assertTrue (pkg instanceof Letter);
	}
	
}
