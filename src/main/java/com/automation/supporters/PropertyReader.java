package com.automation.supporters;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertyReader {
	private String filepath;
	private FileInputStream fis;
	private Properties properties;
	private String value;

	public PropertyReader(String filepath) throws IOException {
		this.filepath = filepath;
		fis = new FileInputStream(filepath);

		properties = new Properties();
		properties.load(fis);
	}

	public String getStringvalue(String key) {
		if (properties != null) {
			value = properties.getProperty(key);
		} else {
			System.out.println("properties pointing null ");
		}

		return value;
	}

	public String getStringvalue(String key, String defaultvalue) {
		if (properties != null) {
			value = properties.getProperty(key);
			if (value == null) {
				value = defaultvalue;
			}
		} else {
			System.out.println("properties pointing null ");
		}

		return value;
	}

	public String getStringvalue(Object key) {
		if (properties != null) {
			value = (String) properties.get(key);
		} else {
			System.out.println("properties pointing null ");
		}

		return value;
	}

	public String getStringvalue(Object key, Object defaultvalue) {
		if (properties != null) {
			value = (String) properties.get(key);
			if (value == null) {
				value = (String) defaultvalue;
			}
		} else {
			System.out.println("properties pointing null ");
		}

		return value;

	}

	public void setpropertykeyvalue(String key, String value) throws IOException {
		properties.setProperty(key, value);
		FileOutputStream fos = new FileOutputStream(filepath);
		properties.store(fos, "file is saved");

	}
	public void setpropertykeyvalue(Object key, Object value) throws IOException {
		properties.put(key, value);
		FileOutputStream fos = new FileOutputStream(filepath);
		properties.store(fos, "file is saved");

	}


	public Map<String, String> getpropertydata() {
		Map<String, String> data = new LinkedHashMap<String, String>();
		Set<Object> keyset = properties.keySet();
		for (Object obj : keyset) {
			String keys = (String) obj;
			String value = properties.getProperty(keys);
			data.put(keys, value);
		}

		return data;
	}

	public Set<String> getKeys() {
		Set<String> keys = new LinkedHashSet<String>();
		Set<Object> keyset = properties.keySet();
		for (Object obj : keyset) {
			String key = (String) obj;
			keys.add(key);
		}
		return keys;
	}

	public List<String> getvalues() {
		List<String> values = new ArrayList<String>();
		Set<Object> keyset = properties.keySet();
		for (Object obj : keyset) {
			String key = (String) obj;
			String value = properties.getProperty(key);
			values.add(value);

		}
		return values;
	}

}
