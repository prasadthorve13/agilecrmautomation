package com.AgileCrmAutomation;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyHandlingClass 
{
	private Properties properties;
	
	public PropertyHandlingClass()
	{
		String configFilePath = System.getProperty("user.dir")+"//config.properties";
		try
		{
			FileInputStream input = new FileInputStream(configFilePath);
			properties = new Properties();
			properties.load(input);//load config file into Properties class to access properties
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getValues(String key)//Will return value using key from the properties file
	{
		return properties.getProperty(key);
	}
}