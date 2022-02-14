package payments.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import payments.dataentities.requests.AuthRequests;
import payments.enums.Context;
import payments.utilities.TestContext;

public class AuthSteps extends BaseSteps {

	public AuthSteps(TestContext testContext) {
		super(testContext);
	}


	@Given("user is authenticated to access payment engine")
	public void user_is_authenticated_to_access_payment_engine() {
		AuthRequests authRequestsDetails = new AuthRequests((String) getScenarioContext().getContext(Context.LOGIN_ID)
				, (String) getScenarioContext().getContext(Context.API_KEY));
		String token =  getEndPoints().authenticateUser(authRequestsDetails);
		getScenarioContext().setContext(Context.AUTH_TOKEN, token);
	}

	@After
	public void closeSession() {
		System.out.println("****Closing session now");
		getEndPoints().closeConnection((String) getScenarioContext().getContext(Context.AUTH_TOKEN))
				.then()
				.statusCode(200);
	}

}
