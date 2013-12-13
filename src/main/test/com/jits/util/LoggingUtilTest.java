package com.jits.util;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Confirmation;

public class LoggingUtilTest {
	Confirmation c;
	
	@Before
	public void setup() {
		c = new Confirmation();
	}
	
	@Test
	public void test() {
		LoggingUtil.log(c);
	}

}
