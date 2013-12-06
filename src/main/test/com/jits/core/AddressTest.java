package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jits.core.Address;

public class AddressTest {

	Address address;
	
	@Test
	public void testAddressIsValid() {
		address = new Address(
				"Some Person",
				"555 Broken Dreams Blvd.",
				"San Francisco",
				"CA",
				"94105");
		
		assertNotNull(address.getName());
		assertNotNull(address.getStreet());
		assertNotNull(address.getCity());
		assertNotNull(address.getState());
		assertNotNull(address.getZip());
		
	}

	@Test
	public void testAddressEmptyName() {
		address = new Address("","some street", "some city", "some state", "some zip");
		assertFalse(address.isValid());
		
		address = new Address(null,"some street", "some city", "some state", "some zip");
		assertFalse(address.isValid());
	}
	
	@Test
	public void testAddressEmptyStreet() {
		address = new Address("some name","", "some city", "some state", "some zip");
		assertFalse(address.isValid());
		
		address = new Address("some name", "", "some city", "some state", "some zip");
		assertFalse(address.isValid());
	}
	
	@Test
	public void testAddressEmptyCity() {
		address = new Address("some name","some street", "", "some state", "some zip");
		assertFalse(address.isValid());

		address = new Address("some name","some street", null, "some state", "some zip");
		assertFalse(address.isValid());
	}
	
	@Test
	public void testAddressEmptyState() {
		address = new Address("some name","some street", "some city", "", "some zip");
		assertFalse(address.isValid());

		address = new Address("some name","some street", "some city", null, "some zip");
		assertFalse(address.isValid());
	}
	
	@Test
	public void testAddressEmptyZip() {
		address = new Address("some name","some street", "some city", "some state", "");
		assertFalse(address.isValid());

		address = new Address("some name","some street", "some city", "some state", null);
		assertFalse(address.isValid());
	}
}
