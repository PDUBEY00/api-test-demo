package payments.dataentities.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class AuthToken {

	@JsonProperty("auth_token")
	private String authToken;


	public String getAuthToken() {
		return authToken;
	}


	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
