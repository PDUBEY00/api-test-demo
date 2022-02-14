package payments.apiengine;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import payments.dataentities.requests.AuthRequests;
import payments.dataentities.requests.CreateConversionDetailsRequest;
import payments.dataentities.requests.GetRateDetailsRequest;
import payments.dataentities.responses.AuthToken;
import payments.dataprovider.ConfigFileReader;

public class EndPoints {

	public EndPoints(String baseUrl) {
		RestAssured.baseURI = baseUrl;
	}

	public String authenticateUser(AuthRequests requestDetails) {
		//method to call Authenticate api
		Response response = RestAssured.given()
				.contentType("multipart/form-data")
				.multiPart("login_id", ConfigFileReader.getInstance().getLoginId())
				.multiPart("api_key", ConfigFileReader.getInstance().getApiKey())
				.post("/v2/authenticate/api");
				//.post(UrlGenerator.generateToken());
		if (response.statusCode() != 200) {
			throw new RuntimeException(
					"Authentication Failed. Content of failed Response: " + response.asString() + " , Status Code : " + response.statusCode());
		}
		AuthToken token = response.as(AuthToken.class);
		return token.getAuthToken();
	}

	public Response getMarketRate(GetRateDetailsRequest getRateDetailsRequest, String token) {
		//method to call get Detailed rate api
		return RestAssured.given()
				.queryParam("buy_currency", getRateDetailsRequest.getBuyCurrency())
				.queryParam("sell_currency", getRateDetailsRequest.getSellCurrency())
				.queryParam("fixed_side", getRateDetailsRequest.getFixedSide())
				.queryParam("amount", getRateDetailsRequest.getAmount())
				.header("X-Auth-Token", token)
				.when()
				.get("/v2/rates/detailed");
	}

	public Response createConversionQuote(CreateConversionDetailsRequest createConversionDetailsRequest, String token) {
        // method to call create conversion api
		return RestAssured.given()
				.contentType("multipart/form-data")
				.header("X-Auth-Token", token)
				.multiPart("buy_currency", createConversionDetailsRequest.getBuyCurrency())
				.multiPart("sell_currency", createConversionDetailsRequest.getSellCurrency())
				.multiPart("fixed_side", createConversionDetailsRequest.getFixedSide())
				.multiPart("amount", createConversionDetailsRequest.getAmount())
				.multiPart("reason", createConversionDetailsRequest.getReason())
				.multiPart("term_agreement", createConversionDetailsRequest.getTermAgreement())
				.post("/v2/conversions/create");
	}

	public Response closeConnection(String token) {
		//method to call close connection api
		return RestAssured.given()
				.header("X-Auth-Token", token)
				.when()
				.post(UrlGenerator.closeSession());
	}
}
