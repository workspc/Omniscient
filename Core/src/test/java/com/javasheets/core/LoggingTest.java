package com.javasheets.core;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is the test class for testing the logging framework working. In order
 * for this class to work properly you need to have following arguments<br>
 * <br>
 * <b>JVM: </b><em>-Dlog4j.configuration=log4j.properties</em><br>
 * <b>Conversion pattern: </b><em> %d{yyyyMMdd,hh.mm.ss} [%-5p] - (%l)
 * %m%n</em><br>
 * <b>Output: </b><em>20170325,11.10.43 [TRACE] -
 * (com.javasheets.core.Logging.log(Logging.java:15)) Hello Trace</em><br>
 * <p>
 * Level of precedence is defined inside the {@link Logging#log()} method. Also
 * defined here
 * <ul>
 * <li><b>[TRACE]</b> Very minute details to be logged here
 * <li><b>[DEBUG]</b> Minute details to be logged here for debugging application
 * in development environments.
 * <li><b>[INFO ]</b> Only useful information details to be logged here
 * <li><b>[WARN ]</b> Only warnings to be logged here or suggestions
 * <li><b>[ERROR]</b> Situation that can result into errors must be logged here
 * <li><b>[FATAL]</b> Things that can halt application to be logged here
 * </ul>
 * 
 * @author Gagandeep Singh
 * @version 1.0
 * @since 20170325
 *
 */
public class LoggingTest {

	/*
	 * This is the class reference which needs to be tested.
	 */
	private static Logging logging;

	/**
	 * We are initializing the reference variable. This is the JUnits way of
	 * doing things. Runs before the class is loaded.
	 */
	@BeforeClass
	public static void init() {
		logging = new Logging();
	}

	/**
	 * Actual test. Simply calls the log method and you can check the output on
	 * the console.
	 */
	@Test
	public void testLog() {
		logging.log();
	}
}
