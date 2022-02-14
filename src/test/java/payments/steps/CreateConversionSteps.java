package payments.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.Assert;
import payments.dataentities.requests.CreateConversionDetailsRequest;
import payments.dataentities.responses.ConversionQuotes;
import payments.dataentities.responses.RateQuotes;
import payments.enums.Context;
import payments.utilities.TestContext;

public class CreateConversionSteps extends BaseSteps {

	private ConversionQuotes finalQuotes;
	private Response response;

	public CreateConversionSteps(TestContext testContext) {
		super(testContext);
	}

	@When("user request a conversion quote to {string} {double} {string} to buy {string}")
	public void user_request_a_quote_for_buying_usd_for_gbp(String fixedSide, double amount, String sellCurrency, String buyCurrency) {
		String token = getScenarioContext().getContext(Context.AUTH_TOKEN).toString();
		CreateConversionDetailsRequest createConversionDetailsRequest = new CreateConversionDetailsRequest(fixedSide, BigDecimal.valueOf(amount),
																										   sellCurrency, buyCurrency, "Top up", true);
		response = getEndPoints().createConversionQuote(createConversionDetailsRequest, token);
		finalQuotes = response.as(ConversionQuotes.class);
	}

	@Then("user should be able to create quote without any issue")
	public void user_should_be_able_to_create_quote_without_any_issue() {
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("buy amount should be as per the market rate")
	public void buy_amount_should_be_as_per_the_market_rate() {
		RateQuotes rate = (RateQuotes) getScenarioContext().getContext(Context.RATE_RESPONSE);
		Assert.assertEquals("Buy price doesn't match to market rate", rate.getClientBuyAmount().setScale(2),
							finalQuotes.getClientBuyAmount().setScale(2));
	}

	@When("user requests a conversion quote with invalid {string} for {string}")
	public void userRequestsAConversionQuoteWithInvalid(String value, String parameter) {
		String token = getScenarioContext().getContext(Context.AUTH_TOKEN).toString();
		CreateConversionDetailsRequest createConversionDetailsRequest = new CreateConversionDetailsRequest("sell", BigDecimal.valueOf(100.10),
																										   "GBP", "USD", "Top up", true);
		switch (parameter) {
			case "fixed_side":
				createConversionDetailsRequest.setFixedSide(value);
				break;
			case "sell_currency":
				createConversionDetailsRequest.setSellCurrency(value);
				break;
			case "buy_currency":
				createConversionDetailsRequest.setBuyCurrency(value);
				break;
		}

		response = getEndPoints().createConversionQuote(createConversionDetailsRequest, token);
	}

	@Then("user should see error status {int} and {string} for supplied {string}")
	public void userShouldSeeErrorStatusAnd(int statusCode, String errorMessage, String parameter) {
		Assert.assertEquals(statusCode, response.getStatusCode());
		Map<String, String> responseMap = response.jsonPath().get("error_messages." + parameter + "[0]");
		Assert.assertEquals(errorMessage, responseMap.get("message"));
	}

}
