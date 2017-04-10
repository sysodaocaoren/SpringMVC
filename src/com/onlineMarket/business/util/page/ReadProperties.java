package com.onlineMarket.business.util.page;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadProperties {
	
	private Map<String, String> props = new HashMap<String, String>();
	private String cfgFilePath = "/config.properties";
	private static String DAYS;

	public static String getDAYS() {
		return DAYS;
	}

	public static void setDAYS(String dAYS) {
		DAYS = dAYS;
	}

	private void readConf() {
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream(cfgFilePath));
		} catch (Exception e) {
			return;
		}
		Enumeration<Object> e = properties.keys();

		while (e.hasMoreElements()) {
			String keyO = (String) e.nextElement();
			String value = properties.getProperty(keyO);
			this.props.put(keyO, value);
		}
	}

	public void writeConf(String key, String value) {
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream(cfgFilePath));
			OutputStream fos = new FileOutputStream(getClass().getResource(cfgFilePath).getPath());
			properties.setProperty(key, value);
			properties.store(fos, "this is header");
			fos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public String getStrByParam(String param) {
		if (this.props.isEmpty())
			readConf();
		String paramValue = (String) this.props.get(param);
		setCfgFilePath(cfgFilePath);
		return paramValue;
	}

	public String getCfgFilePath() {
		return cfgFilePath;
	}

	public void setCfgFilePath(String cfgFilePath) {
		this.cfgFilePath = cfgFilePath;
	}

}

/*
 * Location: D:\EcodeSVN\webLand_jd\src_class\com.jar Qualified Name:
 * com.ecode.land.util.ReadProperties JD-Core Version: 0.6.2
 */