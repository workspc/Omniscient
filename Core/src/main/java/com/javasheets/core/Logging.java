package com.javasheets.core;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class Logging {

	private static final Logger logger = Logger.getLogger(Logging.class);

	public void log() {

		logger.trace("Hello Trace");
		logger.debug("Hello Debug");
		logger.info("Hello Info");
		logger.warn("Hello Warn");
		logger.error("Hello Error");
		logger.fatal("Hello Fatal");
	}
}
