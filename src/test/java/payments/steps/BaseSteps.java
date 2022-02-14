package payments.steps;

import payments.apiengine.EndPoints;
import payments.utilities.ScenarioContext;
import payments.utilities.TestContext;

public class BaseSteps {
	private final EndPoints endPoints;
	private final ScenarioContext scenarioContext;

	public BaseSteps(TestContext testContext) {
		endPoints = testContext.getEndPoints();
		scenarioContext = testContext.getScenarioContext();
	}

	public EndPoints getEndPoints() {
		return endPoints;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
}
