package org.omni;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Property {

	public static Configuration prop = ApplicationContext.CONTEXT.instance();

	public enum ApplicationContext {

		CONTEXT() {

			private Configurations configs = new Configurations();
			public Configuration property = null;

			@Override
			public Configuration instance() {
				try {
					property = configs.properties(new File("swing.properties"));
				} catch (ConfigurationException ce) {
					ce.printStackTrace();
					System.exit(1);
				}
				return property;
			}
		};

		public abstract Configuration instance();
	}
}