package com.javasheets.core;

import org.junit.BeforeClass;
import org.junit.Test;

public class LoggingTest {

	private static Logging logging;

	@BeforeClass
	public static void init() {
		logging = new Logging();
	}

	@Test
	public void testLog() {
		logging.log();
	}
}
