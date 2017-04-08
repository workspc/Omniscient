package com.omniscient.aconf;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.ex.ConversionException;

/**
 * Learning Apache Common Configuration 2
 * 
 * @author Gagandeep Singh
 *
 */
public class HelloConfiguration {

	private static Configurations configs = new Configurations();

	public static void _01_test() {

		Configuration config = null;
		try {
			config = configs.properties(new File("test.properties"));
		} catch (ConfigurationException ce) {
			ce.printStackTrace();
		}

		Configuration subTest = config.subset("test");
		Configuration sub = subTest.subset("2");
		System.out.println(sub.getString("name", "Unnamed"));
		System.out.println(sub.getBoolean("married", false));
		System.out.println(sub.getFloat("weight", 75.00F));
		System.out.println(sub.getInt("age", 18));

		List<Object> hobbies = sub.getList("hobbies");
		for (Object hobby : hobbies) {
			System.out.println(hobby);
		}

		Configuration subTest3 = config.subset("test");
		Configuration sub3 = subTest3.subset("3");
		System.out.println(sub3.getString("name", "Unnamed"));
		System.out.println(sub3.getBoolean("married", false));
		System.out.println(sub3.getFloat("weight", 75.00F));
		System.out.println(sub3.getInt("age", 18));

		List<Object> hobbies3 = sub3.getList("hobbies");
		for (Object hobby : hobbies3) {
			System.out.println(hobby);
		}

		Configuration test1 = config.subset("test.1");

		System.out.println(test1.getString("name", "Unnamed"));
		System.out.println(test1.getBoolean("married", false));
		System.out.println(test1.getFloat("weight", 75.00F));
		System.out.println(test1.getInt("age", 18));
		try {
			System.out.println(test1.getInt("name", 1987));
		} catch (ConversionException ce) {
			System.err.println("Property found but unable to convert");
		}
		System.out.println(test1.getInt("xyz", 1987));

		try {
			System.out.println(test1.getInt("propNotExisting"));
		} catch (NoSuchElementException e) {
			System.err.println("Property found but unable to convert");
		}
	}

	public static void main(String[] args) {

		_01_test();
	}
}
