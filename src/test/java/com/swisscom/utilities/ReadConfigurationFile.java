package com.swisscom.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigurationFile {

	Properties pro;

	public ReadConfigurationFile() {
		File file = new File("./configs/configuration.properties");

		try {
			FileInputStream ip = new FileInputStream(file);
			pro = new Properties();
			pro.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getEnvironmentType() {
		return pro.getProperty("env");

	}
	
	public String getDriverType() {
		return pro.getProperty("driver");
	}

	public String getDriverPath(String driverType) {
		return pro.getProperty(driverType);
	}

}
