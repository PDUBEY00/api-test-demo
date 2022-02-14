package payments.apiengine;

public class UrlGenerator {

	// class to generate url
	private static final String AUTHENTICATE = "/authenticate";
	private static final String RATE = "/rates";
	private static final String CONVERSION = "/conversions";
	private static final String VERSION = "/v2";



	public static String generateToken(){
		return VERSION + AUTHENTICATE + "/api";
	}

	public static String detailedRate(){
		return VERSION + RATE + "/detailed";
		///v2/rates/detailed
	}

	public static String conversionRate(){
		return VERSION + CONVERSION + "/create";
	}

	public static String closeSession(){
		return VERSION + AUTHENTICATE + "/close_session";
	}

}


