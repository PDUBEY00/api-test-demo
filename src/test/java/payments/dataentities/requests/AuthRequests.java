package payments.dataentities.requests;

public class AuthRequests {

	private final String loginId;

	private final String apiKey;

	public AuthRequests(String loginId, String apiKey) {
		this.loginId = loginId;
		this.apiKey = apiKey;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getApiKey() {
		return apiKey;
	}

}


