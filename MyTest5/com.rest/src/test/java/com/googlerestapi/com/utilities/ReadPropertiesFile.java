package com.googlerestapi.com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadPropertiesFile {
	File file = new File("D:\\workspace\\com.rest\\Config.properties");
	Properties prop = null;
	InputStream input = new FileInputStream(file);
	
	public ReadPropertiesFile() throws IOException {
		prop = new Properties();
		prop.load(input);
	}
	
	public String getBaseURI() {
		return prop.getProperty("BaseURI");
	}
	
	public String getUIURL() {
		return prop.getProperty("UIURL");
	}
	
	public String getAPI() {
		return prop.getProperty("API");
	}
	
	public String getToken() {
		return prop.getProperty("Token");
	}
	
	public String getSubscriptionKey() {
		return prop.getProperty("SubscriptionKey");
	}

}
