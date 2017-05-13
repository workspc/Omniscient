package com.javasheets.core;

import org.apache.log4j.Logger;

/**
 * This class provides the usage of the logging. We are using the log4j1 as a
 * logging framework. In order for this class to work properly you need to have
 * following arguments<br>
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
public class Logging {

	/*
	 * This is how a logger is defined inside a class. Remember to replace the
	 * class name with the current class name before copying the statement.
	 */
	private static final Logger logger = Logger.getLogger(Logging.class);

	/**
	 * Will log all the possible logging levels and also states the logging
	 * precedence.
	 */
	public void log() {

		logger.trace("Hello Trace");
		logger.debug("Hello Debug");
		logger.info("Hello Info");
		logger.warn("Hello Warn");
		logger.error("Hello Error");
		logger.fatal("Hello Fatal");
	}
}
