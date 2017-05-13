package com.omniscient.oldconf;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ApacheCommonsConf_1_10 {

	private static CompositeConfiguration config;

	public ApacheCommonsConf_1_10() {
		config = new CompositeConfiguration();
		try {
			config.addConfiguration(new PropertiesConfiguration("index.properties"));
		} catch (ConfigurationException e) {
			e.printStackTrace();
			System.exit(1001);
		}
	}

	public static void main(String[] args) {

		new ApacheCommonsConf_1_10();

		List<Object> hobbies = config.getList("test.1.hobbies");
		for (Object hobby : hobbies)
			System.out.println(hobby);

		Iterator<String> keys = config.getKeys();
		while (keys.hasNext())
			System.out.println(keys.next());
		
		System.out.println("------------------------------------------------------------------");

		Configuration sub = config.subset("test.1");
		Iterator<String> subKeys = sub.getKeys();
		while (subKeys.hasNext())
			System.out.println(subKeys.next());
	}
}
