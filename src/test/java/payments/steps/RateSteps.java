package payments.steps;

import io.cucumber.java.en.And;
import java.math.BigDecimal;
import payments.dataentities.requests.GetRateDetailsRequest;
import payments.dataentities.responses.RateQuotes;
import payments.enums.Context;
import payments.utilities.TestContext;

public class RateSteps extends BaseSteps {

	public RateSteps(TestContext testContext) {
		super(testContext);
	}

	@And("User is happy with market rate to {string} {double} {string} to buy {string}")
	public void userIsHappyWithMarketRateForTo(String fixedSide, double amount, String sellCurrency, String buyCurrency) {
		GetRateDetailsRequest getRateDetailsRequest = new GetRateDetailsRequest(fixedSide, BigDecimal.valueOf(amount) , sellCurrency, buyCurrency);
		String token =  (String) getScenarioContext().getContext(Context.AUTH_TOKEN);
		RateQuotes rate = getEndPoints().getMarketRate(getRateDetailsRequest, token).as(RateQuotes.class);
		getScenarioContext().setContext(Context.RATE_RESPONSE, rate);
	}
}
