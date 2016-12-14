package com.ycc.redbabyserver.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	private static Properties prop = null;
	private ConfigUtil() {
	}
	static{
		try {
			prop = new Properties();
			prop.load(new FileReader(ConfigUtil.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getConfig(){
		return prop;
	}
	
	public static String getProp(String name){
		return prop.getProperty(name);
	}
	
}
