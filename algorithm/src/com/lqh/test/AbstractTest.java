package com.lqh.test;

import java.util.logging.Logger;

import org.junit.BeforeClass;


public abstract class AbstractTest {

	protected static Logger LOGGER;

	@BeforeClass
	public static void initTest() {
		initLogger(AbstractTest.class);
	}

	protected static void initLogger(Class<?> clazz) {
		LOGGER = Logger.getLogger(clazz.getSimpleName());
	}
	
	protected static void info(String message) {
		LOGGER.info(message);
	}

	protected static void fail(String message, Throwable t) {
		LOGGER.severe(message);
		throw new RuntimeException(message, t);
	}

	protected static void fail(String message) {
		fail(message, null);
	}
}
