package com.omniscient.aconf;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.builder.fluent.PropertiesBuilderParameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.convert.ListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class HelloCommonsConfiguration {

	public static void main(String[] args) {

		File file = new File("index.properties");
		ListDelimiterHandler delimiter = new DefaultListDelimiterHandler(',');

		PropertiesBuilderParameters propertyParameters = new Parameters().properties();
		propertyParameters.setFile(file);
		propertyParameters.setThrowExceptionOnMissing(true);
		propertyParameters.setListDelimiterHandler(delimiter);

		FileBasedConfigurationBuilder<PropertiesConfiguration> builder = new FileBasedConfigurationBuilder<PropertiesConfiguration>(
				PropertiesConfiguration.class);

		builder.configure(propertyParameters);

		try {
			PropertiesConfiguration config = builder.getConfiguration();
			List<Object> hobbies = config.getList("test.1.hobbies");
			for (Object hobby : hobbies)
				System.out.println(hobby);

			Iterator<String> keys = config.getKeys();
			while (keys.hasNext())
				System.out.println(keys.next());

		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
}
