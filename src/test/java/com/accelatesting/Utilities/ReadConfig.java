package com.accelatesting.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getChromeDriverPath() {
		String chromepath = pro.getProperty("chromedriverpath");
		return chromepath;
	}

	public String getFireFoxDriverPath() {
		String firefoxpath = pro.getProperty("firefoxdriverpath");
		return firefoxpath;
	}
}
