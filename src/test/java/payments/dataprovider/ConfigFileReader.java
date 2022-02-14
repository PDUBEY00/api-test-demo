package payments.dataprovider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

	private static ConfigFileReader configReader;
	private final Properties properties;

	private ConfigFileReader() {
		//to read the properties such as Base url , login details
		properties = new Properties();
		String propertyFilePath = "configs/Configuration.properties";
		try (InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertyFilePath)) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

	}

	public static ConfigFileReader getInstance() {
		if (configReader == null) {
			configReader = new ConfigFileReader();
		}
		return configReader;
	}

	public String getBaseUrl() {
		String baseUrl = properties.getProperty("base_Url");
		if (baseUrl != null) {
			return baseUrl;
		} else {
			throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
		}
	}

	public String getLoginId() {
		String loginId = properties.getProperty("loginId");
		if (loginId != null) {
			return loginId;
		} else {
			throw new RuntimeException("loginId not specified in the Configuration.properties file.");
		}
	}

	public String getApiKey() {
		String apiKey = properties.getProperty("apiKey");
		if (apiKey != null) {
			return apiKey;
		} else {
			throw new RuntimeException("api key not specified in the Configuration.properties file.");
		}
	}
}


